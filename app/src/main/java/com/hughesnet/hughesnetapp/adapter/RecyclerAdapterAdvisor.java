package com.hughesnet.hughesnetapp.adapter;


import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hughesnet.hughesnetapp.R;
import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;


public class RecyclerAdapterAdvisor extends RecyclerView.Adapter<RecyclerAdapterAdvisor.MyViewHolder> implements View.OnClickListener{


    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public RecyclerAdapterAdvisor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterAdvisor.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


/////////////////////////////////////////////////////////////////////
    public class MyViewHolder extends RecyclerView.ViewHolder{


        CardView cardView;
        TextView txtAptitud,txtActitud,txtPromedio,txtNameAdvisor;
        ImageView foto;


        public MyViewHolder(View itemView) {
            super(itemView);

            cardView=(CardView) itemView.findViewById(R.id.idcarview_advisor);
            CountDownTimer timer;


            txtNameAdvisor= (TextView) itemView.findViewById(R.id.id_nombre_advisor_card);
            txtAptitud= (TextView) itemView.findViewById(R.id.id_surname);
            txtActitud= (TextView) itemView.findViewById(R.id.id_address);
            txtPromedio= (TextView) itemView.findViewById(R.id.id_phone);







        }
    }

}
