package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Modulos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos);



        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String passs=preferences.getString("pass","def");
        String correos=preferences.getString("mailus","def");
        String types=preferences.getString("type","def");
        String dni=preferences.getString("dni","def");


        Button btn_moodle=findViewById(R.id.btn_moodle);
        Button bt_estrategia=findViewById(R.id.btn_estrat);
        Button btn_entrenamiento=findViewById(R.id.btn_entrenam);
        Button btn_exit=findViewById(R.id.id_exit);

       // Toast.makeText(Modulos.this, types, Toast.LENGTH_LONG).show();


        if(types.equals("0")){

            btn_moodle.setVisibility(View.VISIBLE);
            bt_estrategia.setVisibility(View.VISIBLE);
            btn_entrenamiento.setVisibility(View.GONE);

        }else{

            btn_moodle.setVisibility(View.GONE);
            bt_estrategia.setVisibility(View.GONE);
            btn_entrenamiento.setVisibility(View.VISIBLE);



        }

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

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit(); // commit changes

                Intent intent=new Intent(v.getContext(),MainActivity.class);
                startActivityForResult(intent,0);
                finish();
            }
        });



    }




}