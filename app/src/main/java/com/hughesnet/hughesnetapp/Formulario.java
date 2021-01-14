package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.api.ApiInsertForm;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Formulario extends AppCompatActivity {
    public static final String ROOT_URL="http://trainingcomercial.com/HughesNetApp/InsertForm";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);


        EditText id_advisor=findViewById(R.id.id_asesor_form);

        CheckBox pr1=findViewById(R.id.check1);
        CheckBox pr2=findViewById(R.id.check2);
        CheckBox pr3=findViewById(R.id.check3);
        CheckBox pr4=findViewById(R.id.check4);
        CheckBox pr5=findViewById(R.id.check5);
        CheckBox pr6=findViewById(R.id.check6);
        CheckBox pr7=findViewById(R.id.check7);
        CheckBox pr8=findViewById(R.id.check8);
        CheckBox pr9=findViewById(R.id.check9);
        CheckBox pr10=findViewById(R.id.check10);

        CheckBox pr11=findViewById(R.id.check11);
        CheckBox pr12=findViewById(R.id.check12);
        CheckBox pr13=findViewById(R.id.check13);
        CheckBox pr14=findViewById(R.id.check14);
        CheckBox pr15=findViewById(R.id.check15);
        CheckBox pr16=findViewById(R.id.check16);
        CheckBox pr17=findViewById(R.id.check17);
        CheckBox pr18=findViewById(R.id.check18);
        CheckBox pr19=findViewById(R.id.check19);
        CheckBox pr20=findViewById(R.id.check20);

        CheckBox pr21=findViewById(R.id.check21);
        CheckBox pr22=findViewById(R.id.check22);
        CheckBox pr23=findViewById(R.id.check23);
        CheckBox pr24=findViewById(R.id.check24);
        CheckBox pr25=findViewById(R.id.check25);
        CheckBox pr26=findViewById(R.id.check26);
        CheckBox pr27=findViewById(R.id.check27);
        CheckBox pr28=findViewById(R.id.check28);
        CheckBox pr29=findViewById(R.id.check29);
        CheckBox pr30=findViewById(R.id.check30);


        Button sendform = findViewById(R.id.btn_enviar_form);





        sendform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fecha_pedido = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                String id_asesor=id_advisor.getText().toString().trim();

                if(validardni(id_asesor)==true){




                    String p1=trueorfalse(pr1.isChecked());
                    String p2=trueorfalse(pr2.isChecked());
                    String p3=trueorfalse(pr3.isChecked());
                    String p4=trueorfalse(pr4.isChecked());
                    String p5=trueorfalse(pr5.isChecked());
                    String p6=trueorfalse(pr6.isChecked());
                    String p7=trueorfalse(pr7.isChecked());
                    String p8=trueorfalse(pr8.isChecked());
                    String p9=trueorfalse(pr9.isChecked());
                    String p10=trueorfalse(pr10.isChecked());

                    String p11=trueorfalse(pr11.isChecked());
                    String p12=trueorfalse(pr12.isChecked());
                    String p13=trueorfalse(pr13.isChecked());
                    String p14=trueorfalse(pr14.isChecked());
                    String p15=trueorfalse(pr15.isChecked());
                    String p16=trueorfalse(pr16.isChecked());
                    String p17=trueorfalse(pr17.isChecked());
                    String p18=trueorfalse(pr18.isChecked());
                    String p19=trueorfalse(pr19.isChecked());
                    String p20=trueorfalse(pr20.isChecked());

                    String p21=trueorfalse(pr21.isChecked());
                    String p22=trueorfalse(pr22.isChecked());
                    String p23=trueorfalse(pr23.isChecked());
                    String p24=trueorfalse(pr24.isChecked());
                    String p25=trueorfalse(pr25.isChecked());
                    String p26=trueorfalse(pr26.isChecked());
                    String p27=trueorfalse(pr27.isChecked());
                    String p28=trueorfalse(pr28.isChecked());
                    String p29=trueorfalse(pr29.isChecked());
                    String p30=trueorfalse(pr30.isChecked());


                    RestAdapter adapter =new RestAdapter.Builder()
                            .setEndpoint(ROOT_URL)
                            .build();


                    ApiInsertForm api =adapter.create(ApiInsertForm.class);
                    api.insertform(id_asesor, fecha_pedido,
                            p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
                            p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
                            p21, p22, p23, p24, p25, p26, p27, p28, p29, p30,

                            new Callback<Response>() {
                                @Override
                                public void success(Response response, Response response2) {



                                    Toast.makeText(Formulario.this, "Registrado", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(v.getContext(),Modulos.class);
                                    startActivityForResult(intent,0);


                                }

                                @Override
                                public void failure(RetrofitError error) {

                                    Toast.makeText(Formulario.this, "No Registrado", Toast.LENGTH_SHORT).show();


                                }
                            }


                    );





                }else{

                    Toast.makeText(Formulario.this, "Faltan el ID del Asesor", Toast.LENGTH_SHORT).show();


                }





















            }
        });


    }


    public boolean validardni(String cadena) {
        if (cadena.matches("[0-9]*") && cadena.length()==10) {
            return true;
        } else {
            return false;
        }
    }

    public String trueorfalse(Boolean check){


        if (check==true){
             String valor= String.valueOf(1);
            return valor ;
        }else{
            String valor= String.valueOf(0);
            return valor ;
        }
    }
}