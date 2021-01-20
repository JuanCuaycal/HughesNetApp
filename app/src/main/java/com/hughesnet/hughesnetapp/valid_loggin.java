package com.hughesnet.hughesnetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hughesnet.hughesnetapp.api.ApiRegister;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class valid_loggin extends AppCompatActivity {
    public static final String ROOT_URL="http://trainingcomercial.com/HughesNetApp/userlogin";
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valid_loggin);
        auth = FirebaseAuth.getInstance();
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

                String password=c1.getText().toString().trim();
                String password2=c2.getText().toString().trim();
                String type="0";
             //   Toast.makeText(valid_loggin.this, pass1+" "+pass2, Toast.LENGTH_LONG).show();




        if(camposvacios(password.toString())==false && camposvacios(password2.toString())==false && camposvacios(nombre.toString())==false && camposvacios(apellido.toString())==false && validarnumero(telefono.toString())==true && correovalidar(correo.toString())==true && validardni(dni.toString())==true){

            if(contrasena_iguales(password,password2)==true){


                Toast.makeText(valid_loggin.this, "Registro en Proceso ", Toast.LENGTH_SHORT).show();



                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(ROOT_URL)
                        .build();

                ApiRegister api = adapter.create(ApiRegister.class);
                api.insertadvisor(
                        nombre,
                        apellido,
                        dni,
                        telefono,
                        correo,
                        password,
                        type,
                        new Callback<retrofit.client.Response>() {
                            @Override
                            public void success(retrofit.client.Response result, Response response) {

                                Toast.makeText(valid_loggin.this,"Registrado", Toast.LENGTH_SHORT).show();
                                //Descomenta este codigo para enviar el correo de verificacion
                                EnviarCorreo();


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

                Toast.makeText(valid_loggin.this, password +"   "+ password2, Toast.LENGTH_LONG).show();
                c1.setText("");
                c2.setText("");
            }


        }else{


            Toast.makeText(valid_loggin.this, "Datos Incompletos (Revise y vuelva a intentar)", Toast.LENGTH_LONG).show();


        }


            }





        });



    }


    public boolean contrasena_iguales(String pass2,String pass1) {

        String pas1=pass1.trim();
        String pas2=pass2.trim();
        if (!pas1.equals(pas2)){
            return false;
        } else {
            return true;
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

    private void EnviarCorreo() {

        EditText c = findViewById(R.id.id_email_registro);
        EditText c1 = findViewById(R.id.id_contrasena_register);
        String co = c.getText().toString().trim();
        String p = c1.getText().toString().trim();


        auth.createUserWithEmailAndPassword(co, p)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();
                            user.sendEmailVerification();


                                Toast.makeText(valid_loggin.this, "Ya se envio un correo a su direccion mail.", Toast.LENGTH_SHORT).show();




                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(valid_loggin.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }

                        // ...
                    }
                });


/*        auth.createUserWithEmailAndPassword(co,p).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){

                    Log.e("mal",task.toString());
                    Log.e("mal",task.getResult().toString());


                    Toast.makeText(valid_loggin.this, "Mal", Toast.LENGTH_SHORT).show();
                }else{
                    try {



                        FirebaseUser user = auth.getCurrentUser();
                        user.sendEmailVerification();

                        Toast.makeText(valid_loggin.this, "Ya se envio un correo a su direccion mail.", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){

                        Toast.makeText(valid_loggin.this, "Ya se envio un correo a su direccion mail.", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });


    }*/


    }

}