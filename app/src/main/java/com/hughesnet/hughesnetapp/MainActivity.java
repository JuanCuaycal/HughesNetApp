package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.api.ApiLogin;
import com.hughesnet.hughesnetapp.api.ApiRegister;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    public static final String ROOT_URL="http://trainingcomercial.com/HughesNetApp/userlogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Button
        Button bt1=findViewById(R.id.btn_loggin);
        Button bt2=findViewById(R.id.btn_registro);
        Button bt3=findViewById(R.id.btn_registro2);

///LOGIN

        EditText c=findViewById(R.id.id_login_correo);
        EditText p=findViewById(R.id.id_login_pass);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo=c.getText().toString().trim().replace(" ","");;
                String password=p.getText().toString().trim().replace(" ","");;

                if(correo.length()!=0 && password.length()!=0){

                    RestAdapter adapter = new RestAdapter.Builder()
                            .setEndpoint(ROOT_URL)
                            .build();

                    ApiLogin api = adapter.create(ApiLogin.class);

                    api.loggear(
                            correo,
                            password,
                            new Callback<Response>() {
                                @Override
                                public void success(Response response, Response response2) {


                                    Toast.makeText(MainActivity.this, response2.getBody().toString(), Toast.LENGTH_LONG).show();

                                    Intent intent=new Intent(view.getContext(),Modulos.class);
                                    startActivityForResult(intent,0);
                                }

                                @Override
                                public void failure(RetrofitError error) {

                                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();

                                }
                            }

                    );




                }else{


                    Toast.makeText(MainActivity.this, "Ingrese su correo y contraseña", Toast.LENGTH_LONG).show();
                }










            }
        });

//Button Registrar
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent intent=new Intent(v2.getContext(),valid_loggin.class);
                startActivityForResult(intent,0);
            }
        });



 //Button con Gmail
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),Formulario.class);
                startActivityForResult(intent,0);
               // Toast.makeText(MainActivity.this, "Estamos trabajando en esta función", Toast.LENGTH_LONG).show();
            }
        });



    }



}