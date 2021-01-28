package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.adapter.RecyclerAdapterAdvisor;
import com.hughesnet.hughesnetapp.adapter.RecyclerAdapterClient;
import com.hughesnet.hughesnetapp.adapter.RecyclerAdapterNews;
import com.hughesnet.hughesnetapp.api.ApiAsesor;
import com.hughesnet.hughesnetapp.api.ApiClient;
import com.hughesnet.hughesnetapp.api.ApiNews;
import com.hughesnet.hughesnetapp.model.Advisor;
import com.hughesnet.hughesnetapp.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Modulos extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerAdapterNews adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ApiNews apiNews;
    private List<News> noticias;
    public  static String Ides,tipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos);

    /////////////////////////////////////////////////////////////////

        init_news();









        //////////////////////////////////////////////

        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String passs=preferences.getString("pass","def");
        String correos=preferences.getString("mailus","def");
        String types=preferences.getString("type","def");
        String dni=preferences.getString("dni","def");


        Button btn_moodle=findViewById(R.id.btn_moodle);
        Button bt_estrategia=findViewById(R.id.btn_estrat);
        Button btn_entrenamiento=findViewById(R.id.btn_entrenam);
        Button btn_advisorCard=findViewById(R.id.btn_cardAdvisor);
        Button btn_exit=findViewById(R.id.id_exit);
        Button btn_profile=findViewById(R.id.id_exit2);
        Button btn_sta=findViewById(R.id.btn_Statictics);
        Button btn_ranking=findViewById(R.id.btn_Rancking);

        Button btn_info=findViewById(R.id.id_info);
        /////////////////////////////

        Button btn_estrategia=findViewById(R.id.id_button_estrategia);
        Button btn_planes=findViewById(R.id.id_button_planes);



        // Toast.makeText(Modulos.this, types, Toast.LENGTH_LONG).show();


        if(types.equals("0")){

            btn_moodle.setVisibility(View.VISIBLE);
            bt_estrategia.setVisibility(View.VISIBLE);
            btn_entrenamiento.setVisibility(View.GONE);
            btn_advisorCard.setVisibility(View.GONE);

        }else{

            btn_moodle.setVisibility(View.GONE);
            bt_estrategia.setVisibility(View.GONE);
            btn_entrenamiento.setVisibility(View.VISIBLE);
            btn_advisorCard.setVisibility(View.VISIBLE);



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


        btn_advisorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(v.getContext(),StatusAdvisorActivity.class);
                startActivityForResult(intent,0);


            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();

                Intent intent=new Intent(v.getContext(),MainActivity.class);
                startActivityForResult(intent,0);

            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(v.getContext(),Profile.class);
                startActivityForResult(intent,0);

            }
        });

        btn_sta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Datos.class);
                startActivityForResult(intent,0);

            }
        });



        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),Activity_graphics.class);
                startActivityForResult(intent,0);

            }
        });

        btn_ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(v.getContext(),StatusAdvisorActivity.class);
                startActivityForResult(intent,0);

            }
        });


        btn_estrategia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(v.getContext(),Activity_Estrategia.class);
                startActivityForResult(intent,0);

            }
        });

        btn_planes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*     Intent intent =new Intent(v.getContext(),Activity_Planes.class);
                startActivityForResult(intent,0);*/


                Intent intent =new Intent(v.getContext(),Activity_graphics.class);
                startActivityForResult(intent,0);



            }
        });



    }



    public void init_news(){



        recyclerView= (RecyclerView) findViewById(R.id.NoticiasRecyclerView);
        final GridLayoutManager gridLayoutManager= new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        layoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);


        apiNews = ApiClient.getApiClient().create(ApiNews.class);
        Call<List<News>> call = apiNews.getNews("http://trainingcomercial.com/HughesNetApp/news/news_change.php");

        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {

                if(response.body()!=null) {

                     noticias=response.body();
                     adapter=new RecyclerAdapterNews(noticias);
                     adapter.notifyDataSetChanged();
                     recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);
                    adapter.notifyDataSetChanged();
                    recyclerView.setNestedScrollingEnabled(false);


                    if(noticias.isEmpty()){


                        Toast.makeText(Modulos.this, "No hay noticias", Toast.LENGTH_SHORT).show();
                    }




                }




            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Algo salió mal",Toast.LENGTH_LONG).show();
            }
        });




    }


}