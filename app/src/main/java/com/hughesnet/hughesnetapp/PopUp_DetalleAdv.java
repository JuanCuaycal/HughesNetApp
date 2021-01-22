package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class PopUp_DetalleAdv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up__detalle_adv);


        DisplayMetrics medidasventana=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasventana);



        int width=medidasventana.widthPixels;
        int height=medidasventana.heightPixels;



        getWindow().setLayout((int)(width*0.95),(int)(height*0.95));
    }
}