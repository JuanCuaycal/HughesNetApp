package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.LineChartView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
/*
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;*/

import com.hughesnet.hughesnetapp.api.ApiAsesor;
import com.hughesnet.hughesnetapp.api.ApiClient;
import com.hughesnet.hughesnetapp.model.Advisor;
import com.hughesnet.hughesnetapp.model.ReferidosCount;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Activity_graphics extends AppCompatActivity {

    private ApiAsesor apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_graphics);

        ColumnChartView columnChart,columnChart2;

        columnChart = (ColumnChartView) findViewById(R.id.columnchart);
        columnChart2 = (ColumnChartView) findViewById(R.id.columnchart2);

        columnChart.setZoomEnabled(false);//Set whether to support zoom
        columnChart.setInteractive(true);//Set whether the chart can interact with the user
        columnChart.setValueSelectionEnabled(true);//Set whether the chart data is selected for display

        columnChart2.setZoomEnabled(false);//Set whether to support zoom
        columnChart2.setInteractive(true);//Set whether the chart can interact with the user
        columnChart2.setValueSelectionEnabled(true);//Set whether the chart data is selected for display




        apiInterface = ApiClient.getApiClient().create(ApiAsesor.class);
        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String dni=preferences.getString("dni","def");

        Call<List<Advisor>> call = apiInterface.getAdvisor("http://trainingcomercial.com/HughesNetApp/ListaAsesores.php?"+"dni="+dni);
        call.enqueue(new Callback<List<Advisor>>() {


                         @Override
                         public void onResponse(Call<List<Advisor>> call, Response<List<Advisor>> response) {



                             String actitud=response.body().get(0).getActitud().replace("%","").replace(" ","");
                             String aptitud=response.body().get(0).getAptitud().replace("%","").replace(" ","");

                             String tecnicas=response.body().get(0).getTecnicas().replace("%","").replace(" ","");
                             String ventas=response.body().get(0).getVentas().replace("%","").replace(" ","");
                             String apertura=response.body().get(0).getApertura().replace("%","").replace(" ","");
                             String presentacion=response.body().get(0).getPresentacion().replace("%","").replace(" ","");

                             String act= new DecimalFormat("#0").format(Double.parseDouble(actitud));
                            String apt= new DecimalFormat("#0").format(Double.parseDouble(aptitud));


                             String vent= new DecimalFormat("#0").format(Double.parseDouble(ventas));
                             String apert= new DecimalFormat("#0").format(Double.parseDouble(apertura));
                             String tecn= new DecimalFormat("#0").format(Double.parseDouble(tecnicas));
                             String present= new DecimalFormat("#0").format(Double.parseDouble(presentacion));




                             int green = getResources().getColor(R.color.teal_200);
                             int black = getResources().getColor(R.color.white);

                             ColumnChartData data = new ColumnChartData();


                             ColumnChartView graph = (ColumnChartView) findViewById(R.id.columnchart);

                             List<SubcolumnValue> listOfColumns = new ArrayList<SubcolumnValue>();


                             List<AxisValue> axisValuesForX = new ArrayList<AxisValue>();

                             List<AxisValue> axisValuesForY = new ArrayList<AxisValue>();


                             axisValuesForY.add(new AxisValue(50));


                             SubcolumnValue col_ = new SubcolumnValue(Integer.parseInt(act),green);
                             SubcolumnValue col_2 = new SubcolumnValue(Integer.parseInt(apt),green);

                             listOfColumns.add(col_);
                             listOfColumns.add(col_2);



                             Axis axeX = new Axis();
                             Axis axeY = new Axis(axisValuesForY);
                             axeX.setLineColor(black);
                             axeY.setLineColor(black);


                             data.setAxisXBottom(axeX.setHasLines(true));
                             data.setAxisYLeft(axeY.setHasLines(true));

                             Column column = new Column();
                             column.setValues(listOfColumns);

                             column.setHasLabels(true);

                             List<Column> columns = new ArrayList<Column>();
                             columns.add(column);

                             data.setColumns(columns);

                             axeX.setName("Actitud"+"          \t          "+"Aptitud");
                             axeY.setName("PORCENTAJES");

                             graph.setColumnChartData(data);




///////////////////////////////////////////////////////////////////////////////////////////////////////////////


                             ColumnChartData data2 = new ColumnChartData();


                             ColumnChartView graph2 = (ColumnChartView) findViewById(R.id.columnchart2);

                             List<SubcolumnValue> listOfColumns2 = new ArrayList<SubcolumnValue>();


                             List<AxisValue> axisValuesForX2 = new ArrayList<AxisValue>();

                             List<AxisValue> axisValuesForY2 = new ArrayList<AxisValue>();


                             axisValuesForY2.add(new AxisValue(50));
                             axisValuesForX2.add(new AxisValue(50));

                             SubcolumnValue col2_ = new SubcolumnValue(Integer.parseInt(vent),green);
                             SubcolumnValue col2_2 = new SubcolumnValue(Integer.parseInt(tecn),green);
                             SubcolumnValue col2_3 = new SubcolumnValue(Integer.parseInt(apert),green);
                             SubcolumnValue col2_4 = new SubcolumnValue(Integer.parseInt(present),green);


                             Toast.makeText(Activity_graphics.this, tecn, Toast.LENGTH_SHORT).show();
                             listOfColumns2.add(col2_);
                             listOfColumns2.add(col2_2);
                             listOfColumns2.add(col2_3);
                             listOfColumns2.add(col2_4);



                             Axis axeX2 = new Axis();
                             Axis axeY2 = new Axis(axisValuesForY2);
                             axeX2.setLineColor(black);
                             axeY2.setLineColor(black);


                             data2.setAxisXBottom(axeX2.setHasLines(true));
                             data2.setAxisYLeft(axeY2.setHasLines(true));

                             Column column2 = new Column();
                             column2.setValues(listOfColumns2);

                             column2.setHasLabels(true);

                             List<Column> columns2 = new ArrayList<Column>();
                             columns2.add(column2);

                             data2.setColumns(columns2);

                             axeX2.setName("Ventas"+"   "+"Técnicas"+"   "+"Apertura"+"   "+"Presentación");
                             axeY2.setName("APTITUD");

                             graph2.setColumnChartData(data2);







                         }

                         @Override
                         public void onFailure(Call<List<Advisor>> call, Throwable t) {

                         }
                     });
            // Column can have many subcolumns, here by default I use 1 subcolumn in each of 8 columns.


/*

*/




    }
}