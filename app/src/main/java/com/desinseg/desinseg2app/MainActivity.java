package com.desinseg.desinseg2app;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.desinseg.desinseg2app.usuario.ModeloUsuario;
import com.desinseg.desinseg2app.usuario.UsuarioInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtUsuario=(EditText) findViewById(R.id.editTextUsuario);
        EditText txtClave=(EditText) findViewById(R.id.editTextClave);
        Button btn=(Button) findViewById(R.id.ingresar);
        btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //VErifico internent
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isConnected()) {
                // Si hay conexión a Internet en este momento
            } else {
                // No hay conexión a Internet en este momento
                Toast toast= Toast.makeText(getApplicationContext(),"No hay conexion a internet",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return;
            }

            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("https://www.desinseg.com/WebServiceDesinseg/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            UsuarioInterface usuarioInterface=retrofit.create(UsuarioInterface.class);

            Call<List<ModeloUsuario>> call = usuarioInterface.ValidoUsuario(txtUsuario.getText().toString(),txtClave.getText().toString(),"jorge2009");
           call.enqueue(new Callback<List<ModeloUsuario>>() {
               @Override
               public void onResponse(Call<List<ModeloUsuario>> call, Response<List<ModeloUsuario>> response) {
                   int total=0;
                   total=response.body().size();
                   if(total>0){
                       Intent intent=new Intent(getApplicationContext(),Principal.class);
                       startActivity(intent);
                   }else{
                       txtUsuario.setText("");
                       txtClave.setText("");
                       txtUsuario.requestFocus();
                       Toast toast= Toast.makeText(getApplicationContext(),"Usuario no exsite",Toast.LENGTH_SHORT);
                       toast.setGravity(Gravity.CENTER,0,0);
                       toast.show();

                   }

               }

               @Override
               public void onFailure(Call<List<ModeloUsuario>> call, Throwable t) {
                   Toast.makeText(getApplicationContext(),"Error "+t.getMessage(),Toast.LENGTH_SHORT).show();
               }
           });










        }
    });


    }


}