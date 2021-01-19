package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Activity_graphics extends AppCompatActivity {


    LineChartView lineChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics);

        lineChartView = findViewById(R.id.chart);


        Toast.makeText(Activity_graphics.this,"Cargando Gráfica",Toast.LENGTH_LONG).show();

        List<PointValue> values = new ArrayList<PointValue>();
        values.add(new PointValue(0, 2));
        values.add(new PointValue(1, 4));
        values.add(new PointValue(2, 4));
        values.add(new PointValue(3, 5));
        values.add(new PointValue(4, 6));
        values.add(new PointValue(5, 7));

        //In most cased you can call data model methods in builder-pattern-like manner.
        Line line = new Line(values).setColor(Color.CYAN).setCubic(true);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        lineChartView.setLineChartData(data);

    }
}
