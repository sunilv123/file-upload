package com.thrymr.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.gridfs.GridFSDBFile;
import com.thrymr.models.MetaData;


@RestController
public class NewController {
	
	@Autowired
	private GridFsTemplate gridFsTemplate;
	
	@PostMapping(value = ("upload-file"), headers = ("content-type=multipart/*"))
	public String uploadFile(@RequestPart("file") MultipartFile multipartFile) throws Exception {
		
		final File file = this.convertMultiPartFileToFile(multipartFile);

		FileInputStream fileIS = new FileInputStream(file);
		
		/**
		 * @Note : Required dependency 
		 * 		<dependency>
    				<groupId>org.apache.poi</groupId>
    				<artifactId>poi</artifactId>
    				<version>3.7</version>
				</dependency>
		 * */
		//Get the workbook instance for XLS file 
		HSSFWorkbook workbook = new HSSFWorkbook(fileIS);

		//Get first sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(1);
		
		//Iterate through each rows from first sheet
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
				
				//For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						System.out.println(">>> " + cell.getStringCellValue());
					}
				}
		}
		fileIS.close();
		/**
		 * The file(which is no longer required) which has been created inside
		 * project will be deleted
		 */
		file.delete();
		
		// Store the file in database & return the id 
		return gridFsTemplate.store(multipartFile.getInputStream(), multipartFile.getOriginalFilename(),
				multipartFile.getContentType(), new MetaData()).getId().toString();
	}
	
	private File convertMultiPartFileToFile(final MultipartFile multipartFile) throws Exception {
		final File convFile = new File(multipartFile.getOriginalFilename());

		/**
		 * File gets created in the project (inside the target folder). The
		 * created file is required for reading it inside the addFilePart()
		 */
		convFile.createNewFile();
		final FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(multipartFile.getBytes());
		fos.close();
		return convFile;
	}
	
	@GetMapping("get-file/{fileId}")
	HttpEntity<byte[]> getFile(@PathVariable("fileId") String objectId, HttpServletResponse response)
			throws Exception {

		GridFSDBFile gridFSDBFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(objectId)));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf(gridFSDBFile.getContentType()));
		response.setHeader("Content-Disposition", "inline; filename=" + gridFSDBFile.getFilename());
		return new HttpEntity<byte[]>(IOUtils.toByteArray(gridFSDBFile.getInputStream()), headers);
	}
	
	@GetMapping("download-file/{fileId}")
	HttpEntity<byte[]> downloadFile(@PathVariable("fileId") String objectId, HttpServletResponse response)
			throws Exception {

		GridFSDBFile gridFSDBFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(objectId)));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf(gridFSDBFile.getContentType()));
		response.setHeader("Content-Disposition", "download; filename=" + gridFSDBFile.getFilename());
		return new HttpEntity<byte[]>(IOUtils.toByteArray(gridFSDBFile.getInputStream()), headers);
	}
}
