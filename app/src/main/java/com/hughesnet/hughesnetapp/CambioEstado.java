package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.api.ApiLogin;
import com.hughesnet.hughesnetapp.api.ApiUpdateStatus;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CambioEstado extends AppCompatActivity {

    public static final String ROOT_URL="http://trainingcomercial.com/HughesNetApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_estado);

        RadioGroup grcl=findViewById(R.id.id_radio_group_client_status);
        final String telefono = getIntent().getStringExtra(StatusReferidosActivity.Estados);


        Button btn_cambio= findViewById(R.id.id_cambio_status);


        btn_cambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Get element select
                int i = grcl.getCheckedRadioButtonId();
                RadioButton seleccionado = (RadioButton) findViewById(i);
                String status=seleccionado.getText().toString();

                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(ROOT_URL)
                        .build();

                ApiUpdateStatus api= adapter.create(ApiUpdateStatus.class);

                api.updateClient(
                        telefono, status,
                        new Callback<Response>() {
                            @Override
                            public void success(Response response, Response response2) {

                                Toast.makeText(getApplicationContext(),"Estado Cambiado con Exito a "+ status,Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(v.getContext(),Referidos.class);
                                CambioEstado.this.setResult(RESULT_OK,intent);
                                startActivityForResult(intent,0);

                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

                            }
                        }


                );



            }
        });









    }


}