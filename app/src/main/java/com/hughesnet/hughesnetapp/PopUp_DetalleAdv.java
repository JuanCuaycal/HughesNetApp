package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.adapter.RecyclerAdapterNews;
import com.hughesnet.hughesnetapp.model.News;

public class PopUp_DetalleAdv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up__detalle_adv);


        final String title2 = getIntent().getStringExtra(RecyclerAdapterNews.Titulo);
        final String noticia2 = getIntent().getStringExtra(RecyclerAdapterNews.Noticia);


      //  Toast.makeText(getApplicationContext(),title2+noticia2,Toast.LENGTH_LONG).show();

        TextView id_title=findViewById(R.id.id_titulo_fin);
        TextView id_noticia=findViewById(R.id.id_notifica_fin);
        id_noticia.setText(noticia2);
        //id_title.setText(title2);

        DisplayMetrics medidasventana=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasventana);

        int width=medidasventana.widthPixels;
        int height=medidasventana.heightPixels;

        getWindow().setLayout((int)(width*0.85),(int)(height*0.75));



    }
}