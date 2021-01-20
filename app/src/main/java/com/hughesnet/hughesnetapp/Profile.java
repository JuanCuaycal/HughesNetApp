package com.hughesnet.hughesnetapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.hughesnet.hughesnetapp.adapter.RecyclerAdapterClient;
import com.hughesnet.hughesnetapp.api.ApiChangePicture;
import com.hughesnet.hughesnetapp.api.ApiClient;
import com.hughesnet.hughesnetapp.api.ApiProfile;
import com.hughesnet.hughesnetapp.api.ApiRegister;
import com.hughesnet.hughesnetapp.api.ApiUpdate;
import com.hughesnet.hughesnetapp.model.Advisor;
import com.hughesnet.hughesnetapp.model.Advisor;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit2.Call;

public class Profile extends AppCompatActivity {
    private ApiProfile apiInterface;
    private List<Advisor> Advisores;

    Bitmap bitmap;
    int PICK_IMAGE_REQUEST = 1;
    String UPLOAD_URL = "https://frutagolosa.com/FrutaGolosaApp/Upload.php";
    String KEY_IMAGE = "foto";
    String KEY_NOMBRE = "nombre";
    public static final String ROOT_URL="http://trainingcomercial.com/HughesNetApp/userdata";

    ImageView imagenprofile=findViewById(R.id.image_profile);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText n=findViewById(R.id.id_name_registro);
        EditText a=findViewById(R.id.id_surname_registro);
        EditText t=findViewById(R.id.id_phone_registro);
        EditText c=findViewById(R.id.id_email_registro);


        //Password
        Button psww=findViewById(R.id.btn_register_advisor2);

        Button send=findViewById(R.id.btn_register_advisor);


        chargeandfillText();



psww.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent f = new Intent(Profile.this, ChangePassword.class);
        startActivity(f);
        finish();

    }
});


imagenprofile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //showFileChooser();
        Toast.makeText(Profile.this,"AQUI",Toast.LENGTH_LONG);

    }
});





        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String telefono=t.getText().toString().trim().replace(" ","");
                String nombre=n.getText().toString().trim();
                String apellido=a.getText().toString().trim();
                String correo=c.getText().toString().replace(" ","");


                //   Toast.makeText(valid_loggin.this, pass1+" "+pass2, Toast.LENGTH_LONG).show();

                SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
                String dni=preferences.getString("dni","def");


                if(camposvacios(nombre.toString())==false && camposvacios(apellido.toString())==false && validarnumero(telefono.toString())==true && correovalidar(correo.toString())==true ){




                        RestAdapter adapter = new RestAdapter.Builder()
                                .setEndpoint(ROOT_URL)
                                .build();

                        ApiUpdate api = adapter.create(ApiUpdate.class);
                        api.insertadvisor(
                                nombre,
                                apellido,
                                telefono,
                                correo,
                                dni,

                                new Callback<retrofit.client.Response>() {
                                    @Override
                                    public void success(retrofit.client.Response result, Response response) {

                                        Toast.makeText(Profile.this,"Actualizando", Toast.LENGTH_SHORT).show();



                                        Intent f = new Intent(Profile.this, MainActivity.class);
                                        startActivity(f);
                                        finish();
                                    }



                                    @Override
                                    public void failure(RetrofitError error) {
                                        Toast.makeText(Profile.this, error.toString(), Toast.LENGTH_LONG).show();

                                    }
                                });



                }else{


                    Toast.makeText(Profile.this, "Datos Incompletos (Revise y vuelva a intentar)", Toast.LENGTH_LONG).show();


                }


            }





        });
    }

 /*   private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Seleciona imagen"), PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView ArregloL=(ImageView) findViewById(R.id.image_profile);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Cómo obtener el mapa de bits de la Galería
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                bitmap= Bitmap.createScaledBitmap(bitmap,440,520,true);
                //Configuración del mapa de bits en ImageView
                Glide.with(this).asBitmap().load(bitmap).into(ArregloL);
                uploadImage();
                insetaimagenarreglolisto();
              //  Button btnEntregCer=findViewById(R.id.btnEntregCerrar);
             //   btnEntregCer.setVisibility(View.VISIBLE);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void insetaimagenarreglolisto(){
        //final String IDPEDIDO=getIntent().getStringExtra(PedidosAsignados.IdPEDIDOA);
       // final String Fecha_qRecibe=getIntent().getStringExtra(PedidosAsignados.FechaQrecibeA);
        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        final String telefonous=preferences.getString("telefonous","No");

        String a="https://frutagolosa.com/FrutaGolosaApp/uploads/"+"11"+".png";
        String b="IDPEDIDO";

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();

        ApiChangePicture api = adapter.create(ApiChangePicture.class);

        api.inseruser(
                a,
                b,


                new Callback<Response>() {
                    @Override
                    public void success(retrofit.client.Response result, Response response) {

                        BufferedReader reader = null;

                        String output = "";

                        try {
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(Profile.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(Profile.this, error.toString(), Toast.LENGTH_LONG).show();

                    }
                }
        );





    }

    public void uploadImage() {
        final String Fecha_qRecibe="1111111";
        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        final String nombreus=preferences.getString("nombreus","Registrese");
        final String telefonous=preferences.getString("telefonous","No");

        final ProgressDialog loading = ProgressDialog.show(this, "Subiendo...", "Espere por favor");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        Toast.makeText(Profile.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String imagen = getStringImagen(bitmap);
                String nombre = Fecha_qRecibe.replace("/","a")+"xf2";

                Map<String, String> params = new Hashtable<String, String>();
                params.put(KEY_IMAGE, imagen);
                params.put(KEY_NOMBRE, nombre);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }*/



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




    private void chargeandfillText() {

        EditText n=findViewById(R.id.id_name_registro);
        EditText a=findViewById(R.id.id_surname_registro);
        EditText t=findViewById(R.id.id_phone_registro);
        EditText c=findViewById(R.id.id_email_registro);
        Button im=findViewById(R.id.id_button_image);
        ImageView imageView = (ImageView) findViewById(R.id.image_profile);

        SharedPreferences preferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String dni=preferences.getString("dni","def");
        apiInterface = ApiClient.getApiClient().create(ApiProfile.class);

        Call<List<Advisor>>call = apiInterface.getAdvisor("http://www.trainingcomercial.com/HughesNetApp/userdata/profile.php?dni="+dni);
        call.enqueue(new retrofit2.Callback<List<Advisor>>() {

            public void onResponse(Call<List<Advisor>> call, retrofit2.Response<List<Advisor>> response) {

                Toast.makeText(Profile.this, "Cargando Datos", Toast.LENGTH_SHORT).show();



                    if (response.body() != null) {
                        Advisores=response.body();
                    n.setText(Advisores.get(0).getName());
                    a.setText(Advisores.get(0).getSurname());
                    t.setText(Advisores.get(0).getPhone());
                    c.setText(Advisores.get(0).getEmail());


                      Glide.with(imageView)
                                .load(Advisores.get(0).getImagen().trim())
                                .into(imageView);



                    }
                    else{

                        Toast.makeText(Profile.this, "No hay datos", Toast.LENGTH_SHORT).show();
                    }


            }

            @Override
            public void onFailure(Call<List<Advisor>> call, Throwable t) {
                Log.e("Respuesta",t.toString());
            }


        });



    }

/*    public void uploadImage(String action) {
        Toast.makeText(this, "subiendo", Toast.LENGTH_SHORT).show();

        final SharedPreferences preferences=this.getSharedPreferences("bg-lgof", Context.MODE_PRIVATE);
        final String jwt=preferences.getString("jwt","0null0");
        ApiChangePicture apiInterface = ApiClient.getApiClient().create(ApiChangePicture.class);
        String imagen=getStringImagen(cbitmap);
        Call<ModelSucces> call = apiInterface.Uploadphoto(getString(R.string.profileurl),jwt,actionxp,imagen);
        call.enqueue(new retrofit2.Callback<ModelSucces>() {
            @Override
            public void onResponse(Call<ModelSucces> call, retrofit2.Response<ModelSucces> response) {


                if(response.body().getStatus().equals("successs")){


                    Toast.makeText(getApplicationContext(), "Uploades Cover", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(getApplicationContext(), "No upload cover", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ModelSucces> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Se ha producido un error", Toast.LENGTH_SHORT).show();
                Log.e("error",t.toString());

            }




        });

    }*/




/*
    public String getStringImagen(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

*/








}