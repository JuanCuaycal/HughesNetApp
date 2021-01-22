package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.api.ApiClient;
import com.hughesnet.hughesnetapp.api.ApiDatos;
import com.hughesnet.hughesnetapp.api.ApiReferidosCount;
import com.hughesnet.hughesnetapp.model.DatosX;
import com.hughesnet.hughesnetapp.model.ReferidosCount;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class Datos extends AppCompatActivity {
    private ApiDatos apiInterface;
    private ApiReferidosCount apiInterfaceRef;
    private List<DatosX> datos;
    private List<ReferidosCount> datos2;
    public static final String ROOT_URL="http://trainingcomercial.com/HughesNetApp/userdata";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        chargeData();
        chargeResult();
    }

    private void chargeData() {

        TextView act=(TextView) findViewById(R.id.id_porcent_act);
        TextView apt=(TextView) findViewById(R.id.id_porcent_aptit);





        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String dni=preferences.getString("dni","def");
        apiInterface = ApiClient.getApiClient().create(ApiDatos.class);

        Call<List<DatosX>> call = apiInterface.getAdvisor("http://trainingcomercial.com/HughesNetApp/userdata/datos.php?dni="+dni);
        call.enqueue(new retrofit2.Callback<List<DatosX>>() {

            public void onResponse(Call<List<DatosX>> call, retrofit2.Response<List<DatosX>> response) {

               // Toast.makeText(Datos.this, "Cargando Datos", Toast.LENGTH_SHORT).show();



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


    private void chargeResult(){
        TextView ref_total=(TextView) findViewById(R.id.id_total_ref);
        TextView ref_cont=(TextView) findViewById(R.id.id_ref_contact);
        TextView ref_prop=(TextView) findViewById(R.id.id_ref_propues);
        TextView ref_conf=(TextView) findViewById(R.id.id_ref_confirmar);
        TextView ref_vend=(TextView) findViewById(R.id.id_ref_vendido);
        TextView ref_install=(TextView) findViewById(R.id.id_ref_install);
        TextView ref_no=(TextView) findViewById(R.id.id_ref_no_desea);



        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String dni=preferences.getString("dni","def");
        apiInterfaceRef = ApiClient.getApiClient().create(ApiReferidosCount.class);
        Call<List<ReferidosCount>> call=apiInterfaceRef.getResultCount("http://trainingcomercial.com/HughesNetApp/userdata/resultref.php?dni="+dni) ;
        call.enqueue(new retrofit2.Callback<List<ReferidosCount>>() {

            @Override
            public void onResponse(Call<List<ReferidosCount>> call, Response<List<ReferidosCount>> response) {


                Toast.makeText(Datos.this, "Cargando Datos", Toast.LENGTH_SHORT).show();



                if (response.body() != null) {
                    datos2=response.body();
                    ref_total.setText(datos2.get(0).getTotal());
                    ref_cont.setText(datos2.get(0).getContactados());
                    ref_prop.setText(datos2.get(0).getPropuestos());
                    ref_conf.setText(datos2.get(0).getConfirmados());
                    ref_vend.setText(datos2.get(0).getVendidos());
                    ref_install.setText(datos2.get(0).getInstalados());
                    ref_no.setText(datos2.get(0).getNo());




                }
                else{

                    Toast.makeText(Datos.this, "No hay Datos", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<ReferidosCount>> call, Throwable t) {
                Toast.makeText(Datos.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }





        });

    }


}