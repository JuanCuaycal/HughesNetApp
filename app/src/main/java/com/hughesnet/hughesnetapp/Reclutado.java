package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hughesnet.hughesnetapp.api.ApiInsertClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Reclutado extends AppCompatActivity {
    public static final String ROOT_URL="http://trainingcomercial.com/HughesNetApp/InsertClient";
    TextView mensaje1;
    TextView mensaje2;
    TextView mensaje3;
    public ArrayList<String> lista_ubicacion;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner spinner1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclutado);

        EditText n= findViewById(R.id.id_name_client);
        EditText a=findViewById(R.id.id_surname_client);
        EditText p=findViewById(R.id.id_phone_client);
        Spinner pr=findViewById(R.id.id_spinner_province_client);
        EditText ob=findViewById(R.id.id_observ_client);
        RadioGroup grcl=findViewById(R.id.id_radio_group_client);
        Spinner tipes=findViewById(R.id.spinner);


        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String passs=preferences.getString("pass","def");
        String correos=preferences.getString("mailus","def");
        String types=preferences.getString("type","def");
        String dni=preferences.getString("dni","def");


         mensaje1 =  findViewById(R.id.id_long);
         mensaje2 =  findViewById(R.id.id_lat);
         mensaje3= findViewById(R.id.id_json);

         Button button_cliente=findViewById(R.id.id_button_reclutar);


        spinner1=findViewById(R.id.id_spinner_province_client);
        String[] ciudades={"Pichincha","Guayas","Esmeraldas","Manabi","Los Rios","Santa Elena","Santo Domingo","El Oro","Azuay","Bolivar","Cañar","Carchi"
                ,"Cotopaxi","Chimborazo","Imbabura","Loja","Tungurahua","Morona Santiago","Napo","Orellana","Pastaza","Sucumbios","Zamora Chichipe"

        };

        ArrayAdapter <String> adapter1= new ArrayAdapter<String>(this, R.layout.spinner_item_forma, ciudades);
        spinner1.setAdapter(adapter1);


        String[] tipos={"Campo","Telefonico"

        };

        ArrayAdapter <String> adapter2= new ArrayAdapter<String>(this, R.layout.spinner_item_forma, tipos);
        tipes.setAdapter(adapter2);


        locationStart();

        button_cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=n.getText().toString().trim().replace( " ","");
                String surname=a.getText().toString().trim().replace( " ","");
                String phone=p.getText().toString().trim().replace( " ","");
                String province=pr.getSelectedItem().toString();
                String address=mensaje2.getText().toString();
                String observation=ob.getText().toString().trim().replace( " ","");
                String id_advisor =dni;
                String cord=mensaje3.getText().toString();
                String ti=tipes.getSelectedItem().toString();

                   //Select seleccionar un elemento del grupo

                //Get element select
                int i = grcl.getCheckedRadioButtonId();


                RadioButton seleccionado = (RadioButton) findViewById(i);
                String status=seleccionado.getText().toString();

               // Toast.makeText(Reclutado.this, name+" "+surname+" "+phone+" "+province+" "+address+" "+ observation+" "+status, Toast.LENGTH_LONG).show();

              //  mensaje2.setText(name+" "+surname+" "+phone+" "+province+" "+ observation+" "+status);

                //Delete selection
               // grcl.clearCheck();

                   if(name.length()>2&&surname.length()>2&&phone.length()>=9&&address.length()>3){

                RestAdapter adapter=new RestAdapter.Builder()
                        .setEndpoint(ROOT_URL)
                        .build();


                ApiInsertClient api=adapter.create(ApiInsertClient.class);
                api.insertclient(
                        id_advisor,
                        name,
                        surname,
                        phone,
                        province,
                        address,
                        observation,
                        status,
                        cord,
                        ti,
                        new Callback<Response>() {
                            @Override
                            public void success(Response response, Response response2) {

                                Toast.makeText(Reclutado.this, "Cliente Agregado", Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(v.getContext(),Referidos.class);
                                startActivityForResult(intent,0);



                            }

                            @Override
                            public void failure(RetrofitError error) {

                                Toast.makeText(Reclutado.this, "Algo ocurrio, vuelva a intentarlo", Toast.LENGTH_SHORT).show();

                            }
                        }


                );




                   }else{

                       Toast.makeText(Reclutado.this, "Hay incongruencia de datos", Toast.LENGTH_SHORT).show();
                   }



            }
        });


    }




    private void locationStart() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Localizacion Local = new Localizacion();
        Local.setMainActivity(this);
        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }
        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) Local);
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) Local);
        mensaje1.setText("Cargando Localizacion");
        mensaje2.setText("");
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationStart();
                return;
            }
        }
    }
    public void setLocation(Location loc) {
        //Obtener la direccion de la calle a partir de la latitud y la longitud
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                    mensaje2.setText(DirCalle.getAddressLine(0));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /* Aqui empieza la Clase Localizacion */
    public class Localizacion implements LocationListener {
        Reclutado mainActivity;
        final JSONObject object = new JSONObject();




        public Reclutado getMainActivity() {
            return mainActivity;
        }
        public void setMainActivity(Reclutado mainActivity) {
            this.mainActivity = mainActivity;
        }
        @Override
        public void onLocationChanged(Location loc) {
            // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la deteccion de un cambio de ubicacion
            loc.getLatitude();
            loc.getLongitude();
            String Text = loc.getLatitude() + "," + loc.getLongitude();
           // mensaje1.setText(Text);


            SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //lista_ubicacion.add((String) mensaje1.getText());
            //editor.putString("jsonListaTareas", jsonListaTareas );
            //editor.apply();
            try {
                JSONObject salida_json = object.put("Coordenadas actuales", Text);
                mensaje3.setText(Text);

               // lista_ubicacion.add(salida_json.toString());
               // editor.putString("ub", salida_json.toString() );
               // editor.commit();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            this.mainActivity.setLocation(loc);


        }
        @Override
        public void onProviderDisabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es desactivado
            mensaje1.setText("GPS Desactivado");
        }
        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado
            mensaje1.setText("GPS Activado");
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.d("debug", "LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }




    }





}