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

import com.bumptech.glide.Glide;
import com.hughesnet.hughesnetapp.R;
import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;

public class RecyclerAdapterAsesor extends RecyclerView.Adapter<RecyclerAdapterAsesor.MyViewHolder> implements View.OnClickListener {
    private static Context context;

    List<Asesor> asesores;

    private View.OnClickListener listener;
    public RecyclerAdapterAsesor(List<Asesor> asesores) {
        this.asesores = asesores;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myrow, parent, false);
        view.setOnClickListener(this);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String x;


        holder.txtInformacion.setText(asesores.get(position).getSurname());
        holder.txtdescription.setText(asesores.get(position).getName());


       // Glide.with(holder.foto.getContext()).asBitmap().load("https://frutagolosa.com/FrutaGolosaApp/Administrador/images/" +ax+".jpg").transition(BitmapTransitionOptions.withCrossFade(1000)).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).transform(new CenterCrop(),new RoundedCorners(10)).apply(new RequestOptions().override(270,270)).into(holder.foto).waitForLayout();




    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);

        }
    }

    @Override
    public int getItemCount() {
        return asesores.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        CardView cardView;
        TextView etiNombre,etiNombre2,txtInformacion,txtdescription,txtesatado;
        ImageView foto;


        public MyViewHolder(View itemView) {
            super(itemView);

            cardView=(CardView) itemView.findViewById(R.id.id_cardview);
            CountDownTimer timer;

            txtInformacion= (TextView) itemView.findViewById(R.id.tarjetero_txt);
            etiNombre=(TextView) itemView.findViewById(R.id.textView13);
            etiNombre2=(TextView) itemView.findViewById(R.id.textView12);
            txtdescription= (TextView) itemView.findViewById(R.id.descripcion_txt);
            txtesatado= (TextView) itemView.findViewById(R.id.id_estado);








        }
    }
}