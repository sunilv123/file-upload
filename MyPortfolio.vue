<template>
  <div>
    <div class="wrapper">
        <admin-header></admin-header>
        <!-- <admin-sidebar></admin-sidebar> -->
      <div class="content-wrapper">

 <section class="content container-fluid admin-portfolio">

      <div class="row admin-portfolio-table">

      <div class="col-md-4 col-lg-4 col-sm-6 col-xs-12">


        <div class="table-responsive">
         <table  class="table table-hover acrylic data_table">
               <!-- <caption class="text-center table-heading">TOP GAINERS</caption> -->
             <thead>
                 <tr>
                   <th width="50">TOP GAINERS</th>
                   <th  width="20" class="text-right">% CHANGE</th>
                   <th  width="30" class="text-right">Drawing Power <a class="cursor-pointer pull-right" data-toggle="modal" data-target="#topGainersModal"><i class="fa fa-expand expand" aria-hidden="true"></i></a></th>
                 </tr>
             </thead>
             <tbody>

                <tr v-for="(gainerScrip, index) in gainerList">
                  <span v-if="index <= 4">
                    <td>{{gainerScrip.name}}</td>
                    <td class="positive-cost text-right">{{gainerScrip.percentChange}}</td>
                    <td class="text-right">{{gainerScrip.drawingPower}}</td>
                    </span>
                </tr>

              <!--   <tr>
                     <td>GMDCLTD</td>

                     <td class="positive-cost text-right">+7.48</td>
                     <td class="text-right">1,23,456</td>
                 </tr>
                 <tr>
                     <td>CESC</td>

                     <td class="positive-cost text-right">+5.78</td>
                     <td class="text-right">2,34,567</td>
                 </tr>
                 <tr>
                     <td>ADANITRANS</td>

                     <td class="positive-cost text-right">+4.00</td>
                     <td class="text-right">3,45,678</td>
                 </tr>
                 <tr>
                     <td>KEC</td>

                       <td class="positive-cost text-right"></i>+3.72</td>
                     <td class="text-right">4,56,789</td>
                 </tr>
                 <tr>
                     <td>COLPAL</td>

                       <td class="positive-cost text-right"></i>+3.59</td>
                     <td class="text-right">5,67,890</td>
                 </tr>
             -->
             </tbody>
         </table>
       </div>

   </div>


   <div class="col-md-4 col-lg-4 col-sm-6 col-xs-12">


     <div class="table-responsive">
      <table  class="table table-hover acrylic data_table">


          <thead>
              <tr>
                <th width="50">TOP LOSERS</th>
                <th width="20" class="text-right">% CHANGE</th>
                <th  width="30" class="text-right">Drawing Power <a class="cursor-pointer pull-right" data-toggle="modal" data-target="#loserModal"><i class="fa fa-expand expand" aria-hidden="true"></i></a></th>
              </tr>
          </thead>
          <tbody>

            <tr v-for="(loserScrip, index) in loserList">
                <span v-if="index <= 4">
                <td>{{loserScrip.name}}</td>
                <td class="positive-cost text-right">{{loserScrip.percentChange}}</td>
                <td class="text-right">{{loserScrip.drawingPower}}</td>
                </span>
            </tr>

            <!--  <tr>
                  <td>CUMMINSIND</td>
                  <td class="negative-cost text-right">-8.05</td>
                  <td class="text-right">1,23,456</td>
              </tr>
              <tr>
                  <td>UNITDSPR</td>
                  <td class="negative-cost text-right">-5.94</td>
                  <td class="text-right">2,34,567</td>
              </tr>
              <tr>
                  <td>SREINFRA</td>

                  <td class="negative-cost text-right">-5.23</td>
                  <td class="text-right">3,45,678</td>
              </tr>
              <tr>
                  <td>BEML</td>

                  <td class="negative-cost text-right">-4.95</td>
                  <td class="text-right">4,56,789</td>
              </tr>
              <tr>
                  <td>NAVKARCORP</td>

                  <td class="negative-cost text-right">-4.84</td>
                  <td class="text-right">5,67,890</td>
              </tr>
           -->
          </tbody>
      </table>
     </div>





   </div>

   <div class="col-md-4 col-lg-4 col-sm-6 col-xs-12">

     <div class="table-responsive">
      <table  class="table table-hover acrylic data_table">
          <thead>
              <tr>
                <th width="40">MARKET CAP</th>
                <th width="30" class="text-right">holding</th>
                <th  width="30" class="text-right"> VALUE
             </th>
              </tr>
          </thead>
          <tbody>
              <tr>
                <td style="padding: 9px"><a class="cursor-pointer" data-toggle="modal" data-target="#MarketModal">LARGE</a></td>
                <td style="padding: 9px"  class="text-right">6590</td>
                <td style="padding: 9px"  class="text-right">98,089</td>
              </tr>
              <tr>
                  <td style="padding: 9px"><a class="cursor-pointer" data-toggle="modal" data-target="#MarketModal">MEDIUM</a></td>

                <td style="padding: 9px"  class="text-right">3456</td>
                <td style="padding: 9px"  class="text-right">1,23,890</td>
              </tr>
              <tr>
             <td style="padding: 8px"><a class="cursor-pointer" data-toggle="modal" data-target="#MarketModal">SMALL</a></td>
                <td style="padding: 8px"  class="text-right">7890</td>
                <td style="padding: 8px"  class="text-right">10,90,789</td>
              </tr>


          </tbody>
      </table>
     </div>



 </div>
 </div>
 <div class="row admin-portfolio-table">
   <div class="col-md-4 col-lg-4 col-sm-6 col-xs-12">

     <div class="table-responsive">
      <table  class="table table-hover acrylic data_table">
         <!-- <caption class="text-center table-heading">CIRCUIT BREAKERS</caption> -->
          <thead>
              <tr>

                  <th width="42">circuit</th>
                  <th width="20" class="text-right no-sort">% change
                    <i class="fa fa-caret-up caret-fa color-green" aria-hidden="true" @click="showCircuit('true')" ></i>
                   <i class="fa fa-caret-down caret-fa color-red" aria-hidden="true" @click="showCircuit('false')"></i>
                  </th>
                  <th width="10" class="text-right">LIVE</th>
                  <th width="28" class="text-right">Drawing Power <a class="cursor-pointer pull-right" data-toggle="modal" data-target="#circuitBreakerAllModal"><i class="fa fa-expand expand" aria-hidden="true"></i></a></th>
              </tr>
          </thead>


          <tbody>


            <tr v-if="!toggleTopCircuit"   v-for="(loserScrip, index) in loserList">
              <span v-if="index <= 4">
                <td><a class="cursor-pointer" data-toggle="modal" @click= "openScripClientModal(loserScrip.scripId)">{{loserScrip.name}}</a></td>
                <td class="negative-cost text-right">{{loserScrip.percentChange}}</td>
                <td class="text-right">{{loserScrip.percentChange}}</td>
                <td class="text-right">{{loserScrip.drawingPower}}</td>
                </span>
            </tr>


               <tr v-if="toggleTopCircuit" v-for="(gainerScrip, index) in gainerList">
                   <span v-if="index <= 4">
                    <td><a class="cursor-pointer" data-toggle="modal"  @click= "openScripClientModal(gainerScrip.scripId)">{{gainerScrip.name}}</a></td>
                    <td class="positive-cost text-right"></i>{{gainerScrip.percentChange}}</td>
                    <td class="text-right">{{gainerScrip.percentChange}}</td>
                    <td class="text-right">{{gainerScrip.drawingPower}}</td>
                    </span>
               </tr>

   <!--
            <tr v-if="!toggleTopCircuit">
                <td><a class="cursor-pointer" data-toggle="modal" data-target="#ScripModal">MIPCO SEAMLESS</a></td>
                <td class="negative-cost text-right">-5.00</td>
                <td class="text-right">-4.90</td>
                <td class="text-right">5,67,890</td>
            </tr>
              <tr v-if="!toggleTopCircuit">
                  <td><a class="cursor-pointer" data-toggle="modal" data-target="#ScripModal">GLOBUS CORP</a></td>

                  <td class="negative-cost text-right">-7.69</td>
                 <td class="text-right">-7.00</td>
                  <td class="text-right">1,23,456</td>
              </tr>
              <tr v-if="!toggleTopCircuit">
                   <td><a class="cursor-pointer" data-toggle="modal" data-target="#ScripModal">VISESH INFOTECH</a></td>


                  <td class="negative-cost text-right">-5.88</td>
                   <td class="text-right">-5.50</td>
                  <td class="text-right">2,34,567</td>
              </tr>
              <tr v-if="!toggleTopCircuit">
                <td><a class="cursor-pointer" data-toggle="modal" data-target="#ScripModal">INDIAN INFOTECH</a></td>
                  <td class="negative-cost text-right">-5.00</td>
                   <td class="text-right">-5.50</td>
                  <td class="text-right">3,45,678</td>
              </tr>
              <tr v-if="!toggleTopCircuit">
                     <td><a class="cursor-pointer" data-toggle="modal" data-target="#ScripModal">EUROMULT</a></td>


                  <td class="negative-cost text-right"></i>-5.00</td>
                 <td class="text-right">-4.00</td>
                  <td class="text-right">4,56,789</td>
              </tr>
              <tr v-if="toggleTopCircuit">
                  <td><a class="cursor-pointer" data-toggle="modal" data-target="#ScripModal">MIPCO SEAMLESS</a></td>
                  <td class="positive-cost text-right">5.00</td>
                 <td class="text-right">5.5</td>
                  <td class="text-right">5,67,890</td>
              </tr>
                <tr v-if="toggleTopCircuit">
                    <td><a class="cursor-pointer" data-toggle="modal" data-target="#ScripModal">GLOBUS CORP</a></td>

                    <td class="positive-cost text-right">7.69</td>
                   <td class="text-right">4.50</td>
                    <td class="text-right">1,23,456</td>
                </tr>
                <tr v-if="toggleTopCircuit">
                     <td><a class="cursor-pointer" data-toggle="modal" data-target="#ScripModal">VISESH INFOTECH</a></td>


                    <td class="positive-cost text-right">5.88</td>
                     <td class="text-right">4.00</td>
                    <td class="text-right">2,34,567</td>
                </tr>
                <tr v-if="toggleTopCircuit">
                  <td><a class="cursor-pointer" data-toggle="modal" data-target="#ScripModal">INDIAN INFOTECH</a></td>
                    <td class="positive-cost text-right">5.00</td>
                     <td class="text-right">3.55</td>
                    <td class="text-right">3,45,678</td>
                </tr>
                <tr v-if="toggleTopCircuit">
                       <td><a class="cursor-pointer" data-toggle="modal" data-target="#ScripModal">EUROMULT</a></td>


                    <td class="positive-cost text-right"></i>5.00</td>
                     <td class="text-right">3.50</td>
                    <td class="text-right">4,56,789</td>
                </tr>
                -->


          </tbody>




      </table>
    </div>

</div>

<div class="col-md-4 col-lg-4 col-sm-6 col-xs-12">

  <div class="table-responsive">
   <table  class="table table-hover acrylic data_table">

       <thead>
           <tr>
             <th width="52">SECTOR</th>
             <th width="20" class="text-right">holding</th>
             <th width="28" class="text-right">Drawing Power<a class="cursor-pointer pull-right" data-toggle="modal" data-target="#SectorAllModal"><i class="fa fa-expand expand" aria-hidden="true"></i></a></th>
           </tr>
       </thead>
       <tbody>
           <tr>
               <td><a class="cursor-pointer " data-toggle="modal" data-target="#SectorScripModal">FINANCE (INCLUDING NBFCS)</a></td>

               <td class="text-right">152</td>
               <td class="text-right">789</td>
           </tr>
           <tr>
               <td><a class="cursor-pointer " data-toggle="modal" data-target="#SectorScripModal">MINING</a></td>
               <td class="text-right">145</td>
               <td class="text-right">654</td>
           </tr>
           <tr>
               <td><a class="cursor-pointer " data-toggle="modal" data-target="#SectorScripModal">OTHER FINANCIAL SERVICES</a></td>

               <td class="text-right">158</td>
               <td class="text-right">321</td>
           </tr>
           <tr>
               <td> <a class="cursor-pointer " data-toggle="modal" data-target="#SectorScripModal">IT CONSULTING & SOFTWARE</a></td>

               <td class="text-right">120</td>
               <td class="text-right">59</td>
           </tr>
           <tr>
               <td> <a class="cursor-pointer " data-toggle="modal" data-target="#SectorScripModal">DIVERSIFIED</a></td>

               <td class="text-right">90</td>
               <td class="text-right">62</td>
           </tr>

       </tbody>
   </table>
  </div>

</div>

<div class="col-md-4 col-lg-4 col-sm-6 col-xs-12">

  <div class="table-responsive">
   <table  class="table table-hover acrylic data_table">

        <!-- <caption class="text-center table-heading">TOP PERFORMING CLIENTS</caption> -->
       <thead>
           <tr>
             <th  width="58">TOP CLIENTS</th>
             <th width="26" class="text-right hidden-overflow">DRAWING POWER</th>
             <th  width="16" class="text-right">LOAN O/S  <a class="cursor-pointer pull-right" data-toggle="modal" data-target="#topClientAllModal"><i class="fa fa-expand expand" aria-hidden="true"></i></a> </th>
           </tr>
       </thead>
       <tbody>
           <tr>
               <td>KARVY BROKING LIMITED</td>
               <td class="text-right">987</td>
               <td class="text-right">999</td>
           </tr>
           <tr>
             <td>AMRAPALI AADYA TRADING</td>
             <td class="text-right">876</td>
             <td class="text-right">888</td>
           </tr>
           <tr>
             <td>Carolina Biggleswade</td>
             <td class="text-right">65</td>
             <td class="text-right">98</td>
           </tr>
           <tr>
             <td>Carolina Biggleswade</td>
             <td class="text-right">65</td>
             <td class="text-right">98</td>
           </tr>
           <tr>
             <td>Carolina Biggleswade</td>
             <td class="text-right">65</td>
             <td class="text-right">98</td>
           </tr>


       </tbody>
   </table>
  </div>


</div>
</div>

<div class="clearfix"></div>


<div class="row admin-portfolio-table">


     <div class="col-md-5 col-lg-5 col-sm-6 col-xs-12">

       <div class="table-responsive">
        <table  class="table table-hover acrylic data_table">


            <thead>
                <tr>
                  <th width="32">Scrip</th>

                  <th  width="24" class="text-right">promoter holding%</th>
                  <th  width="23" class="text-right">Promotor pledge%</th>
                  <th  width="21" class="text-right hidden-overflow">Drawing Power<a class="cursor-pointer pull-right" data-toggle="modal" data-target="#promotorHoldAllModal"><i class="fa fa-expand expand" aria-hidden="true"></i></a></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>LAKSHMI VILAS BANK LTD</td>

                    <td class="text-right">16.3</td>
                      <td class="text-right">42.55</td>
                      <td class="text-right">1,32,321</td>
                </tr>
                <tr>
                  <td>UFLEX LTD</td>

                  <td class="text-right">18.5</td>
                    <td class="text-right">17.3</td>
                    <td class="text-right">1,32,564</td>
                </tr>
                <tr>
                  <td>STAMPEDE CAPITAL LIMITED</td>

                  <td class="text-right">24.93</td>
                    <td class="text-right">17.52</td>
                    <td class="text-right">64,54,563</td>
                </tr>
                <tr>
                  <td>INDOCO REMEDIES LTD</td>

                  <td class="text-right">59.11</td>
                    <td class="text-right">00.1</td>
                    <td class="text-right">64,54,132</td>
                </tr>
                <tr>
                  <td>HOUSING DEVELOPMENT</td>

                  <td class="text-right">0</td>
                    <td class="text-right">0</td>
                    <td class="text-right">5,61,631</td>
                </tr>

            </tbody>
        </table>
       </div>

    </div>


   <div class="col-md-7 col-lg-7 col-sm-6 col-xs-12">

     <div class="table-responsive">

      <table  class="table table-hover acrylic data_table">
        <!-- <caption class="text-center table-heading">concentrationENTRATION</caption> -->

          <thead>
              <tr>
                <th width="24">CLIENT</th>
                <th width="8" class="text-right">LOAN</th>
                <th width="14" class="text-right">Drawing Power</th>
                <th width="12" class="text-right" >MARKET VALUE</th>
                <th width="26">SCRIP</th>
                  <th width="16" class="text-right">concentration%<a class="cursor-pointer pull-right" data-toggle="modal" data-target="#concentrationAllModal"><i class="fa fa-expand expand" aria-hidden="true"></i></a></th>
              </tr>
          </thead>
          <tbody>


              <tr>
                <td ><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AFFLUENCE  PRIVATE LIMITED</a></td>


                  <td  class="text-right">269</td>
                    <td  class="text-right">1,54,94,839</td>

                    <td  class="text-right">3,07,89,679</td>
                    <td>ZEE NEWS LTD</td>
                    <td  class="text-right">11.09</td>
              </tr>
              <tr>
                <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AIRAN FINSCRIPS PVT LTD</a></td>

                  <td  class="text-right">164</td>
                  <td  class="text-right">1,10,93,313</td>
                    <td  class="text-right">2,21,86,627</td>

                    <td>ZEN TECHNOLOGIES LIMITED</td>
                    <td  class="text-right">7.99</td>
              </tr>
              <tr>
                <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AMRAPALI AADYA  PVT LTD</a></td>


                  <td  class="text-right">873</td>
                  <td  class="text-right">78,01,686</td>
                    <td  class="text-right">1,95,04,215</td>
                    <td>ZENSAR TECHNOLOGIES LTD</td>
                    <td  class="text-right">5.62</td>
              </tr>
              <tr>
                  <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AMRAPALI AADYA  PVT LTD</a></td>
                  <td  class="text-right">199</td>
                  <td  class="text-right">50,00,000</td>
                    <td  class="text-right">1,40,12,923</td>
                    <td>ZICOM ELECTRONIC SYSTEMS LTD</td>
                    <td  class="text-right">3.60</td>
              </tr>
              <tr>
                <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">ARHAM WEALTH MANAGEMENT</a></td>
                  <td  class="text-right">743</td>
                    <td  class="text-right">31,74,341</td>
                    <td  class="text-right">35,27,046</td>
                    <td >ZUARI AGRO CHEM</td>
                    <td  class="text-right">2.29</td>
              </tr>
          </tbody>
      </table>
     </div>
  </div>
  </div>




  <div class="row bg-color padding-top-3px">
  <div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
   <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
     <div class="form-group marging-bottom-o graph-d">
          <!-- <label for="sel1">Select list (select one):</label> -->
          <select class="form-control">
              <option selected>filter by Days</option>
            <option>3</option>
            <option>5</option>
            <option>7</option>
            <option>10</option>
            <option>15</option>
            <option>20</option>
            <option>25</option>
            <option>30</option>

          </select>
        </div>
   </div>
 </div>
   <div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
     <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
       <div class="form-group marging-bottom-o graph-d">
            <!-- <label for="sel1">Select list (select one):</label> -->
            <select class="form-control ">
                <option selected>filter by Days</option>
                <option>3</option>
                <option>5</option>
                <option>7</option>
                <option>10</option>
                <option>15</option>
                <option>20</option>
                <option>25</option>
                <option>30</option>
            </select>
          </div>
     </div>

   </div>
 </div>
 <div class="row bg-color">
   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
      <div id="myPieChart"></div>
       </div>
   <!-- <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
      <div id="curve_chart" ></div>
   </div> -->
   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
  <div id="scatter_div" ></div>
   </div>
   </div>

   </section>
<!-- footer logic -->
<admin-footer></admin-footer>

  </div>
</div>
  <!-- modal Circuit Breaker -->


  <div class="modal fade" id="circuitBreakerAllModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <!-- <h5 class="modal-title" id="exampleModalLabel">New message</h5> -->
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body modal-height admin-portfolio ">


          <div class="table-responsive">
            <table  class="table table-hover acrylic modal_table">
               <!-- <caption class="text-center table-heading">CIRCUIT BREAKERS</caption> -->
                <thead>
                    <tr>

                        <th>CIRCUIT </th>
                        <th class="text-right">% CHANGE
                     <i class="fa fa-caret-up caret-fa color-green" aria-hidden="true" @click="showCircuit('true')" ></i>
                         <i class="fa fa-caret-down caret-fa color-red" aria-hidden="true" @click="showCircuit('false')"></i>
                        </th>
                        <th class="text-right">CURRENT CIRCUIT</th>
                        <th class="text-right">Drawing Power  </th>
                    </tr>
                </thead>


                <tbody >



                <tr v-if="!toggleTopCircuit"   v-for="(loserScrip, index) in loserList">
                    <td>{{loserScrip.name}}</td>
                    <td class="negative-cost text-right">{{loserScrip.percentChange}}</td>
                    <td class="text-right">{{loserScrip.percentChange}}</td>
                    <td class="text-right">{{loserScrip.drawingPower}}</td>
                </tr>


                <tr v-if="toggleTopCircuit"   v-for="(gainserScrip, index) in gainerList">
                    <td>{{gainserScrip.name}}</td>
                    <td class="negative-cost text-right">{{gainserScrip.percentChange}}</td>
                    <td class="text-right">{{gainserScrip.percentChange}}</td>
                    <td class="text-right">{{gainserScrip.drawingPower}}</td>
                </tr>

                <!--
                  <tr v-if="!toggleTopCircuit">
                      <td>MIPCO SEAMLESS</td>
                      <td class="negative-cost text-right">-5.00</td>
                      <td class="text-right">-4.90</td>
                      <td class="text-right">5,67,890</td>
                  </tr>
                    <tr v-if="!toggleTopCircuit">
                        <td>GLOBUS CORP</td>

                        <td class="negative-cost text-right">-7.69</td>
                       <td class="text-right">-7.00</td>
                        <td class="text-right">1,23,456</td>
                    </tr>
                    <tr v-if="!toggleTopCircuit">
                         <td>VISESH INFOTECH</td>


                        <td class="negative-cost text-right">-5.88</td>
                         <td class="text-right">-5.50</td>
                        <td class="text-right">2,34,567</td>
                    </tr>
                    <tr v-if="!toggleTopCircuit">
                      <td>INDIAN INFOTECH<</td>
                        <td class="negative-cost text-right">-5.00</td>
                         <td class="text-right">-5.50</td>
                        <td class="text-right">3,45,678</td>
                    </tr>
                    <tr v-if="!toggleTopCircuit">
                           <td>EUROMULT</td>


                        <td class="negative-cost text-right"></i>-5.00</td>
                       <td class="text-right">-4.00</td>
                        <td class="text-right">4,56,789</td>
                    </tr>
                    <tr v-if="!toggleTopCircuit">
                        <td>MIPCO SEAMLESS</td>
                        <td class="negative-cost text-right">-5.00</td>
                        <td class="text-right">-4.90</td>
                        <td class="text-right">5,67,890</td>
                    </tr>
                      <tr v-if="!toggleTopCircuit">
                          <td>GLOBUS CORP</td>

                          <td class="negative-cost text-right">-7.69</td>
                         <td class="text-right">-7.00</td>
                          <td class="text-right">1,23,456</td>
                      </tr>
                      <tr v-if="!toggleTopCircuit">
                          <td>MIPCO SEAMLESS</td>
                          <td class="negative-cost text-right">-5.00</td>
                          <td class="text-right">-4.90</td>
                          <td class="text-right">5,67,890</td>
                      </tr>
                        <tr v-if="!toggleTopCircuit">
                            <td>GLOBUS CORP</td>

                            <td class="negative-cost text-right">-7.69</td>
                           <td class="text-right">-7.00</td>
                            <td class="text-right">1,23,456</td>
                        </tr>
                        <tr v-if="!toggleTopCircuit">
                             <td>VISESH INFOTECH</td>


                            <td class="negative-cost text-right">-5.88</td>
                             <td class="text-right">-5.50</td>
                            <td class="text-right">2,34,567</td>
                        </tr>
                        <tr v-if="!toggleTopCircuit">
                          <td>INDIAN INFOTECH<</td>
                            <td class="negative-cost text-right">-5.00</td>
                             <td class="text-right">-5.50</td>
                            <td class="text-right">3,45,678</td>
                        </tr>
                        <tr v-if="!toggleTopCircuit">
                               <td>EUROMULT</td>


                            <td class="negative-cost text-right"></i>-5.00</td>
                           <td class="text-right">-4.00</td>
                            <td class="text-right">4,56,789</td>
                        </tr>
                        <tr v-if="!toggleTopCircuit">
                            <td>MIPCO SEAMLESS</td>
                            <td class="negative-cost text-right">-5.00</td>
                            <td class="text-right">-4.90</td>
                            <td class="text-right">5,67,890</td>
                        </tr>
                          <tr v-if="!toggleTopCircuit">
                              <td>GLOBUS CORP</td>

                              <td class="negative-cost text-right">-7.69</td>
                             <td class="text-right">-7.00</td>
                              <td class="text-right">1,23,456</td>
                          </tr>




                          <tr v-if="toggleTopCircuit">
                              <td>MIPCO SEAMLESS</td>
                              <td class="positive-cost text-right">5.00</td>
                             <td class="text-right">5.5</td>
                              <td class="text-right">5,67,890</td>
                          </tr>
                            <tr  v-if="toggleTopCircuit">
                                <td>GLOBUS CORP</td>

                                <td class="positive-cost text-right">7.69</td>
                               <td class="text-right">4.50</td>
                                <td class="text-right">1,23,456</td>
                            </tr>
                            <tr  v-if="toggleTopCircuit">
                                 <td>VISESH INFOTECH</td>


                                <td class="positive-cost text-right">5.88</td>
                                 <td class="text-right">4.00</td>
                                <td  class="text-right">2,34,567</td>
                            </tr>
                            <tr  v-if="toggleTopCircuit">
                              <td>INDIAN INFOTECH</td>
                                <td class="positive-cost text-right">5.00</td>
                                 <td class="text-right">3.55</td>
                                <td class="text-right">3,45,678</td>
                            </tr>
                            <tr  v-if="toggleTopCircuit">
                                   <td>EUROMULT</td>


                                <td class="positive-cost text-right"></i>5.00</td>
                                 <td class="text-right">3.50</td>
                                <td class="text-right">4,56,789</td>
                            </tr>
                            <tr  v-if="toggleTopCircuit">
                                <td>MIPCO SEAMLESS</td>
                                <td class="positive-cost text-right">5.00</td>
                               <td class="text-right">5.5</td>
                                <td class="text-right">5,67,890</td>
                            </tr>
                              <tr  v-if="toggleTopCircuit">
                                  <td>GLOBUS CORP</td>

                                  <td class="positive-cost text-right">7.69</td>
                                 <td class="text-right">4.50</td>
                                  <td class="text-right">1,23,456</td>
                              </tr>
                              <tr  v-if="toggleTopCircuit">
                                  <td>MIPCO SEAMLESS</td>
                                  <td class="positive-cost text-right">5.00</td>
                                 <td class="text-right">5.5</td>
                                  <td class="text-right">5,67,890</td>
                              </tr>
                                <tr  v-if="toggleTopCircuit">
                                    <td>GLOBUS CORP</td>

                                    <td class="positive-cost text-right">7.69</td>
                                   <td class="text-right">4.50</td>
                                    <td class="text-right">1,23,456</td>
                                </tr>
                                <tr  v-if="toggleTopCircuit">
                                     <td>VISESH INFOTECH</td>


                                    <td class="positive-cost text-right">5.88</td>
                                     <td class="text-right">4.00</td>
                                    <td  class="text-right">2,34,567</td>
                                </tr>
                                <tr  v-if="toggleTopCircuit">
                                  <td>INDIAN INFOTECH</td>
                                    <td class="positive-cost text-right">5.00</td>
                                     <td class="text-right">3.55</td>
                                    <td class="text-right">3,45,678</td>
                                </tr>
                                <tr  v-if="toggleTopCircuit">
                                       <td>EUROMULT</td>


                                    <td class="positive-cost text-right"></i>5.00</td>
                                     <td class="text-right">3.50</td>
                                    <td class="text-right">4,56,789</td>
                                </tr>
                                <tr  v-if="toggleTopCircuit">
                                    <td>MIPCO SEAMLESS</td>
                                    <td class="positive-cost text-right">5.00</td>
                                   <td class="text-right">5.5</td>
                                    <td class="text-right">5,67,890</td>
                                </tr>
                                  <tr  v-if="toggleTopCircuit">
                                      <td>GLOBUS CORP</td>

                                      <td class="positive-cost text-right">7.69</td>
                                     <td class="text-right">4.50</td>
                                      <td class="text-right">1,23,456</td>
                                  </tr>
                                  -->
                </tbody>




            </table>
         </div>


        </div>

      </div>
    </div>
  </div>



<!-- top GainersModal -->


  <div class="modal fade" id="topGainersModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <!-- <h5 class="modal-title" id="exampleModalLabel">New message</h5> -->
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body modal-height admin-portfolio ">


          <div class="table-responsive">
            <table  class="table table-hover acrylic modal_table">
                <thead>
                    <tr>
                      <th>GAINERS</th>
                      <th class="text-right">% CHANGE</th>
                      <th class="text-right">Drawing Power </th>
                    </tr>
                </thead>
                <tbody>

                <tr v-for="(gainerScrip, index) in gainerList">
                    <td>{{gainerScrip.name}}</td>
                    <td class="positive-cost text-right">{{gainerScrip.percentChange}}</td>
                    <td class="text-right">{{gainerScrip.drawingPower}}</td>

                </tr>

                <!--
                    <tr>
                        <td>GMDCLTD</td>
                        <td class="positive-cost text-right">+7.48</td>
                        <td class="text-right">1,23,456</td>
                    </tr>
                    <tr>
                        <td>CESC</td>
                        <td class="positive-cost text-right">+5.78</td>
                        <td class="text-right">2,34,567</td>
                    </tr>
                    <tr>
                        <td>ADANITRANS</td>
                        <td class="positive-cost text-right">+4.00</td>
                        <td class="text-right">3,45,678</td>
                    </tr>
                    <tr>
                        <td>KEC</td>
                          <td class="positive-cost text-right"></i>+3.72</td>
                        <td class="text-right">4,56,789</td>
                    </tr>
                    <tr>
                        <td>COLPAL</td>
                          <td class="positive-cost text-right"></i>+3.59</td>
                        <td class="text-right">5,67,890</td>
                    </tr>
                    <tr>
                        <td>GMDCLTD</td>
                        <td class="positive-cost text-right">+7.48</td>
                        <td class="text-right">1,23,456</td>
                    </tr>
                    <tr>
                        <td>CESC</td>
                        <td class="positive-cost text-right">+5.78</td>
                        <td class="text-right">2,34,567</td>
                    </tr>
                    <tr>
                        <td>GMDCLTD</td>
                        <td class="positive-cost text-right">+7.48</td>
                        <td class="text-right">1,23,456</td>
                    </tr>
                    <tr>
                        <td>CESC</td>
                        <td class="positive-cost text-right">+5.78</td>
                        <td class="text-right">2,34,567</td>
                    </tr>
                    <tr>
                        <td>ADANITRANS</td>
                        <td class="positive-cost text-right">+4.00</td>
                        <td class="text-right">3,45,678</td>
                    </tr>
                    <tr>
                        <td>KEC</td>
                          <td class="positive-cost text-right"></i>+3.72</td>
                        <td class="text-right">4,56,789</td>
                    </tr>
                    <tr>
                        <td>COLPAL</td>
                          <td class="positive-cost text-right"></i>+3.59</td>
                        <td class="text-right">5,67,890</td>
                    </tr>
                    <tr>
                        <td>GMDCLTD</td>
                        <td class="positive-cost text-right">+7.48</td>
                        <td class="text-right">1,23,456</td>
                    </tr>
                    <tr>
                        <td>CESC</td>
                        <td class="positive-cost text-right">+5.78</td>
                        <td class="text-right">2,34,567</td>
                    </tr>
              -->
                </tbody>
            </table>
         </div>


        </div>

      </div>
    </div>
  </div>

 <!-- LOSERS  modal-->

  <div class="modal fade" id="loserModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <!-- <h5 class="modal-title" id="exampleModalLabel">New message</h5> -->
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body modal-height admin-portfolio ">


          <div class="table-responsive">
            <table  class="table table-hover acrylic modal_table">
                <thead>
                    <tr>
                      <th>LOSERS</th>
                      <th class="text-right">% CHANGE</th>
                      <th class="text-right">Drawing Power </th>
                    </tr>
                </thead>
                <tbody>

                <tr v-for="(loserScrip, index) in loserList">
                    <td>{{loserScrip.name}}</td>
                    <td class="positive-cost text-right">{{loserScrip.percentChange}}</td>
                    <td class="text-right">{{loserScrip.drawingPower}}</td>
                </tr>
                  <!--  <tr>
                        <td>GMDCLTD</td>
                        <td class="negative-cost text-right">-7.48</td>
                        <td class="text-right">1,23,456</td>
                    </tr>
                    <tr>
                        <td>CESC</td>
                        <td class="negative-cost text-right">-5.78</td>
                        <td class="text-right">2,34,567</td>
                    </tr>
                    <tr>
                        <td>ADANITRANS</td>
                        <td class="negative-cost text-right">-4.00</td>
                        <td class="text-right">3,45,678</td>
                    </tr>
                    <tr>
                        <td>KEC</td>
                          <td class="negative-cost text-right"></i>-3.72</td>
                        <td class="text-right">4,56,789</td>
                    </tr>
                    <tr>
                        <td>COLPAL</td>
                          <td class="negative-cost text-right"></i>-3.59</td>
                        <td class="text-right">5,67,890</td>
                    </tr>
                    <tr>
                        <td>GMDCLTD</td>
                        <td class="negative-cost text-right">-7.48</td>
                        <td class="text-right">1,23,456</td>
                    </tr>
                    <tr>
                        <td>CESC</td>
                        <td class="negative-cost text-right">-5.78</td>
                        <td class="text-right">2,34,567</td>
                    </tr>
                    <tr>
                        <td>ADANITRANS</td>
                        <td class="negative-cost text-right">-4.00</td>
                        <td class="text-right">3,45,678</td>
                    </tr>
                    <tr>
                        <td>GMDCLTD</td>
                        <td class="negative-cost text-right">-7.48</td>
                        <td class="text-right">1,23,456</td>
                    </tr>
                    <tr>
                        <td>CESC</td>
                        <td class="negative-cost text-right">-5.78</td>
                        <td class="text-right">2,34,567</td>
                    </tr>
                    <tr>
                        <td>ADANITRANS</td>
                        <td class="negative-cost text-right">-4.00</td>
                        <td class="text-right">3,45,678</td>
                    </tr>
                    <tr>
                        <td>KEC</td>
                          <td class="negative-cost text-right"></i>-3.72</td>
                        <td class="text-right">4,56,789</td>
                    </tr>
                    <tr>
                        <td>COLPAL</td>
                          <td class="negative-cost text-right"></i>-3.59</td>
                        <td class="text-right">5,67,890</td>
                    </tr>
                    <tr>
                        <td>GMDCLTD</td>
                        <td class="negative-cost text-right">-7.48</td>
                        <td class="text-right">1,23,456</td>
                    </tr>
                    <tr>
                        <td>CESC</td>
                        <td class="negative-cost text-right">-5.78</td>
                        <td class="text-right">2,34,567</td>
                    </tr>
                    <tr>
                        <td>ADANITRANS</td>
                        <td class="negative-cost text-right">-4.00</td>
                        <td class="text-right">3,45,678</td>
                    </tr>
                    <tr>
                        <td>GMDCLTD</td>
                        <td class="negative-cost text-right">-7.48</td>
                        <td class="text-right">1,23,456</td>
                    </tr>
                    <tr>
                        <td>CESC</td>
                        <td class="negative-cost text-right">-5.78</td>
                        <td class="text-right">2,34,567</td>
                    </tr>
                    <tr>
                        <td>ADANITRANS</td>
                        <td class="negative-cost text-right">-4.00</td>
                        <td class="text-right">3,45,678</td>
                    </tr>
                    <tr>
                        <td>KEC</td>
                          <td class="negative-cost text-right"></i>-3.72</td>
                        <td class="text-right">4,56,789</td>
                    </tr>
                    <tr>
                        <td>COLPAL</td>
                          <td class="negative-cost text-right"></i>-3.59</td>
                        <td class="text-right">5,67,890</td>
                    </tr>
                    <tr>
                        <td>GMDCLTD</td>
                        <td class="negative-cost text-right">-7.48</td>
                        <td class="text-right">1,23,456</td>
                    </tr>
                    <tr>
                        <td>CESC</td>
                        <td class="negative-cost text-right">-5.78</td>
                        <td class="text-right">2,34,567</td>
                    </tr>
                    <tr>
                        <td>ADANITRANS</td>
                        <td class="negative-cost text-right">-4.00</td>
                        <td class="text-right">3,45,678</td>
                    </tr>
               -->
              </tbody>
            </table>
         </div>


        </div>

      </div>
    </div>
  </div>





<div class="modal fade" id="SectorScripModal" tabindex="-1" role="dialog" aria-labelledby="SectorAllModal" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <!-- <h5 class="modal-title" id="exampleModalLabel">New message</h5> -->
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body modal-height admin-portfolio ">


        <div class="table-responsive">
          <table  class="table table-hover acrylic modal_table">
            <!-- <caption class="text-center table-heading">SECTOR</caption> -->
              <thead>
                  <tr>
                    <th >SCRIP</th>
                    <th class="text-right">HOLDING</th>
                    <th class="text-right hidden-overflow">Drawing Power</th>
                  </tr>
              </thead>
              <tbody>
                  <tr>
                      <td>ADANI ENTERPRISES LTD</td>

                      <td class="text-right">123</td>
                      <td class="text-right">789</td>
                  </tr>
                  <tr>
                      <td>ADANI ENTERPRISES LTD</td>
                      <td class="text-right">122</td>
                      <td class="text-right">654</td>
                  </tr>
                  <tr>
                      <td>ADITYA BIRLA NUVO LTD</td>

                      <td class="text-right">115</td>
                      <td class="text-right">321</td>
                  </tr>
                  <tr>
                      <td>AEGIS LOGISTICS</td>

                      <td class="text-right">99</td>
                      <td class="text-right">59</td>
                  </tr>
                  <tr>
                      <td>ALEMBIC LTD</td>

                      <td class="text-right">90</td>
                      <td class="text-right">6</td>
                  </tr>
                  <tr>
                      <td>ALKYL AMINES</td>

                      <td class="text-right">85</td>
                      <td class="text-right">6</td>
                  </tr>
                  <tr>
                      <td>ALPHAGEO (INDIA) LTD</td>

                      <td class="text-right">1.21</td>
                      <td class="text-right">63</td>
                  </tr>
                  <tr>
                      <td>AMBUJA CEMENTS LTD</td>

                      <td class="text-right">152</td>
                      <td class="text-right">125</td>
                  </tr>
                  <tr>
                      <td>ANANT RAJ INDUSTRIES LTD</td>

                      <td class="text-right">520</td>
                      <td class="text-right">120</td>
                  </tr>
                  <tr>
                      <td>ANDREW YULE & COMPANY LTD</td>

                      <td class="text-right">154</td>
                      <td class="text-right">68</td>
                  </tr>
                  <tr>
                      <td>ANUH PHARMA LTD</td>

                      <td class="text-right">135</td>
                      <td class="text-right">85</td>
                  </tr>
                  <tr>
                      <td>ANUH PHARMA LTD</td>

                      <td class="text-right">135</td>
                      <td class="text-right">85</td>
                  </tr>
                  <tr>
                      <td>ANUH PHARMA LTD</td>

                      <td class="text-right">135</td>
                      <td class="text-right">85</td>
                  </tr>
                  <tr>
                      <td>ANUH PHARMA LTD</td>

                      <td class="text-right">135</td>
                      <td class="text-right">85</td>
                  </tr>
                  <tr>
                      <td>ANUH PHARMA LTD</td>

                      <td class="text-right">135</td>
                      <td class="text-right">85</td>
                  </tr>
                  <tr>
                      <td>ANUH PHARMA LTD</td>

                      <td class="text-right">135</td>
                      <td class="text-right">85</td>
                  </tr>
                  <tr>
                      <td>ANUH PHARMA LTD</td>

                      <td class="text-right">135</td>
                      <td class="text-right">85</td>
                  </tr>
                  <tr>
                      <td>ANUH PHARMA LTD</td>

                      <td class="text-right">135</td>
                      <td class="text-right">85</td>
                  </tr>
                  <tr>
                      <td>ANUH PHARMA LTD</td>

                      <td class="text-right">135</td>
                      <td class="text-right">85</td>
                  </tr>
                  <tr>
                      <td>ALPHAGEO (INDIA) LTD</td>

                      <td class="text-right">185</td>
                      <td class="text-right">78</td>
                  </tr>
                  <tr>
                      <td>AMBUJA CEMENTS LTD</td>

                      <td class="text-right">256</td>
                      <td class="text-right">80</td>
                  </tr>
                  <tr>
                      <td>ANANT RAJ INDUSTRIES LTD</td>

                      <td class="text-right">250</td>
                      <td class="text-right">90</td>
                  </tr>
                  <tr>
                      <td>ANDREW YULE & COMPANY LTD</td>

                      <td class="text-right">150</td>
                      <td class="text-right">45</td>
                  </tr>
                  <tr>
                      <td>ANUH PHARMA LTD</td>

                      <td class="text-right">120</td>
                      <td class="text-right">80</td>
                  </tr>

                  <tr>
                      <td>ANANT RAJ INDUSTRIES LTD</td>

                      <td class="text-right">890</td>
                      <td class="text-right">458</td>
                  </tr>
                  <tr>
                      <td>ANDREW YULE & COMPANY LTD</td>

                      <td class="text-right">452</td>
                      <td class="text-right">452</td>
                  </tr>
                  <tr>
                      <td >ANUH PHARMA LTD</td>

                      <td class="text-right">452</td>
                      <td class="text-right">452</td>
                  </tr>
                  <tr>
                      <td>ALPHAGEO (INDIA) LTD</td>

                      <td class="text-right">452</td>
                      <td class="text-right">45</td>
                  </tr>
                  <tr>
                      <td>AMBUJA CEMENTS LTD</td>

                      <td class="text-right">120</td>
                      <td class="text-right">25</td>
                  </tr>
                  <tr>
                      <td>ANANT RAJ INDUSTRIES LTD</td>

                      <td class="text-right">890</td>
                      <td class="text-right">458</td>
                  </tr>

              </tbody>
          </table>
       </div>


      </div>
      <!-- <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div> -->
    </div>
  </div>
</div>


<div class="modal fade" id="SectorAllModal" tabindex="-1" role="dialog" aria-labelledby="SectorAllModal" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <!-- <h5 class="modal-title" id="exampleModalLabel">New message</h5> -->
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body modal-height admin-portfolio ">


        <div class="table-responsive">
          <table  class="table table-hover acrylic modal_table">
            <!-- <caption class="text-center table-heading">SECTOR</caption> -->
              <thead>
                  <tr>
                    <th width="55">SECTOR</th>
                    <th width="20" class="text-right">HOLDING</th>
                    <th width="25" class="text-right hidden-overflow">Drawing Power</th>
                  </tr>
              </thead>
              <tbody>
                  <tr>
                      <td>FINANCE (INCLUDING NBFCS)</td>

                      <td class="text-right">10232</td>
                      <td class="text-right">789</td>
                  </tr>
                  <tr>
                      <td>MINING</td>
                      <td class="text-right">10235</td>
                      <td class="text-right">654</td>
                  </tr>
                  <tr>
                      <td>OTHER FINANCIAL SERVICES</td>

                      <td class="text-right">952</td>
                      <td class="text-right">321</td>
                  </tr>
                  <tr>
                      <td>IT CONSULTING & SOFTWARE</td>

                      <td class="text-right">624</td>
                      <td class="text-right">59</td>
                  </tr>
                  <tr>
                      <td >DIVERSIFIED</td>

                      <td class="text-right">121</td>
                      <td class="text-right">622</td>
                  </tr>
                  <tr>
                      <td>FINANCE (INCLUDING NBFCS)</td>

                      <td class="text-right">10232</td>
                      <td class="text-right">789</td>
                  </tr>
                  <tr>
                      <td>MINING</td>
                      <td class="text-right">10235</td>
                      <td class="text-right">654</td>
                  </tr>
                  <tr>
                      <td>OTHER FINANCIAL SERVICES</td>

                      <td class="text-right">952</td>
                      <td class="text-right">321</td>
                  </tr>
                  <tr>
                      <td>IT CONSULTING & SOFTWARE</td>

                      <td class="text-right">624</td>
                      <td class="text-right">59</td>
                  </tr>
                  <tr>
                      <td >DIVERSIFIED</td>

                      <td class="text-right">121</td>
                      <td class="text-right">622</td>
                  </tr>
                  <tr>
                      <td>FINANCE (INCLUDING NBFCS)</td>

                      <td class="text-right">10,232</td>
                      <td class="text-right">789</td>
                  </tr>
                  <tr>
                      <td>MINING</td>
                      <td class="text-right">10235</td>
                      <td class="text-right">654</td>
                  </tr>
                  <tr>
                      <td>OTHER FINANCIAL SERVICES</td>

                      <td class="text-right">952</td>
                      <td class="text-right">321</td>
                  </tr>
                  <tr>
                      <td>IT CONSULTING & SOFTWARE</td>

                      <td class="text-right">624</td>
                      <td class="text-right">59</td>
                  </tr>
                  <tr>
                      <td >DIVERSIFIED</td>

                      <td class="text-right">121</td>
                      <td class="text-right">622</td>
                  </tr>


              </tbody>
          </table>
       </div>


      </div>
      <!-- <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div> -->
    </div>
  </div>
</div>






<div class="modal fade" id="promotorHoldAllModal" tabindex="-1" role="dialog" aria-labelledby="promotorHoldAllModal" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <!-- <h5 class="modal-title" id="exampleModalLabel">New message</h5> -->
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body modal-height admin-portfolio ">


        <div class="table-responsive">
          <table  class="table table-hover acrylic modal_table">
             <!-- <caption class="text-center table-heading">PROMOTER HOLDINGS</caption> -->

              <thead>
                  <tr>
                    <th width="50">Scrip</th>

                    <th width="20" class="text-right">promoter holding%</th>
                    <th width="20" class="text-right">PROMOTER PLEDGE %</th>
                    <th width="20" class="text-right hidden-overflow">Drawing Power</th>
                  </tr>
              </thead>
              <tbody>
                  <tr>
                      <td>LAKSHMI VILAS BANK LTD</td>

                      <td class="text-right">16.3</td>
                        <td class="text-right">42.55</td>
                        <td class="text-right">1,32,321</td>
                  </tr>
                  <tr>
                    <td>UFLEX LTD</td>

                    <td class="text-right">18.5</td>
                      <td class="text-right">17.3</td>
                      <td class="text-right">1,32,564</td>
                  </tr>
                  <tr>
                    <td>STAMPEDE CAPITAL LIMITED</td>

                    <td class="text-right">24.93</td>
                      <td class="text-right">17.52</td>
                      <td class="text-right">64,54,563</td>
                  </tr>
                  <tr>
                    <td>INDOCO REMEDIES LTD</td>

                    <td class="text-right">59.11</td>
                      <td class="text-right">00.1</td>
                      <td class="text-right">64,54,132</td>
                  </tr>
                  <tr>
                    <td>HOUSING DEVELOPMENT FINANCE CORPORATION LTD</td>

                    <td class="text-right">0</td>
                      <td class="text-right">0</td>
                      <td class="text-right">5,61,631</td>
                  </tr>
                  <tr>
                    <td>HOUSING DEVELOPMENT FINANCE CORPORATION LTD</td>

                    <td class="text-right">0</td>
                      <td class="text-right">0</td>
                      <td class="text-right">5,61,631</td>
                  </tr>
                  <tr>
                    <td>HOUSING DEVELOPMENT FINANCE CORPORATION LTD</td>

                    <td class="text-right">0</td>
                      <td class="text-right">0</td>
                      <td class="text-right">5,61,631</td>
                  </tr>
                  <tr>
                    <td>HOUSING DEVELOPMENT FINANCE CORPORATION LTD</td>

                    <td class="text-right">0</td>
                      <td class="text-right">0</td>
                      <td class="text-right">5,61,631</td>
                  </tr>

                  <tr>
                      <td>LAKSHMI VILAS BANK LTD</td>

                      <td class="text-right">16.3</td>
                        <td class="text-right">42.55</td>
                        <td class="text-right">1,32,321</td>
                  </tr>
                  <tr>
                    <td>UFLEX LTD</td>

                    <td class="text-right">18.5</td>
                      <td class="text-right">17.3</td>
                      <td class="text-right">1,32,564</td>
                  </tr>
                  <tr>
                    <td>STAMPEDE CAPITAL LIMITED</td>

                    <td class="text-right">24.93</td>
                      <td class="text-right">17.52</td>
                      <td class="text-right">64,54,563</td>
                  </tr>
                  <tr>
                    <td>INDOCO REMEDIES LTD</td>

                    <td class="text-right">59.11</td>
                      <td class="text-right">00.1</td>
                      <td class="text-right">64,54,132</td>
                  </tr>
                  <tr>
                    <td>HOUSING DEVELOPMENT FINANCE CORPORATION LTD</td>

                    <td class="text-right">0</td>
                      <td class="text-right">0</td>
                      <td class="text-right">5,61,631</td>
                  </tr>
                  <tr>
                    <td>HOUSING DEVELOPMENT FINANCE CORPORATION LTD</td>

                    <td class="text-right">0</td>
                      <td class="text-right">0</td>
                      <td class="text-right">5,61,631</td>
                  </tr>
                  <tr>
                    <td>HOUSING DEVELOPMENT FINANCE CORPORATION LTD</td>

                    <td class="text-right">0</td>
                      <td class="text-right">0</td>
                      <td class="text-right">5,61,631</td>
                  </tr>
                  <tr>
                    <td>HOUSING DEVELOPMENT FINANCE CORPORATION LTD</td>

                    <td class="text-right">0</td>
                      <td class="text-right">0</td>
                      <td class="text-right">5,61,631</td>
                  </tr>

              </tbody>
          </table>
       </div>


      </div>
      <!-- <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div> -->
    </div>
  </div>
</div>




<div class="modal fade" id="topClientAllModal" tabindex="-1" role="dialog" aria-labelledby="topClientAllModal" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <!-- <h5 class="modal-title" id="exampleModalLabel">New message</h5> -->
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body modal-height admin-portfolio">


        <div class="table-responsive">
          <table  class="table table-hover acrylic modal_table">

               <!-- <caption class="text-center table-heading">TOP PERFORMING CLIENTS</caption> -->
              <thead>
                  <tr>
                    <th width="60">TOP PERFORMING CLIENTS</th>
                    <th width="20" class="text-right">DRAWING POWER</th>
                    <th width="20" class="text-right">LOAN O/S </th>
                  </tr>
              </thead>
              <tbody>
                  <tr>
                      <td>KARVY SCRIP BROKING LIMITED</td>
                      <td class="text-right">987,65</td>
                      <td class="text-right">999,99</td>
                  </tr>
                  <tr>
                    <td>AMRAPALI AADYA TRADING AND INVESTMENT PRIVATE LIMITED</td>
                    <td class="text-right">876,54</td>
                    <td class="text-right">888,88</td>
                  </tr>
                  <tr>
                    <td>Carolina Biggleswade</td>
                    <td class="text-right">65</td>
                    <td class="text-right">98</td>
                  </tr>
                  <tr>
                    <td>Carolina Biggleswade</td>
                    <td class="text-right">65</td>
                    <td class="text-right">98</td>
                  </tr>
                  <tr>
                      <td>KARVY SCRIP BROKING LIMITED</td>
                      <td class="text-right">987,65</td>
                      <td class="text-right">999,99</td>
                  </tr>
                  <tr>
                    <td>AMRAPALI AADYA TRADING AND INVESTMENT PRIVATE LIMITED</td>
                    <td class="text-right">876,54</td>
                    <td class="text-right">888,88</td>
                  </tr>
                  <tr>
                    <td>Carolina Biggleswade</td>
                    <td class="text-right">65</td>
                    <td class="text-right">98</td>
                  </tr>
                  <tr>
                    <td>Carolina Biggleswade</td>
                    <td class="text-right">65</td>
                    <td class="text-right">98</td>
                  </tr>
                  <tr>
                      <td>KARVY SCRIP BROKING LIMITED</td>
                      <td class="text-right">987,65</td>
                      <td class="text-right">999,99</td>
                  </tr>
                  <tr>
                    <td>AMRAPALI AADYA TRADING AND INVESTMENT PRIVATE LIMITED</td>
                    <td class="text-right">876,54</td>
                    <td class="text-right">888,88</td>
                  </tr>
                  <tr>
                    <td>Carolina Biggleswade</td>
                    <td class="text-right">65</td>
                    <td class="text-right">98</td>
                  </tr>
                  <tr>
                    <td>Carolina Biggleswade</td>
                    <td class="text-right">65</td>
                    <td class="text-right">98</td>
                  </tr>

                  <tr>
                      <td>KARVY SCRIP BROKING LIMITED</td>
                      <td class="text-right">987,65</td>
                      <td class="text-right">999,99</td>
                  </tr>
                  <tr>
                    <td>AMRAPALI AADYA TRADING AND INVESTMENT PRIVATE LIMITED</td>
                    <td class="text-right">876,54</td>
                    <td class="text-right">888,88</td>
                  </tr>
                  <tr>
                    <td>Carolina Biggleswade</td>
                    <td class="text-right">65</td>
                    <td class="text-right">98</td>
                  </tr>
                  <tr>
                    <td>Carolina Biggleswade</td>
                    <td class="text-right">65</td>
                    <td class="text-right">98</td>
                  </tr>

                  <tr>
                      <td>KARVY SCRIP BROKING LIMITED</td>
                      <td class="text-right">987,65</td>
                      <td class="text-right">999,99</td>
                  </tr>
                  <tr>
                    <td>AMRAPALI AADYA TRADING AND INVESTMENT PRIVATE LIMITED</td>
                    <td class="text-right">876,54</td>
                    <td class="text-right">888,88</td>
                  </tr>
                  <tr>
                    <td>Carolina Biggleswade</td>
                    <td class="text-right">65</td>
                    <td class="text-right">98</td>
                  </tr>
                  <tr>
                    <td>Carolina Biggleswade</td>
                    <td class="text-right">65</td>
                    <td class="text-right">98</td>
                  </tr>




              </tbody>
          </table>
       </div>


      </div>
      <!-- <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div> -->
    </div>
  </div>
</div>




<div class="modal fade" id="concentrationAllModal" tabindex="-1" role="dialog" aria-labelledby="concentrationAllModal" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content ">
      <div class="modal-header">
        <!-- <h5 class="modal-title" id="exampleModalLabel">New message</h5> -->
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body modal-height admin-portfolio ">


        <div class="table-responsive">
          <table  class="table table-hover acrylic admin-portfolio modal_table">
            <!-- <caption class="text-center table-heading">CONCENTRATION</caption> -->

              <thead>
                  <tr>
                    <th width="50">CLIENT</th>
                    <th width="8" class="text-right">LOAN AMOUNT</th>
                    <th width="8" class="text-right hidden-overflow">Drawing Power</th>
                    <th width="8" class="text-right">MARKET VALUE</th>
                    <th width="20">SCRIP</th>
                      <th width="6" class="text-right"> CONCENTRATION%</th>
                  </tr>
              </thead>
              <tbody>


                  <tr>
                    <td ><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AFFLUENCE SHARES AND SCRIPS PRIVATE LIMITED</a></td>


                      <td class="text-right">2695</td>
                        <td class="text-right">1,54,94,839</td>

                        <td class="text-right">3,07,89,679</td>
                        <td >ZEE NEWS LTD</td>
                        <td class="text-right">11.09</td>
                  </tr>
                  <tr>
                    <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AIRAN FINSCRIPS PRIVATE LIMITED</a></td>

                      <td class="text-right">1656</td>
                      <td class="text-right">1,10,93,313</td>
                        <td class="text-right">2,21,86,627</td>

                        <td>ZEN TECHNOLOGIES LIMITED</td>
                        <td class="text-right">7.99</td>
                  </tr>
                  <tr>
                    <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AMRAPALI AADYA TRADING AND INVESTMENT PRIVATE LIMITED</a></td>


                      <td class="text-right">8739</td>
                      <td class="text-right">78,01,686</td>
                        <td class="text-right">1,95,04,215</td>
                        <td>ZENSAR TECHNOLOGIES LTD</td>
                        <td class="text-right">5.62</td>
                  </tr>
                  <tr>
                      <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AMRAPALI AADYA TRADING AND INVESTMENTS PVT LTD</a></td>
                      <td class="text-right">1994</td>
                      <td class="text-right">50,100</td>
                        <td class="text-right">1,40,12,923.25</td>
                        <td >ZICOM ELECTRONIC SCRIP SYSTEMS LTD</td>
                        <td class="text-right">3.60</td>
                  </tr>

                  <tr>
                    <td ><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AFFLUENCE SHARES AND SCRIPS PRIVATE LIMITED</a></td>


                      <td class="text-right">2695</td>
                        <td class="text-right">1,54,94,839</td>

                        <td class="text-right">3,07,89,679</td>
                        <td >ZEE NEWS LTD</td>
                        <td class="text-right">11.09</td>
                  </tr>
                  <tr>
                    <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AIRAN FINSCRIPS PRIVATE LIMITED</a></td>

                      <td class="text-right">1656</td>
                      <td class="text-right">1,10,93,313</td>
                        <td class="text-right">2,21,86,627</td>

                        <td>ZEN TECHNOLOGIES LIMITED</td>
                        <td class="text-right">7.99</td>
                  </tr>
                  <tr>
                    <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AMRAPALI AADYA TRADING AND INVESTMENT PRIVATE LIMITED</a></td>


                      <td class="text-right">8739</td>
                      <td class="text-right">78,01,686</td>
                        <td class="text-right">1,95,04,215</td>
                        <td>ZENSAR TECHNOLOGIES LTD</td>
                        <td class="text-right">5.62</td>
                  </tr>
                  <tr>
                      <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AMRAPALI AADYA TRADING AND INVESTMENTS PVT LTD</a></td>
                      <td class="text-right">1994</td>
                      <td class="text-right">50,100</td>
                        <td class="text-right">1,40,12,923.25</td>
                        <td class="text-right">ZICOM ELECTRONIC SCRIP SYSTEMS LTD</td>
                        <td class="text-right">3.60</td>
                  </tr>

                  <tr>
                    <td ><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AFFLUENCE SHARES AND SCRIPS PRIVATE LIMITED</a></td>


                      <td class="text-right">2695</td>
                        <td class="text-right">1,54,94,839</td>

                        <td class="text-right">3,07,89,679</td>
                        <td >ZEE NEWS LTD</td>
                        <td class="text-right">11.09</td>
                  </tr>
                  <tr>
                    <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AIRAN FINSCRIPS PRIVATE LIMITED</a></td>

                      <td class="text-right">1656</td>
                      <td class="text-right">1,10,93,313</td>
                        <td class="text-right">2,21,86,627</td>

                        <td>ZEN TECHNOLOGIES LIMITED</td>
                        <td class="text-right">7.99</td>
                  </tr>
                  <tr>
                    <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AMRAPALI AADYA TRADING AND INVESTMENT PRIVATE LIMITED</a></td>


                      <td class="text-right">8739</td>
                      <td class="text-right">78,01,686</td>
                        <td class="text-right">1,95,04,215</td>
                        <td>ZENSAR TECHNOLOGIES LTD</td>
                        <td class="text-right">5.62</td>
                  </tr>
                  <tr>
                      <td><a class="cursor-pointer" data-toggle="modal" data-target="#ClientModal">AMRAPALI AADYA TRADING AND INVESTMENTS PVT LTD</a></td>
                      <td class="text-right">1994</td>
                      <td class="text-right">50,100</td>
                        <td class="text-right">1,40,12,923</td>
                        <td class="text-right">ZICOM ELECTRONIC SCRIP SYSTEMS LTD</td>
                        <td class="text-right">3.60</td>
                  </tr>


              </tbody>
          </table>
       </div>


      </div>
      <!-- <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div> -->
    </div>
  </div>
</div>

<!-- Scrip modal -->


<div class="modal fade" id="ScripModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <!-- <h5 class="modal-title" id="exampleModalLabel">New message</h5> -->
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body modal-height admin-portfolio ">


        <div class="table-responsive">
         <table  class="table table-hover acrylic modal_table">
             <thead>
                 <tr>
                   <th>Client Name</th>

                   <th class="text-right">Drawing Power </th>
                 </tr>
             </thead>
             <tbody>

                 <tr v-for="(client,index) in clientList">
                     <td>{{client.name}}</td>
                     <td class="text-right">{{client.drawingPower}}</td>
                 </tr>

            <!--
                 <tr>
                     <td>Harry Sparrowhead</td>
                     <td class="text-right">8978</td>

                 </tr>
                 <tr>
                     <td>Marjorie Doors</td>

                     <td class="text-right">7678</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                     <td class="text-right">9812</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                     <td class="text-right">982</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                     <td class="text-right">983</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                     <td class="text-right">9845</td>

                 </tr>
                 <tr>
                     <td>Earnest </td>
                     <td class="text-right">9845</td>

                 </tr>
                 <tr>
                     <td> Piggington-Smithe</td>
                     <td class="text-right">9845</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                     <td class="text-right">9845</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                     <td class="text-right">9845</td>

                 </tr>
             -->
             </tbody>
         </table>
       </div>


      </div>
      <!-- <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div> -->
    </div>
  </div>
</div>


<!-- ClientModal -->

<div class="modal fade" id="ClientModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <!-- <h5 class="modal-title" id="exampleModalLabel">New message</h5> -->
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body modal-height admin-portfolio ">


        <div class="table-responsive">
         <table  class="table table-hover acrylic modal_table">
             <thead>
                 <tr>
                   <th>SCRIP</th>
                   <th class="text-right">%CHANGE</th>
                   <th class="text-right" >HOLDING</th>
                 </tr>
             </thead>
             <tbody>
                 <tr>
                     <td>Carolina Biggleswade</td>

                     <td class="text-right">65</td>
                     <td class="text-right">13,25,487</td>
                 </tr>
                 <tr>
                     <td>Harry Sparrowhead</td>

                     <td class="text-right">89</td>
                     <td class="text-right"> 15,78,125</td>
                 </tr>
                 <tr>
                     <td>Marjorie Doors</td>

                     <td class="text-right">76</td>
                     <td class="text-right">124,78,12</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,78,12</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right"> 124,77,45</td>
                 </tr>
                 <tr>
                     <td>Carolina Biggleswade</td>

                     <td class="text-right">65</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Harry Sparrowhead</td>

                     <td class="text-right">89</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Marjorie Doors</td>

                     <td class="text-right">76</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                    <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>

                     <td class="text-right">98</td>
                     <td class="text-right">124,77,45</td>
                 </tr>

             </tbody>
         </table>
       </div>


      </div>
      <!-- <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div> -->
    </div>
  </div>
</div>

<!-- MarketModal -->


<div class="modal fade" id="MarketModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <!-- <h5 class="modal-title" id="exampleModalLabel">New message</h5> -->
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body modal-height admin-portfolio ">


        <div class="table-responsive">
         <table  class="table table-hover acrylic modal_table">
             <thead>
                 <tr>
                   <th>SCRIP</th>
                     <th class="text-right">% CHANGE</th>
                   <th class="text-right">HOLDING</th>
                 </tr>
             </thead>
             <tbody>
                 <tr>
                     <td>Carolina Biggleswade</td>
                     <td class="text-right">-7.2</td>
                     <td class="text-right">124587</td>
                 </tr>
                 <tr>
                     <td>Harry Sparrowhead</td>
                              <td class="text-right">-5.2</td>
                     <td class="text-right">8978</td>

                 </tr>
                 <tr>
                     <td>Marjorie Doors</td>
                      <td class="text-right">-8.2</td>
                     <td class="text-right">7678</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                              <td class="text-right">3.2</td>
                     <td class="text-right">9812</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                              <td class="text-right">4.2</td>
                     <td class="text-right">982</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                              <td class="text-right">5.2</td>
                     <td class="text-right">983</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                        <td class="text-right">-25.2</td>
                     <td class="text-right">9845</td>

                 </tr>
                 <tr>
                     <td>Earnest </td>
                      <td class="text-right">-3.2</td>
                     <td class="text-right">9845</td>

                 </tr>
                 <tr>
                     <td> Piggington-Smithe</td>
                      <td class="text-right">-4.2</td>
                     <td class="text-right">9845</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                        <td class="text-right">7.2</td>
                     <td class="text-right"> 9845</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                      <td class="text-right">4.2</td>
                     <td class="text-right">9845</td>

                 </tr>
                 <tr>
                     <td>Carolina Biggleswade</td>
                     <td class="text-right">-7.2</td>
                     <td class="text-right">124587</td>
                 </tr>
                 <tr>
                     <td>Harry Sparrowhead</td>
                              <td class="text-right">-5.2</td>
                     <td class="text-right">8978</td>

                 </tr>
                 <tr>
                     <td>Marjorie Doors</td>
                      <td class="text-right">-8.2</td>
                     <td class="text-right">7678</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                              <td class="text-right">3.2</td>
                     <td class="text-right">9812</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                              <td class="text-right">4.2</td>
                     <td class="text-right">982</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                              <td class="text-right">5.2</td>
                     <td class="text-right">983</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                        <td class="text-right">-25.2</td>
                     <td class="text-right">9845</td>

                 </tr>
                 <tr>
                     <td>Earnest </td>
                      <td class="text-right">-3.2</td>
                     <td class="text-right">9845</td>

                 </tr>
                 <tr>
                     <td> Piggington-Smithe</td>
                      <td class="text-right">-4.2</td>
                     <td class="text-right">9845</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                        <td class="text-right">7.2</td>
                     <td class="text-right"> 9845</td>

                 </tr>
                 <tr>
                     <td>Earnest Piggington-Smithe</td>
                      <td class="text-right">4.2</td>
                     <td class="text-right">9845</td>

                 </tr>
             </tbody>
         </table>
       </div>


      </div>

    </div>
  </div>
</div>


</div>
</template>


<script>

import AdminHeader from "./AdminHeader"
// import AdminSidebar from "./AdminSidebar"
import AdminFooter from "./AdminFooter"

// var google = require('https://www.gstatic.com/charts/loader.js');

console.log("google",google.charts);

export default {
  name:'MyPortfolio',
  data(){
    return{
      name:'0',
      IsBind:true,
      graphCount:2,
      toggleTopCircuit:false,
      gainerList:[],
      loserList:[],
      scripId:'',
      clientList:[],
 rows:[10,20,30,40],
 columns:['a','b','c','d'],
 options:{
   title:'This is a first app',
   data:[10,20,30,40,50,60]
 },
       first_data : [70, 40, 55, 80, 55],
       second_data : [20, 30, 20, 10, 5],
       mylabels : ['A', 'B', 'C', 'D', 'E'],

       mylabelsLine: ["January", "February", "March", "April", "May", "June", "July"],
          mydatasets:[{
              label: "My first dataset",
              fill: false,
              lineTension: 0.1,
              backgroundColor: "rgba(75,192,192,0.4)",
              borderColor: "rgba(75,192,192,1)",
              borderCapStyle: 'butt',
              borderDash: [],
              borderDashOffset: 0.0,
              borderJoinStyle: 'miter',
              pointBorderColor: "rgba(75,192,192,1)",
              pointBackgroundColor: "#fff",
              pointBorderWidth: 1,
              pointHoverRadius: 5,
              pointHoverBackgroundColor: "rgba(75,192,192,1)",
              pointHoverBorderColor: "rgba(220,220,220,1)",
              pointHoverBorderWidth: 2,
              pointRadius: 1,
              pointHitRadius: 10,
              data: [65, 59, 80, 81, 56, 55, 40],
              spanGaps: false,
          },
          {
              label: "My second dataset",
              fill: false,
              lineTension: 0.1,
              backgroundColor: "rgba(75,192,192,0.4)",
              borderColor: "rgba(75,192,192,1)",
              borderCapStyle: 'butt',
              borderDash: [],
              borderDashOffset: 0.0,
              borderJoinStyle: 'miter',
              pointBorderColor: "rgba(75,192,192,1)",
              pointBackgroundColor: "#fff",
              pointBorderWidth: 1,
              pointHoverRadius: 5,
              pointHoverBackgroundColor: "rgba(75,192,192,1)",
              pointHoverBorderColor: "rgba(220,220,220,1)",
              pointHoverBorderWidth: 2,
              pointRadius: 1,
              pointHitRadius: 10,
              data: [0, 20, 40, 41, 66, 25, 80],
              spanGaps: false,
          },],



          mywidth: 4,
            mypointbordercolor : '#f35009',
            hoverwidth : 3,
            hoverbackgroundcolor : '#636b6f',
            hoverbordercolor : '#ffd663',
            mybordercolor : 'green',
            chatLine1:[60,70,80,90],
            chatLine2:[50,50,50,50],
            chatLine3:[10,20,30,40]


    }
  },

  mounted: function(){
    this.getTopGainersAndLoosers();
    setTimeout(() => {
    google.charts.setOnLoadCallback(this.drawChart());
    google.charts.setOnLoadCallback(this.drawLineChart());
    google.charts.setOnLoadCallback(this.drawScatterChart());

  }, 1000);


  // this.dataTable = $('.data_table').DataTable({
  //   responsive: true,
  //   "paging":   false,
  //   "filter":   false,
  //   "info": false,
  //
  // });

  this.dataTable = $('.modal_table').DataTable({
    responsive: true,
    "aLengthMenu": [[25, 50, 75, 100], [25, 50, 75,100]],
        "iDisplayLength": 25,
    "language": {
         "lengthMenu": "Display _MENU_",
         "zeroRecords": "Nothing found - sorry",
         "info": "Showing page _PAGE_ of _PAGES_",
         "infoEmpty": "No records available",
         "infoFiltered": "(filtered from _MAX_ total records)"
     }

  });






},

  watch:{

      '$route': function(newRoute, oldRoute) {
        console.log("call watch methods");
        // location.reload();
          if(oldRoute.fullPath != newRoute.fullPath){



          }

        },
        route: {
         canReuse: true,
       },

      },

  components: {
    "admin-header":AdminHeader,
    "admin-footer":AdminFooter
  },
  methods:{

    openScripClientModal(scripId){
     var app = this;
     app.scripId = '';
     app.scripId = scripId;

     var app = this;
     var url = "http://localhost:5555/api/get-client-list-by-scrip/"+app.scripId ;

     var xAuth = "28ebbac9-3867-419b-9fcf-d0c04adc391c";

             app.$http.get(
                    url,
                   {
                     headers: {
                       "X-Authorization": xAuth
                     },
                 }
            ).then(function(response) {
              console.log(response);
              if(response.data.status=='SUCCESS'){
               app.clientList = response.data.payLoad;
               $('#ScripModal').modal('show');
              }
            });
    },
    getTopGainersAndLoosers(){

    var app = this;
    var url = "http://localhost:5555/api/get-top-and-low-gainers" ;

    var xAuth = "28ebbac9-3867-419b-9fcf-d0c04adc391c";

            app.$http.get(
                   url,
                  {
                    headers: {
                      "X-Authorization": xAuth
                    },
                }
           ).then(function(response) {
             console.log(response);
             if(response.data.status=='SUCCESS'){
              app.gainerList = response.data.payLoad.gainerList;
              app.loserList = response.data.payLoad.loserList;
             }
           });
    },

     drawChart() {
      // Define the chart to be drawn.
      var data = google.visualization.arrayToDataTable([
          ['Month', 'DP', 'LOAN', 'CAT1', 'MARKET VALUE'],
          ['1',  165,      938,         522,             998],
          ['2',  135,      1120,        599,             1268],
          ['3',  587,      1167,        168,             807],
          ['4',  139,      1110,        615,             968],
          ['5',  629,      691,         136,             1026],
          ['6',  139,      1110,        615,             968],
          ['7',  135,      1120,        599,             1268]
       ]);





       var options = {
       title : 'MARKET VALUE/CAT1/DP/LOAN',
      //  vAxis: {title: 'MARKET VALUE'},
      //  vAxis: {title: 'LOAN'},
       hAxis: {title: 'DAYS'},
       seriesType: 'bars',

      series: {
            0: {
                type: "bars",
                targetAxisIndex: 1,
                color: "#20B2AA"
            },
            1: {
                type: "line",
                targetAxisIndex: 0,
                color: "#FF4500"
            },
            2: {
                type: "bars",
                targetAxisIndex: 1,
                color: "#FF4500"
            },
            3: {
                type: "bars",
                targetAxisIndex: 1,
                color: "#4169E1"
            },

        },
        vAxes: {
           0: {title: 'MARKET VALUE', textPosition: 'out', minValue: 0, maxValue:4},
           1: {title: 'LOAN', textPosition: 'out', minValue:0, maxValue: 4},

      },
       isStacked: true
     };

     var chart = new google.visualization.ComboChart(document.getElementById('myPieChart'));
   chart.draw(data, options);

    //   var chart = new google.visualization.PieChart(document.getElementById('myPieChart'));
    //  chart.draw(data, options);

  },
  drawLineChart() {




        var data = google.visualization.arrayToDataTable([
    ['date', 'MARKET CAP OF DP', 'MARKET CAP OF MV','SHORTFALL CLIENT1', 'SHORTFALL CLIENT2', 'SHORTFALL CLIENT3', 'SHORTFALL CLIENT4', 'SHORTFALL CLIENT5'],
    ["1 day", 700, 1300 , 120, 120, 200, 450 , 420],
    ["2 day", 750, 1200 , 100, 150, 250, 120 , 350],
    ["3 day", 659, 1340, 200, 420, 360, 400, 480],
    ["4 day", 840, 1300, 300, 250, 480, 250, 420],
    ["5 day", 700, 1400, 120, 120, 200, 80, 350],
    ["6 day", 754, 1209 , 110, 140, 280, 180, 460],
    ["7 day", 789, 1320, 250, 630, 450, 500, 420],

  ]);
  var options = {
    title: 'TOP  5 CLIENTS SHORTFALL',
    // hAxis: {
    //   showTextEvery: 5
    // },
    hAxis: {title: 'DAYS'},
    vAxes: {
      0: {
        viewWindowMode: 'explicit',
        viewWindow: {
          max: 1400,
          min: 82
        },
        gridlines: {
          color: 'transparent'
        },

      },
      1: {
        gridlines: {
          color: 'transparent'
        },
        format: "#"

      },
    },
    series: {
      0: {
        targetAxisIndex: 0
      },
      1: {
        targetAxisIndex: 1
      },

    },
    vAxes: {
       0: {title: 'MARKET VALUE', textPosition: 'out', minValue: 0, maxValue:4},
       1: {title: 'DP', textPosition: 'out', minValue:0, maxValue: 4},

  },



  };
        //  var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
        //  chart.draw(data, options);









      },
      drawScatterChart(){

                var data = new google.visualization.DataTable();
                data.addColumn('number', 'Student ID');
                data.addColumn('number', 'BELOW SHORTFALL');
                data.addColumn({type: 'string', role: 'tooltip'});
                  data.addColumn('number', 'ABOVE SHORTFALL');
                 data.addColumn({type: 'string', role: 'tooltip'});
                 data.addColumn('number', 'COMPLIANCE COVER');
                    data.addRows([
                       [0, 1.5, 'Coal India',2.4,  'Reliance' ,2],
                      [2, 1.9, 'ITC',  3.1,  'HDFC' ,2],
                      [3, 1.6, 'Sun Pharma', 3.5,  'ONGC' ,2],
                      [4, 1.8, 'SBI', 3,   'TCS'  ,2],
                      [5, 1,  'Hindustan Unilever',  3.8,  'WIPRO'  ,2]


                    ]);

                   var options = {
                     tooltip: { isHtml: true },
                    chart: {
                             title: 'Students\' Final Grades',
                             subtitle: 'based on hours studied'
                           },
                     seriesType: 'scatter',
                      series: {

                           0: {
                                 type: "scatter",
                                 color: "red",
                                 pointShape: 'diamond'

                             },
                              1: {
                                 type: "scatter",
                                 color: "#008000",

                             },
                                 2: {
                                 type: "line",
                                 color: "#FFD700",

                             },
                      },
                      title: 'COMPLIANCE SHORTFALL TRACKING',
                          vAxes: {
                           0: {title: 'VALUE OF COVER', textPosition: 'out'},

                         },

                    };

                     var chart = new google.visualization.ComboChart(document.getElementById('scatter_div'));
                    chart.draw(data, options)




  // var data = new google.visualization.DataTable(
  //               {
  //                   cols: [
  //                       {id: 'A', label: 'A', type: 'number'},
  //                       {id: 'B', label: 'B', type: 'number'},
  //                       {id: 'C', label: 'C', type:'number'}
  //                   ],
  //                   rows: [
  //                       {c:[{v: 2}, {v: 3}, {v:'Allen'}]},
  //                       {c:[{v: 4}, {v: 2}, {v:'Tom'}]},
  //                       {c:[{v: 1}, {v: 3}, {v:'Sim'}]}
  //
  //                   ]
  //               })
  //
  //               var options = {
  //                   title: 'Age vs. Weight comparison',
  //                   hAxis: {title: 'Age', minValue: 1, maxValue: 5},
  //                   vAxis: {title: 'Weight', minValue: 1, maxValue: 5},
  //                   legend: ''
  //               };
  //
  //               var chart = new google.visualization.ScatterChart(document.getElementById('scatter_div'));
  //               chart.draw(data, options);





 },
    refresPage: function(){
      console.log("coll refresh page",this.$store.getters.getRefreshPage);
      if(!this.$store.getters.getRefreshPage){
        this.$store.commit('setRefreshPage',true);
        location.reload();
      }
    },
    showCircuit(value){
      console.log('show circuit---',value);
      if(value == 'true'){
          this.toggleTopCircuit=true;
        setTimeout(() => {


      }, 1000);

      }else{
          this.toggleTopCircuit=false;
        setTimeout(() => {


      }, 1000);
      }

    }

  }
}
</script>
<styple scoped>
  .bg-color{
    background-color: white !important;
  }

</style>
