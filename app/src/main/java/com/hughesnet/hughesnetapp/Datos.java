package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.api.ApiClient;
import com.hughesnet.hughesnetapp.api.ApiDatos;
import com.hughesnet.hughesnetapp.api.ApiProfile;
import com.hughesnet.hughesnetapp.model.Advisor;
import com.hughesnet.hughesnetapp.model.DatosX;

import java.util.List;

import retrofit2.Call;

public class Datos extends AppCompatActivity {
    private ApiDatos apiInterface;
    private List<DatosX> datos;
    public static final String ROOT_URL="http://trainingcomercial.com/HughesNetApp/userdata";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        chargeData();
    }

    private void chargeData() {

        TextView act=(TextView) findViewById(R.id.textView14);
        TextView apt=(TextView) findViewById(R.id.textView25);


        TextView ref_cont=(TextView) findViewById(R.id.id_ref_contact);
        TextView ref_prop=(TextView) findViewById(R.id.id_ref_propues);
        TextView ref_conf=(TextView) findViewById(R.id.id_ref_confirmar);
        TextView ref_vend=(TextView) findViewById(R.id.id_ref_vendido);
        TextView ref_install=(TextView) findViewById(R.id.id_ref_install);
        TextView ref_no=(TextView) findViewById(R.id.id_ref_no_desea);


        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String dni=preferences.getString("dni","def");
        apiInterface = ApiClient.getApiClient().create(ApiDatos.class);

        Call<List<DatosX>> call = apiInterface.getAdvisor("http://trainingcomercial.com/HughesNetApp/userdata/datos.php?dni="+dni);
        call.enqueue(new retrofit2.Callback<List<DatosX>>() {

            public void onResponse(Call<List<DatosX>> call, retrofit2.Response<List<DatosX>> response) {

                Toast.makeText(Datos.this, "Cargando Datos", Toast.LENGTH_SHORT).show();



                if (response.body() != null) {
                  datos=response.body();
                    act.setText(datos.get(0).getActitud());
                    apt.setText(datos.get(0).getAptitud());
            
             


                }
                else{

                    Toast.makeText(Datos.this, "No hay Datos", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<List<DatosX>> call, Throwable t) {
                Log.e("Respuesta",t.toString());
            }


        });



    }
}