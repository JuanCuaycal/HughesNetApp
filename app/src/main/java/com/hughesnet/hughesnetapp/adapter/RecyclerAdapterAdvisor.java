package com.hughesnet.hughesnetapp.adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hughesnet.hughesnetapp.ChangePassword;
import com.hughesnet.hughesnetapp.MainActivity;
import com.hughesnet.hughesnetapp.Profile;
import com.hughesnet.hughesnetapp.R;
import com.hughesnet.hughesnetapp.model.Advisor;
import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;


public class RecyclerAdapterAdvisor extends RecyclerView.Adapter<RecyclerAdapterAdvisor.MyViewHolder> implements View.OnClickListener{
    private static Context context;


    List<Advisor> advisors;


    private View.OnClickListener listener;
    public RecyclerAdapterAdvisor(List<Advisor> advisors) {
        this.advisors = advisors;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myrow_advisor, parent, false);
        view.setOnClickListener(this);

        return new MyViewHolder(view);

    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String x;


        holder.txtNameAdvisor.setText(advisors.get(position).getName());
        holder.txtPromedio.setText(advisors.get(position).getSurname());
        holder.txtActitud.setText(advisors.get(position).getPhone());
        holder.txtAptitud.setText(advisors.get(position).getEmail());
        holder.txtActitud2.setText(advisors.get(position).getActitud());
        holder.txtAptitud2.setText(advisors.get(position).getAptitud());
        holder.txtidclient.setText(advisors.get(position).getDni());

        String phone= advisors.get(position).getPhone();

        holder.txtReferidos.setText(advisors.get(position).getReferidos());
        holder.txtVentas.setText(advisors.get(position).getVentas());
        holder.btnllamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Phone",phone);

                /*Toast.makeText(,phone,Toast.LENGTH_LONG);*/
          /*     Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
               context.startActivity(intent);*/


                Intent i = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phone));
                RecyclerAdapterAdvisor.context.startActivity(i);

            }
        });


        // Glide.with(holder.foto.getContext()).asBitmap().load("https://frutagolosa.com/FrutaGolosaApp/Administrador/images/" +ax+".jpg").transition(BitmapTransitionOptions.withCrossFade(1000)).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).transform(new CenterCrop(),new RoundedCorners(10)).apply(new RequestOptions().override(270,270)).into(holder.foto).waitForLayout();






    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);

        }



    }
    @Override
    public int getItemCount() {
        return advisors.size();
    }


/////////////////////////////////////////////////////////////////////
    public class MyViewHolder extends RecyclerView.ViewHolder{


        CardView cardView;
         Button btnllamar;
        TextView txtAptitud,txtActitud,txtPromedio,txtNameAdvisor,txtAptitud2,txtActitud2,txtidclient,txtReferidos,txtVentas;
        ImageView foto;


        public MyViewHolder(View itemView) {
            super(itemView);

            cardView=(CardView) itemView.findViewById(R.id.id_cardview_advisor);
            CountDownTimer timer;


            txtNameAdvisor= (TextView) itemView.findViewById(R.id.id_nombre_advisor_card);
            txtPromedio= (TextView) itemView.findViewById(R.id.id_promedio);
            txtActitud= (TextView) itemView.findViewById(R.id.id_actitud);
            txtAptitud= (TextView) itemView.findViewById(R.id.id_aptitud);

            txtActitud2= (TextView) itemView.findViewById(R.id.id_actitud21);
            txtAptitud2= (TextView) itemView.findViewById(R.id.id_aptitud31);

            txtReferidos= (TextView) itemView.findViewById(R.id.id_referidos);
            txtVentas= (TextView) itemView.findViewById(R.id.id_ventas);

            txtidclient= (TextView) itemView.findViewById(R.id.id_asesor_dni);
            btnllamar=itemView.findViewById(R.id.btn_llamar);




        }
    }

}
