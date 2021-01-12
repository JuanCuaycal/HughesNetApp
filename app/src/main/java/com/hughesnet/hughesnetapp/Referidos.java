package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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
        Button btnllamar = (Button) findViewById(R.id.btn_llamar);
        Button btnvisit = (Button) findViewById(R.id.btn_visit);
        Button btnconfirm = (Button) findViewById(R.id.btn_confirm);
        Button btnvendido = (Button) findViewById(R.id.btn_vendidos);
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


        btnllamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Llamar");
                startActivityForResult(intent,0);
            }
        });

        btnvisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Visitar");
                startActivityForResult(intent,0);
            }
        });

        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Confirmar");
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

        btnnodesean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"No");
                startActivityForResult(intent,0);
            }
        });




    }
}