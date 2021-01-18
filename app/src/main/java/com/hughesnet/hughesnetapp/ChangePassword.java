package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.api.ApiProfile;
import com.hughesnet.hughesnetapp.api.ApiUpdate;
import com.hughesnet.hughesnetapp.api.ApiUpdatePass;
import com.hughesnet.hughesnetapp.model.Advisor;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ChangePassword extends AppCompatActivity {
    private ApiProfile apiInterface;

    public static final String ROOT_URL="http://trainingcomercial.com/HughesNetApp/userdata";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Button btnval= (Button) findViewById(R.id.btn_register_advisor3);

        EditText p=findViewById(R.id.editTextTextPassword);
        EditText p1=findViewById(R.id.editTextTextPassword2);
        EditText p2=findViewById(R.id.editTextTextPassword3);


        btnval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
                String dni=preferences.getString("dni","def");
                String contrasena=p.getText().toString();
                String ncontrasena=p1.getText().toString();
                String ncontrasena2=p2.getText().toString();


                if(contrasena_iguales(ncontrasena,ncontrasena2)) {
                    RestAdapter adapter = new RestAdapter.Builder()
                            .setEndpoint(ROOT_URL)
                            .build();

                    ApiUpdatePass api = adapter.create(ApiUpdatePass.class);
                    api.insertadvisor(
                            contrasena,
                            ncontrasena,
                            dni,

                            new Callback<Response>() {
                                @Override
                                public void success(retrofit.client.Response result, Response response) {

                                    Toast.makeText(ChangePassword.this, "Actualizando", Toast.LENGTH_SHORT).show();


                                    Intent f = new Intent(ChangePassword.this, MainActivity.class);
                                    startActivity(f);
                                    finish();
                                }


                                @Override
                                public void failure(RetrofitError error) {
                                    Toast.makeText(ChangePassword.this, error.toString(), Toast.LENGTH_LONG).show();

                                }
                            });
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
}