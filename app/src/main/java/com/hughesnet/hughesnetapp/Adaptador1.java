package com.hughesnet.hughesnetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador1 extends RecyclerView.Adapter<Adaptador1.MyViewHoldwer> {

    String data1[], data2[], data3[], data4[], data5[], data6[];
    int images[];
    Context context;


    public Adaptador1(Context ct,String s1[],String s2[],String s3[],String s4[],String s5[],String s6[],int img[]){

        context = ct;
        data1 =s1;
        data2=s2;
        data3=s3;
        data4=s4;
        data5=s5;
        data6=s6;
        images=img;


    }

    public class MyViewHoldwer extends RecyclerView.ViewHolder{

        TextView myName1,myName2,myAdress1,myPhone1,myProvince,myEstado;
        ImageView myImage;


        public MyViewHoldwer(@NonNull View itemView) {
            super(itemView);
            myName1= itemView.findViewById(R.id.id_name);
            myName2=itemView.findViewById(R.id.id_surname);
            myAdress1=itemView.findViewById(R.id.id_address);
            myPhone1=itemView.findViewById(R.id.id_phone);
            myProvince=itemView.findViewById(R.id.id_province);
            myEstado=itemView.findViewById(R.id.id_estado);
            //myImage=itemView.findViewById(R.id.myImageView);
        }
    }


    @NonNull
    @Override
    public MyViewHoldwer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.myrow,parent,false);


        return new MyViewHoldwer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoldwer holder, int position) {
        holder.myName1.setText(data1[position]);
        holder.myName2.setText(data2[position]);
        holder.myPhone1.setText(data3[position]);
        holder.myAdress1.setText(data4[position]);
        holder.myProvince.setText(data5[position]);
        holder.myEstado.setText(data6[position]);
       // holder.myImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
