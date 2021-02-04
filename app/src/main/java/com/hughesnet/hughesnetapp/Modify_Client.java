package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hughesnet.hughesnetapp.api.ApiAsesor;
import com.hughesnet.hughesnetapp.api.ApiClient;
import com.hughesnet.hughesnetapp.api.ApiProfile;
import com.hughesnet.hughesnetapp.model.Advisor;
import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;

import retrofit2.Call;

public class Modify_Client extends AppCompatActivity {
    private ApiAsesor apiInterface;
    private List<Asesor> asesores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_modify__client);
        chargeandfillText();
    }

    private void chargeandfillText() {


        EditText n= findViewById(R.id.id_name_client);
        EditText a=findViewById(R.id.id_surname_client);
        EditText p=findViewById(R.id.id_phone_client);
        Spinner pr=findViewById(R.id.id_spinner_province_client);
        EditText ob=findViewById(R.id.id_observ_client);

       EditText txl=findViewById(R.id.id_lat);
        RadioGroup grcl=findViewById(R.id.id_radio_group_client);
        Spinner tipes=findViewById(R.id.spinner);





        final String telefono = getIntent().getStringExtra(CambioEstado.Phone);
        apiInterface = ApiClient.getApiClient().create(ApiAsesor.class);

        Call<List<Asesor>> call = apiInterface.getAsesores("http://trainingcomercial.com/HughesNetApp/ListaOneClien.php?&phone="+telefono);
        call.enqueue(new retrofit2.Callback<List<Asesor>>() {

            public void onResponse(Call<List<Asesor>> call, retrofit2.Response<List<Asesor>> response) {

                Toast.makeText(Modify_Client.this, "Cargando Datos", Toast.LENGTH_SHORT).show();



                if (response.body() != null) {
                   asesores=response.body();
                    n.setText(asesores.get(0).getName());
                    a.setText(asesores.get(0).getSurname());
                    p.setText(asesores.get(0).getPhone());
                    txl.setText((asesores.get(0).getAddress()));
                    ob.setText(asesores.get(0).getObservation());







                }
                else{

                    Toast.makeText(Modify_Client.this, "No hay datos", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<List<Asesor>> call, Throwable t) {
                Log.e("Respuesta",t.toString());
            }


        });



    }

}