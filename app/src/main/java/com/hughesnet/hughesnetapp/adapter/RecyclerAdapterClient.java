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

import com.hughesnet.hughesnetapp.CambioEstado;
import com.hughesnet.hughesnetapp.Formulario;
import com.hughesnet.hughesnetapp.PopUp_DetalleAdv;
import com.hughesnet.hughesnetapp.R;
import com.hughesnet.hughesnetapp.StatusReferidosActivity;
import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;

public class RecyclerAdapterClient extends RecyclerView.Adapter<RecyclerAdapterClient.MyViewHolder> implements View.OnClickListener {
    private static Context context;

    List<Asesor> asesores;

    public  static String Estados;
    private View.OnClickListener listener;
    public RecyclerAdapterClient(List<Asesor> asesores) {
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


        holder.txtSurname.setText(asesores.get(position).getSurname());
        holder.txtName.setText(asesores.get(position).getName());
        holder.txtaddress.setText(asesores.get(position).getAddress());
        holder.txtPhone.setText(asesores.get(position).getPhone());
        holder.txtProvince.setText(asesores.get(position).getProvince());
        holder.txtStatus.setText(asesores.get(position).getStatus());


       // Glide.with(holder.foto.getContext()).asBitmap().load("https://frutagolosa.com/FrutaGolosaApp/Administrador/images/" +ax+".jpg").transition(BitmapTransitionOptions.withCrossFade(1000)).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).transform(new CenterCrop(),new RoundedCorners(10)).apply(new RequestOptions().override(270,270)).into(holder.foto).waitForLayout();


        holder.btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String map = "http://maps.google.co.in/maps?q=" + asesores.get(position).getCord();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);


            }
        });

        holder.btn_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Phone=asesores.get(position).getPhone();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Phone));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                v.getContext().startActivity(intent);


              //  v.getContext().startActivity(new Intent(v.getContext().ACTION_CALL, Uri.parse("tel:"+Phone)));
            }
        });

        holder.btn_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(v.getContext(),"En Desarrollo Status",Toast.LENGTH_SHORT).show();;

                String dniclient = asesores.get(position).getPhone();

                v.getContext().startActivity(new Intent(v.getContext(),CambioEstado.class).putExtra(Estados,dniclient));


            }
        });


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
        TextView txtName,txtSurname,txtaddress,txtPhone,txtProvince,txtStatus;
        ImageView foto;

        Button btn_maps,btn_status,btn_llamar;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardView=(CardView) itemView.findViewById(R.id.id_cardview);
            CountDownTimer timer;


            txtName= (TextView) itemView.findViewById(R.id.id_name);
            txtSurname= (TextView) itemView.findViewById(R.id.id_surname);
            txtaddress= (TextView) itemView.findViewById(R.id.id_address);
            txtPhone= (TextView) itemView.findViewById(R.id.id_phone);
            txtProvince= (TextView) itemView.findViewById(R.id.id_province);
            txtStatus= (TextView) itemView.findViewById(R.id.id_estado);


            ///BUTTONS
             btn_maps=itemView.findViewById(R.id.button_maps_client);
             btn_status=itemView.findViewById(R.id.button_status_client);
             btn_llamar=itemView.findViewById(R.id.button_llamar_client);


        }
    }
}