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
import lecho.lib.hellocharts.view.LineChartView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.graphics.Color;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;


public class Activity_graphics extends AppCompatActivity {

    ColumnChartData chartDatas;
    LineChartView lineChartView;
    private ApiAsesor apiInterface;
    private List<Advisor> advisors;
    private List<SubcolumnValue> values;
    private List<Advisor> datos2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_graphics);




        List<Column> columns = new ArrayList<Column>();




        apiInterface = ApiClient.getApiClient().create(ApiAsesor.class);
        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String dni=preferences.getString("dni","def");

        Call<List<Advisor>> call = apiInterface.getAdvisor("http://trainingcomercial.com/HughesNetApp/ListaAsesores.php?"+"dni="+dni);
        call.enqueue(new Callback<List<Advisor>>() {


                         @Override
                         public void onResponse(Call<List<Advisor>> call, Response<List<Advisor>> response) {
                             int numSubcolumns = 1;
                             int numColumns = 3;
                             datos2=response.body();
                             String apellido= datos2.get(0).getSurname();
                             String dni= datos2.get(0).getSurname();
                             String aptitud= datos2.get(0).getAptitud().substring(0,2);
                             String actitud=datos2.get(0).getActitud().substring(0,2);

//                             chartDatas.setColumns(v);



                             int iTest = Integer.parseInt(aptitud);
                           //  Toast.makeText(Activity_graphics.this, iTest , Toast.LENGTH_SHORT).show();
                             values = new ArrayList<SubcolumnValue>();
                             values.add(new SubcolumnValue(1, ChartUtils.COLOR_GREEN));
                             columns.add(new Column(values));


                             ColumnChartData columnChartData = new ColumnChartData(columns);
                             columnChartData.setColumns(columns);

/*
                             for (int i = 0; i < numColumns; ++i) {

                                 values = new ArrayList<SubcolumnValue>();
                                 for (int j = 0; j < numSubcolumns; ++j) {
                                     values.add(new SubcolumnValue(5, ChartUtils.COLOR_GREEN));
                                  */
/*   values.add(new SubcolumnValue(2, ChartUtils.COLOR_BLUE));
                                     values.add(new SubcolumnValue(6, ChartUtils.COLOR_GREEN));*//*

                                 }

                                 columns.add(new Column(values));


                                 ColumnChartData columnChartData = new ColumnChartData(columns);
                                 columnChartData.setColumns(columns);
                             }

*/

                          /*   Axis axis=new Axis();
                             Axis axiy=new Axis().setHasLines(true);
                             List<AxisValue>axisValues=new ArrayList<>();
                             axis.setValues(axisValues);
                             axis.setName("类别");
                             axiy.setName("数量");
*/


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