package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import com.hughesnet.hughesnetapp.api.ApiInsertClient;
import com.hughesnet.hughesnetapp.api.ApiModifyClient;
import com.hughesnet.hughesnetapp.api.ApiProfile;
import com.hughesnet.hughesnetapp.model.Advisor;
import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit2.Call;

public class Modify_Client extends AppCompatActivity {
    private ApiAsesor apiInterface;
    private List<Asesor> asesores;
    public static final String  ROOT_URL="http://trainingcomercial.com/HughesNetApp/InsertClient";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_modify__client);
        chargeandfillText();
        Button btnf=findViewById(R.id.id_button_reclutar);
        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText n= findViewById(R.id.id_name_client);
                EditText a=findViewById(R.id.id_surname_client);
                EditText p=findViewById(R.id.id_phone_client);

                EditText ob=findViewById(R.id.id_observ_client);
                EditText ad=findViewById(R.id.id_lat);

                String address=ad.getText().toString();
                String observation=ob.getText().toString();

                String name=n.getText().toString().trim();
                String Ap=a.getText().toString();
                String ph=p.getText().toString();
                SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);

                String dni=preferences.getString("dni","def");



                if(name.length()>2&&a.length()>2&&ph.length()>=9&&address.length()>=3){

                    RestAdapter adapter=new RestAdapter.Builder()
                            .setEndpoint(ROOT_URL)
                            .build();


                    ApiModifyClient api=adapter.create(ApiModifyClient.class);
                    api.insertclient(
                            dni,
                            name,
                            Ap,
                            ph,
                            address,
                            observation,

                            new Callback<Response>() {
                                @Override
                                public void success(Response response, Response response2) {

                                    Toast.makeText(Modify_Client.this, "Cliente Modificado", Toast.LENGTH_SHORT).show();

                                    Intent intent=new Intent(view.getContext(),Referidos.class);
                                    startActivityForResult(intent,0);



                                }

                                @Override
                                public void failure(RetrofitError error) {

                                    Toast.makeText(Modify_Client.this, "Algo ocurrio, vuelva a intentarlo", Toast.LENGTH_SHORT).show();

                                }
                            }


                    );




                }else{

                    Toast.makeText(Modify_Client.this, "Hay incongruencia de datos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void chargeandfillText() {


        EditText n= findViewById(R.id.id_name_client);
        EditText a=findViewById(R.id.id_surname_client);
        EditText p=findViewById(R.id.id_phone_client);

        EditText ob=findViewById(R.id.id_observ_client);

       EditText txl=findViewById(R.id.id_lat);





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