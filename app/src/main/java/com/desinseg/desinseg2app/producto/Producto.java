package com.desinseg.desinseg2app.producto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.desinseg.desinseg2app.MainActivity;
import com.desinseg.desinseg2app.R;
import com.desinseg.desinseg2app.cliente.ModeloCliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigDecimal;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Producto extends AppCompatActivity {

    ImageView imagenProducto;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_producto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtProducto=findViewById(R.id.nProducto);
        EditText txtProveedor=findViewById(R.id.proveedor);
        EditText txtdescripcion=findViewById(R.id.descripcion);
        EditText txtruta=findViewById(R.id.ruta);
        EditText txtver=findViewById(R.id.ver);
        EditText txtdesCorta=findViewById(R.id.desCorta);
        EditText txtCantidad=findViewById(R.id.cantidad);
        EditText txtvalor=findViewById(R.id.valor);
        imagenProducto=findViewById(R.id.imagenProducto);

        Button btnGuardarProducto=findViewById(R.id.guardar);


        btnGuardarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Desinseg", "click");
                String producto=txtProducto.getText().toString();
                /*
                //valido datos cliente
                if(TextUtils.isEmpty(txtProducto.getText())){
                    //Toast toast= Toast.makeText(getApplicationContext(),"Ingrese un nombre ",Toast.LENGTH_SHORT);
                    //toast.setGravity(Gravity.CENTER,0,0);
                    //toast.show();
                    txtProducto.setError("Este campo no puede ser vacio...");
                    return;
                }

                 */
                Gson gson=new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl("https://www.desinseg.com/WebServiceDesinseg/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ProductoInterface productoInterface=retrofit.create(ProductoInterface.class);
                Call<List<ModeloProducto>> call = productoInterface.GuardoProducto(producto,txtdescripcion.getText().toString(),
                        txtruta.getText().toString(),txtver.getText().toString(),txtdesCorta.getText().toString(), Double.parseDouble(txtvalor.getText().toString()),1,
                        1,2,1,10,1,"jorge2009" );
                call.enqueue(new Callback<List<ModeloProducto>>() {
                    @Override
                    public void onResponse(Call<List<ModeloProducto>> call, Response<List<ModeloProducto>> response) {

                        List<ModeloProducto> modeloProductos=response.body();
                        int total=0;
                        for (ModeloProducto mod : modeloProductos){
                            total=mod.getCod_producto();
                        }

                        txtProveedor.setText("Valor "+total);
                    }

                    @Override
                    public void onFailure(Call<List<ModeloProducto>> call, Throwable t) {
                        Toast toast= Toast.makeText(getApplicationContext(),"Error "+t.getMessage(),Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                        txtProveedor.setText("error "+t.getMessage());
                    }
                });


            }
        });
        imagenProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "The favorite list would appear on clicking this icon",
                        Toast.LENGTH_LONG).show();
               openGallery();
            }
        });
    }

    private void openGallery() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(photoPickerIntent, 100);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 100){
            imageUri = data.getData();
            imagenProducto.setImageURI(imageUri);
        }
    }
}