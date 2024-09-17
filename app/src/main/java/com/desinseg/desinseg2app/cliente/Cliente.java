package com.desinseg.desinseg2app.cliente;

import static java.lang.System.in;

import android.annotation.SuppressLint;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.desinseg.desinseg2app.MainActivity;
import com.desinseg.desinseg2app.R;
import com.desinseg.desinseg2app.ciudad.Ciudad;
import com.desinseg.desinseg2app.ciudad.CiudadInterface;
import com.desinseg.desinseg2app.ciudad.ModeloCiudad;
import com.desinseg.desinseg2app.empresa.ModeloEmpresa;
import com.desinseg.desinseg2app.usuario.UsuarioInterface;
import com.google.android.material.navigation.NavigationBarView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cliente extends AppCompatActivity {
    private  SpinnerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cliente);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtNombre=findViewById(R.id.nombre);
        EditText txtApellido=findViewById(R.id.apellido);
        EditText txtDireccion=findViewById(R.id.direccion);
        EditText txtDocumento=findViewById(R.id.cedula);
        EditText txtTelefono=findViewById(R.id.telefono);
        EditText txtApellido2=findViewById(R.id.apellido2);
        EditText txtCorreo=findViewById(R.id.correo);

        EditText txtEmpresa=findViewById(R.id.empresa);
        Button btnGuardarCliente=findViewById(R.id.guardar);
        TextView txtv=findViewById(R.id.textView);


        CargoCiudad();








        btnGuardarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Desinseg", "click");

                //valido datos cliente
               if(TextUtils.isEmpty(txtNombre.getText())){
                   //Toast toast= Toast.makeText(getApplicationContext(),"Ingrese un nombre ",Toast.LENGTH_SHORT);
                   //toast.setGravity(Gravity.CENTER,0,0);
                   //toast.show();
                   txtNombre.setError("Este campo no puede ser vacio...");
                   return;
               }
                if(TextUtils.isEmpty(txtApellido.getText())){
                    txtApellido.setError("Este campo no puede ser vacio...");
                    return;
                }
                if(TextUtils.isEmpty(txtApellido2.getText())){
                    txtApellido2.setError("Este campo no puede ser vacio...");
                    return;
                }
                if(TextUtils.isEmpty(txtDireccion.getText())){
                    txtDireccion.setError("Este campo no puede ser vacio...");
                    return;
                }
                if(TextUtils.isEmpty(txtCorreo.getText())){
                    txtCorreo.setError("Este campo no puede ser vacio...");
                    return;
                }
                if(TextUtils.isEmpty(txtTelefono.getText())){
                    txtTelefono.setError("Este campo no puede ser vacio...");
                    return;
                }
                if(TextUtils.isEmpty(txtDocumento.getText())){
                    txtDocumento.setError("Este campo no puede ser vacio...");
                    return;
                }




                   Gson gson=new GsonBuilder()
                           .setLenient()
                           .create();

                    Retrofit retrofit=new Retrofit.Builder()
                            .baseUrl("https://www.desinseg.com/WebServiceDesinseg/")
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();






               ClienteInterface clienteInterface=retrofit.create(ClienteInterface.class);
               Call<List<ModeloCliente>> call=clienteInterface.GuardoCliente(txtNombre.getText().toString(),txtApellido.getText().toString(),
                       txtApellido2.getText().toString(),txtDireccion.getText().toString(),1,txtCorreo.getText().toString(),
                       1,txtDocumento.getText().toString(),1,1,1,1,"jorge2009");
               call.enqueue(new Callback<List<ModeloCliente>>() {
                   @Override
                   public void onResponse(Call<List<ModeloCliente>> call, Response<List<ModeloCliente>> response) {
                       List<ModeloCliente> modeloClientes=response.body();
                       int codigo=0;
                       for (ModeloCliente mod : modeloClientes){
                           codigo=mod.getCod_cliente();
                       }
                       if(codigo==2){
                           //spinnerCiudad.
                           txtCorreo.setText("");
                           txtApellido2.setText("");
                           txtApellido.setText("");
                           txtNombre.setText("");
                           txtDireccion.setText("");
                           txtDocumento.setText("");
                           txtEmpresa.setText("");
                           txtTelefono.setText("");
                           txtNombre.requestFocus();
                           Toast toast= Toast.makeText(getApplicationContext(),"Cliente ya existe... ",Toast.LENGTH_SHORT);
                           toast.setGravity(Gravity.CENTER,0,0);
                           toast.show();
                       }
                       if(codigo==1){
                          //spinnerCiudad.setText("");
                           txtCorreo.setText("");
                           txtApellido2.setText("");
                           txtApellido.setText("");
                           txtNombre.setText("");
                           txtDireccion.setText("");
                           txtDocumento.setText("");
                           txtEmpresa.setText("");
                           txtTelefono.setText("");
                           txtNombre.requestFocus();
                           Toast toast= Toast.makeText(getApplicationContext(),"Cliente ingresado correctamente... ",Toast.LENGTH_SHORT);
                           toast.setGravity(Gravity.CENTER,0,0);
                           toast.show();
                       }
                       if(codigo==0){
                           Toast toast= Toast.makeText(getApplicationContext(),"Problemas al ingresar Cliente... ",Toast.LENGTH_SHORT);
                           toast.setGravity(Gravity.CENTER,0,0);
                           toast.show();
                       }
                       Log.d("Desinseg", "onResponse: "+codigo);
                   }

                   @Override
                   public void onFailure(Call<List<ModeloCliente>> call, Throwable t) {
                       Log.d("Desinseg", "onFailure: "+t.getMessage());
                   }
               });

            }







                    });











    }

public void CargoCiudad(){
    ArrayList<ModeloCiudad> listaCiudad2=new ArrayList<>();
    Gson gson=new GsonBuilder()
            .setLenient()
            .create();

    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://www.desinseg.com/WebServiceDesinseg/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    CiudadInterface ciudadInterface=retrofit.create(CiudadInterface.class);
    Call<List<ModeloCiudad>> call=ciudadInterface.ListarCiudad(1,"test","test2",1,1,1,"jorge2009");
    call.enqueue(new Callback<List<ModeloCiudad>>() {
        @Override
        public void onResponse(Call<List<ModeloCiudad>> call, Response<List<ModeloCiudad>> response) {
            List<ModeloCiudad> modeloCiudad=response.body();
            int codigo=0;

            ModeloCiudad mciudad=new ModeloCiudad();
            for (ModeloCiudad mod : modeloCiudad){
                mciudad=new ModeloCiudad();
                codigo=mod.getCod_ciudad();
                mciudad.setNombre(mod.getNombre());
                listaCiudad2.add(mciudad);
                Log.d("Desinseg2", "onResponse: "+codigo);
            }
        }

        @Override
        public void onFailure(Call<List<ModeloCiudad>> call, Throwable t) {
            Log.d("Desinseg", "onResponse: "+t.getMessage());
        }
    });

    Spinner spinnerCiudad=findViewById(R.id.ciudad);

    try {
        ArrayAdapter<ModeloCiudad> adapter1=new ArrayAdapter<ModeloCiudad>(getApplicationContext(), android.R.layout.simple_spinner_item ,listaCiudad2);
        spinnerCiudad.setAdapter(adapter1);
        int total=spinnerCiudad.getAdapter().getCount();

        String valor="";
        Log.d("Desinseg22", "Error spinner: "+total);
        TextView txtv=findViewById(R.id.textView);





    }catch (Exception e){
        Log.d("Desinseg", "Error spinner: "+e.getMessage());
    }
}



 }


