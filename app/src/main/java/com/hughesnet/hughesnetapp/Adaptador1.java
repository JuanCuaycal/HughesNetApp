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

    String data1[], data2[];
    int images[];
    Context context;


    public Adaptador1(Context ct,String s1[],String s2[],int img[]){

        context = ct;
        data1 =s1;
        data2=s2;
        images=img;


    }

    public class MyViewHoldwer extends RecyclerView.ViewHolder{

        TextView myText1,myText2;
        ImageView myImage;


        public MyViewHoldwer(@NonNull View itemView) {
            super(itemView);
            myText1= itemView.findViewById(R.id.tarjetero_txt);
            myText2=itemView.findViewById(R.id.descripcion_txt);
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
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
