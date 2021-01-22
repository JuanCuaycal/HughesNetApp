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

//import com.firebase.ui.auth.AuthUI;
//import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hughesnet.hughesnetapp.api.ApiLogin;
import com.hughesnet.hughesnetapp.api.ApiRegister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity  {
    public static final String ROOT_URL="http://trainingcomercial.com/HughesNetApp/userlogin";

    public static final int REQUEST_CODE=544543;
    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener mAuthListener;

 /*   List<AuthUI.IdpConfig> provider= Arrays.asList(
            new AuthUI.IdpConfig.GoogleBuilder().build()
    );*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        auth = FirebaseAuth.getInstance ();


        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String passs=preferences.getString("pass","def");
        String correos=preferences.getString("mailus","def");
        String types=preferences.getString("type","def");
        String dni=preferences.getString("dni","def");


        if(correos!="def"){

            Intent intent=new Intent(this,Modulos.class);
            startActivityForResult(intent,0);
            finish();

        }else{

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
                    String password=p.getText().toString().trim().replace(" ","").toLowerCase();;


//Descomentar para que solo ingrese con cuentas de correo
                 //   if(correo.length()!=0 && password.length()!=0 && correovalidar(correo)){
                    if(correo.length()!=0 && password.length()!=0 ){
                        loggeobase(correo,password,view);

                        loggeofirebase(correo,password,view);




                    }else{


                        Toast.makeText(MainActivity.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
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

                    //auth.addAuthStateListener(mAuthListener);
                    //EnviarCorreo();
                   // Intent intent=new Intent(view.getContext(),Formulario.class);
                   // startActivityForResult(intent,0);
                     Toast.makeText(MainActivity.this, "Estamos trabajando en esta función", Toast.LENGTH_LONG).show();
                }
            });



        }







    }




    private void loggeobase(String correo,String password,View view){

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();

        ApiLogin api = adapter.create(ApiLogin.class);

        api.loggear(
                correo,
                password,
                new Callback<Response>() {
                    @Override
                    public void success(retrofit.client.Response result, Response response2) {


                        BufferedReader reader = null;

                        //String output = "";

                        try {
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                            String output = reader.readLine();
                            // Toast.makeText(MainActivity.this, output, Toast.LENGTH_LONG).show();


                            String a =output.substring(0,1);
                            String b=output.substring(1,output.length());

                            if (a.equals("0")  || a.equals("1") ){
                                savepreferences(a,b);
                                Intent intent=new Intent(view.getContext(),Modulos.class);
                                startActivityForResult(intent,0);
                                finish();


                            }else{

                                Toast.makeText(MainActivity.this, "No está registrado", Toast.LENGTH_LONG).show();

                            }




                        } catch (IOException e) {
                            e.printStackTrace();
                        }




                    }

                    @Override
                    public void failure(RetrofitError error) {

                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }

        );




    }



    private void loggeofirebase(String correo,String password,View view){

       // Toast.makeText(MainActivity.this, "Firebase Check", Toast.LENGTH_LONG).show();
        //Descomenta este codigo y colocacar dentro del if el login de la app

        auth.signInWithEmailAndPassword(correo, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Logica luego de loguearse
                            Toast.makeText(MainActivity.this, "Bienvenido",Toast.LENGTH_SHORT).show();

          /*                  savepreferences(correo,password);
                            Intent intent=new Intent(view.getContext(),Modulos.class);
                            startActivityForResult(intent,0);
                            finish();
*/

                        } else {

                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "No se encuentra registrado.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });






    }

    private void savepreferences(String a,String b) {

        EditText c=findViewById(R.id.id_login_correo);
        EditText p=findViewById(R.id.id_login_pass);

        SharedPreferences preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        String pass = p.getText().toString();
        String mail = c.getText().toString().trim().replace(" ", "").toLowerCase();




        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("pass", pass);
        editor.putString("mailus", mail);
        editor.putString("type",a);
        editor.putString("dni",b);
        editor.commit();


    }

    public boolean correovalidar(String email) {

        if(email.matches("[-\\w\\.]+@\\w+\\.\\w+")){
            return true;
        }else {
            return false;
        }

    }


/*

    public void updateUI(String email,String pass){

        String correo=email.toString().trim().replace(" ","");;
        String password=email.toString().trim().replace(" ","").toLowerCase();

        if(!correo.isEmpty() && !password.isEmpty()){

        }



    }
*/



/*    private void EnviarCorreo(){

        EditText c=findViewById(R.id.id_email_registro);
        EditText c1=findViewById(R.id.id_contrasena_register);
        String co=c.getText().toString();
        String p=c1.getText().toString();


        auth.createUserWithEmailAndPassword(co,p).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){


                    Toast.makeText(MainActivity.this, "No se envio su correo", Toast.LENGTH_SHORT).show();
                }else{
                    try {



                        FirebaseUser user = auth.getCurrentUser();
                        user.sendEmailVerification();

                        Toast.makeText(MainActivity.this, "Ya se envio un correo a su direccion mail.", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){

                        Toast.makeText(MainActivity.this, "Ya se envio un correo a su direccion mail.", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });


    }*/


}