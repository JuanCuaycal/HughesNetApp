package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hughesnet.hughesnetapp.api.ApiAsesor;
import com.hughesnet.hughesnetapp.api.ApiClient;
import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class Actividades extends AppCompatActivity {
    private ApiAsesor apiInterface;
    private List<Asesor> asesor;
    RecyclerView recyclerView;
    String s1[],s2[],s3[];
    int images[]={R.drawable.mt,R.drawable.fs,R.drawable.hug,R.drawable.cm,R.drawable.t};

    String tip="Fruta Golosa";

    Call<List<Asesor>> call = apiInterface.getAsesores("https://frutagolosa.com/FrutaGolosaApp/ArreglosEnApp.php?t="+tip+"&k=121523");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        recyclerView=findViewById(R.id.recyclerView);

/*        s1=getResources().getStringArray(R.array.Tarjetero);
        s2=getResources().getStringArray(R.array.Descripcion);
        s3=getResources().getStringArray(R.array.Estado);


        Adaptador1 adaptador1=new Adaptador1(this,s1,s2,s3,images);
        recyclerView.setAdapter(adaptador1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/

    }
}