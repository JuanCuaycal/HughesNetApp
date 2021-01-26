/*
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

public class RecyclerAdapterRancking extends RecyclerView.Adapter<RecyclerAdapterRancking.MyViewHolder> implements View.OnClickListener{
    private static Context context;

    List<Asesor> asesores;

    private View.OnClickListener listener;
    public RecyclerAdapterRancking(List<Asesor> asesores) {
        this.asesores = asesores;
    }
   // private View.OnClickListener listener;
    @NonNull
  //  @Override
*/
/*
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_advisor, parent, false);
        view.setOnClickListener(this);



        return new RecyclerAdapterRancking().MyViewHolder(view);
    }
*//*


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String x;


        holder.txtSurname.setText(asesores.get(position).getSurname());
        holder.txtName.setText(asesores.get(position).getName());
        holder.txtaddress.setText(asesores.get(position).getAddress());
        holder.txtPhone.setText(asesores.get(position).getPhone());
        holder.txtProvince.setText(asesores.get(position).getProvince());
        holder.txtStatus.setText(asesores.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return asesores.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);

        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{


        CardView cardView;
        TextView txtName,txtSurname,txtaddress,txtPhone,txtProvince,txtStatus;
        ImageView foto;


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






        }
    }
}

*/
