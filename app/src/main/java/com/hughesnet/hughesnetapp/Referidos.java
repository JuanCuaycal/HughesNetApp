package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.api.ApiClient;
import com.hughesnet.hughesnetapp.api.ApiReferidosCount;
import com.hughesnet.hughesnetapp.model.DatosX;
import com.hughesnet.hughesnetapp.model.ReferidosCount;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class Referidos extends AppCompatActivity {

    private ApiReferidosCount apiInterfaceRef;
    private List<ReferidosCount> datos2;
    public  static String Estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referidos);

        Button btn_agregar = findViewById(R.id.btn_agregar_ref);
        Button btn_grafica = findViewById(R.id.btn_grafica2);

        Button btntotal = (Button) findViewById(R.id.btn_total);
        Button btncontactado = (Button) findViewById(R.id.btn_contactado);
        Button btnpropuesto=(Button) findViewById(R.id.btn_propuesto);
        Button btnconfirm = (Button) findViewById(R.id.btn_confirm);
        Button btnvendido = (Button) findViewById(R.id.btn_vendidos);
        Button btninstall = (Button) findViewById(R.id.btn_instalado);
        Button btnnodesean = (Button) findViewById(R.id.btn_no_desean);

        chargeResult();



        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Reclutado.class);
                startActivityForResult(intent, 0);
            }
        });


        btntotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Total");
                startActivityForResult(intent,0);
            }
        });


        btncontactado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Contactado");
                startActivityForResult(intent,0);
            }
        });

        btnpropuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Propuesto");
                startActivityForResult(intent,0);
            }
        });

        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Por Confirmar");
                startActivityForResult(intent,0);
            }
        });

        btnvendido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Vendido");
                startActivityForResult(intent,0);
            }
        });

        btninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"Instalado");
                startActivityForResult(intent,0);

            }
        });

        btnnodesean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),StatusReferidosActivity.class);
                intent.putExtra(Estado,"No desean");
                startActivityForResult(intent,0);
            }
        });




    }


    private void chargeResult(){

        TextView ref_total=(TextView) findViewById(R.id.id_button_total);
        TextView ref_cont=(TextView) findViewById(R.id.id_button_contact);

        TextView ref_prop=(TextView) findViewById(R.id.id_button_presup);
        TextView ref_conf=(TextView) findViewById(R.id.id_button_confir);
        TextView ref_vend=(TextView) findViewById(R.id.id_button_vend);
        TextView ref_install=(TextView) findViewById(R.id.id_button_install);
        TextView ref_no=(TextView) findViewById(R.id.id_button_no);




        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String dni=preferences.getString("dni","def");
        apiInterfaceRef = ApiClient.getApiClient().create(ApiReferidosCount.class);
        Call<List<ReferidosCount>> call=apiInterfaceRef.getResultCount("http://trainingcomercial.com/HughesNetApp/userdata/resultref.php?dni="+dni) ;
        call.enqueue(new retrofit2.Callback<List<ReferidosCount>>() {

            @Override
            public void onResponse(Call<List<ReferidosCount>> call, Response<List<ReferidosCount>> response) {


                Toast.makeText(Referidos.this, "Cargando Datos", Toast.LENGTH_SHORT).show();



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

                    Toast.makeText(Referidos.this, "No hay Datos", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<ReferidosCount>> call, Throwable t) {
                Toast.makeText(Referidos.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }





        });

    }





    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){


        }





    }
}