package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Reclutado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner spinner1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclutado);


        spinner1=findViewById(R.id.spinner_ciudad);
        String[] ciudades={"Quito","Guayaquil","Cuenca","Otros"};

        ArrayAdapter <String> adapter1= new ArrayAdapter<String>(this, R.layout.spinner_item_forma, ciudades);
        spinner1.setAdapter(adapter1);
    }
}