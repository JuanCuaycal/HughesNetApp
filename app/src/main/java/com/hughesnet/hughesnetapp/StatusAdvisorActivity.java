package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.adapter.RecyclerAdapterAdvisor;
import com.hughesnet.hughesnetapp.adapter.RecyclerAdapterClient;
import com.hughesnet.hughesnetapp.api.ApiAsesor;
import com.hughesnet.hughesnetapp.api.ApiClient;
import com.hughesnet.hughesnetapp.model.Advisor;
import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusAdvisorActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerAdapterAdvisor adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ApiAsesor apiInterface;
    private List<Advisor> advisors;
    public  static String Estados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_advisor);


        recyclerView= (RecyclerView) findViewById(R.id.id_fragmen_advisor);
        final GridLayoutManager gridLayoutManager= new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        layoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);


        apiInterface = ApiClient.getApiClient().create(ApiAsesor.class);



        Call<List<Advisor>> call = apiInterface.getAdvisor("http://trainingcomercial.com/HughesNetApp/ListaAsesores.php");

call.enqueue(new Callback<List<Advisor>>() {
    @Override
    public void onResponse(Call<List<Advisor>> call, Response<List<Advisor>> response) {

        if(response.body()!=null) {
            advisors = response.body();
            adapter = new RecyclerAdapterAdvisor(advisors);
            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            adapter.notifyDataSetChanged();
            recyclerView.setNestedScrollingEnabled(false);


            adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Hola", Toast.LENGTH_LONG).show();
                }
            });

        }




    }

    @Override
    public void onFailure(Call<List<Advisor>> call, Throwable t) {
        Toast.makeText(getApplicationContext(),"mal",Toast.LENGTH_LONG).show();
    }
});

    }
}