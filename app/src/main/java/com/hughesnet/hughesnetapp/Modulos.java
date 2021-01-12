package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Modulos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos);

        Button btn_moodle=findViewById(R.id.btn_moodle);
        Button bt_estrategia=findViewById(R.id.btn_estrat);
        Button btn_entrenamiento=findViewById(R.id.btn_entrenam);


        btn_moodle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent=new Intent(view1.getContext(),moodle_web.class);
                startActivityForResult(intent,0);
            }
        });

        bt_estrategia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent intent=new Intent(view2.getContext(),Referidos.class);
                startActivityForResult(intent,0);
            }
        });

        btn_entrenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3) {
                Intent intent =new Intent(view3.getContext(),Formulario.class);
                startActivityForResult(intent,0);
            }
        });
    }




}