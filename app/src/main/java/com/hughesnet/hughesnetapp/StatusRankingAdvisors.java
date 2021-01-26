package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.hughesnet.hughesnetapp.adapter.RecyclerAdapterClient;
import com.hughesnet.hughesnetapp.api.ApiAsesor;
import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;

public class StatusRankingAdvisors extends AppCompatActivity {

    public static String Ides;
    RecyclerView recyclerView;
    private RecyclerAdapterClient adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ApiAsesor apiInterface;
    private List<Asesor> asesores;
    public  static String Estados;


}
