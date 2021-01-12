package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.api.ApiRegister;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class valid_loggin extends AppCompatActivity {
    public static final String ROOT_URL="http://trainingcomercial.com/HughesNetApp/userlogin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valid_loggin);

        EditText n=findViewById(R.id.id_name_registro);
        EditText a=findViewById(R.id.id_surname_registro);
        EditText t=findViewById(R.id.id_phone_registro);
        EditText c=findViewById(R.id.id_email_registro);
        EditText d=findViewById(R.id.id_dni_registro);

        //Password
        EditText c1=findViewById(R.id.id_contrasena_register);
        EditText c2=findViewById(R.id.id_verif_contrasena_registro);


        Button send=findViewById(R.id.btn_register_advisor);






        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String telefono=t.getText().toString().trim().replace(" ","");
                String nombre=n.getText().toString().trim();
                String apellido=a.getText().toString().trim();
                String correo=c.getText().toString().replace(" ","");
                String dni=d.getText().toString().replace(" ","");

                String password=c1.getText().toString().replace(" ","");
                String password2=c2.getText().toString().replace(" ","");

             //   Toast.makeText(valid_loggin.this, pass1+" "+pass2, Toast.LENGTH_LONG).show();




        if(camposvacios(password)==false && camposvacios(password2)==false && camposvacios(nombre)==false && camposvacios(apellido)==false && validarnumero(telefono.toString())==true && correovalidar(correo)==true && validardni(dni.toString())==true){

            if(correosiguales(password,password2)==true){


                Toast.makeText(valid_loggin.this, "Registro en Proceso ", Toast.LENGTH_SHORT).show();



                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(ROOT_URL)
                        .build();

                ApiRegister api = adapter.create(ApiRegister.class);
                api.insertadvisor(
                        telefono,
                        nombre,
                        apellido,
                        correo,
                        dni,
                        password,
                        new Callback<retrofit.client.Response>() {
                            @Override
                            public void success(retrofit.client.Response result, Response response) {

                                Toast.makeText(valid_loggin.this, "Registrado", Toast.LENGTH_SHORT).show();



                                Intent f = new Intent(valid_loggin.this, MainActivity.class);
                                startActivity(f);
                                finish();
                            }



                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(valid_loggin.this, error.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
            }else{

                Toast.makeText(valid_loggin.this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                c1.setText("");
                c2.setText("");
            }


        }else{


            Toast.makeText(valid_loggin.this, "Faltan llenar los campos", Toast.LENGTH_LONG).show();


        }








                }









        });









    }


    public boolean correosiguales(String pass1,String pass2) {
        if (pass1==pass2) {
            return true;
        } else {
            return false;
        }
    }


    public boolean validarnumero(String cadena) {
        if (cadena.matches("[0-9]*") && cadena.length()==10) {
            return true;
        } else {
            return false;
        }
    }



    public boolean validardni(String cadena) {
        if (cadena.matches("[0-9]*") && cadena.length()==10) {
            return true;
        } else {
            return false;
        }
    }



    public boolean correovalidar(String email) {

       if(email.matches("[-\\w\\.]+@\\w+\\.\\w+")){
           return true;
       }else {
           return false;
       }



}


    public boolean camposvacios(String campo) {

        if(campo.length()==0){
            return true;
        }else {
            return false;
        }



    }




}