package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class Referidos extends AppCompatActivity {


    public  static String Estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referidos);

        Button btn_agregar = findViewById(R.id.btn_agregar_ref);
        Button btn_grafica = findViewById(R.id.btn_grafica2);

        Button btntotal = (Button) findViewById(R.id.btn_total);
        Button btncontactado = (Button) findViewById(R.id.btn_contactado);
        Button btnpropuesto=(Button) findViewById(R.id.btn_propuesto);
        Button btnconfirm = (Button) findViewById(R.id.btn_confirm);
        Button btnvendido = (Button) findViewById(R.id.btn_vendidos);
        Button btninstall = (Button) findViewById(R.id.btn_instalado);
        Button btnnodesean = (Button) findViewById(R.id.btn_no_desean);



        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Reclutado.class);
                startActivityForResult(intent, 0);
            }
        });


        btntotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Total");
                startActivityForResult(intent,0);
            }
        });


        btncontactado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Contactado");
                startActivityForResult(intent,0);
            }
        });

        btnpropuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Propuesto");
                startActivityForResult(intent,0);
            }
        });

        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Por Confirmar");
                startActivityForResult(intent,0);
            }
        });

        btnvendido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Vendido");
                startActivityForResult(intent,0);
            }
        });

        btninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Instalado");
                startActivityForResult(intent,0);

            }
        });

        btnnodesean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"No desean");
                startActivityForResult(intent,0);
            }
        });




    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){


        }





    }
}