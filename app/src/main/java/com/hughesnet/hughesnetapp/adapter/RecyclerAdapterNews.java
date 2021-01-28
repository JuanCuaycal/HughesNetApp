package com.hughesnet.hughesnetapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.Html;
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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.hughesnet.hughesnetapp.Formulario;
import com.hughesnet.hughesnetapp.PopUp_DetalleAdv;
import com.hughesnet.hughesnetapp.R;
import com.hughesnet.hughesnetapp.StatusReferidosActivity;
import com.hughesnet.hughesnetapp.model.Asesor;
import com.hughesnet.hughesnetapp.model.News;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class RecyclerAdapterNews extends RecyclerView.Adapter<RecyclerAdapterNews.MyViewHolder> implements View.OnClickListener {
    private static Context context;
    public  static String Noticia;
    public  static String Titulo;
    private  int LEFT_CELL = 0;
    private  int RIGHT_CELL = 1;
    List<News> noticias;
    public  ImageView foto ;

    private View.OnClickListener listener;
    public RecyclerAdapterNews(List<News> noticias) {
        this.noticias = noticias;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news, parent, false);
        view.setOnClickListener(this);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String x;


        holder.txtfecha.setText(noticias.get(position).getFecha());
        holder.txtTitle.setText(noticias.get(position).getTitle());
        holder.txtDescriptionsNews.setText(noticias.get(position).getDescription());
/*
      try {
            String  text= new String(noticias.get(position).getDescription().getBytes("ISO-8859-1"), "UTF-8");
            String encodedText = Html.fromHtml(text).toString();
            holder.txtDescriptionsNews.setText(encodedText);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
*/







        holder.mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title =noticias.get(position).getTitle();
                String noticia =noticias.get(position).getDescription();

               // Toast.makeText(v.getContext(),title,Toast.LENGTH_LONG).show();;

                         v.getContext().startActivity(new Intent(v.getContext(),PopUp_DetalleAdv.class)
                                 .putExtra(Titulo,title)
                                 .putExtra(Noticia,noticia));


                    }
                });







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
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return LEFT_CELL;
        }
        else {
            return RIGHT_CELL;
        }
    }
    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        //CardView cardView;
        TextView txtfecha,txtTitle,txtDescriptionsNews;
        ImageView foto;
        Button mas;

        public MyViewHolder(View itemView) {
            super(itemView);

           // cardView=(CardView) itemView.findViewById(R.id.idfragmen_news);
            //CountDownTimer timer;
            foto=itemView.findViewById(R.id.imageNews);
            mas=itemView.findViewById(R.id.id_mas_news);
            txtfecha= (TextView) itemView.findViewById(R.id.id_fecha_news);
            txtTitle= (TextView) itemView.findViewById(R.id.id_title_news);
            txtDescriptionsNews= (TextView) itemView.findViewById(R.id.id_news_description);






        }
    }
}