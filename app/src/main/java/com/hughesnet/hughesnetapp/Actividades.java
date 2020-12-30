package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Actividades extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[],s2[];
    int images[]={R.drawable.mt,R.drawable.fs,R.drawable.hug,R.drawable.cm,R.drawable.t};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        recyclerView=findViewById(R.id.recyclerView);

        s1=getResources().getStringArray(R.array.Tarjetero);
        s2=getResources().getStringArray(R.array.Descripcion);


        Adaptador1 adaptador1=new Adaptador1(this,s1,s2,images);
        recyclerView.setAdapter(adaptador1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}