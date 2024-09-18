package com.desinseg.desinseg2app.producto;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import com.desinseg.desinseg2app.R;

import java.math.BigDecimal;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Producto extends AppCompatActivity {

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
        Button btnGuardarProducto=findViewById(R.id.guardar);
        btnGuardarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Desinseg", "click");
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
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl("https://www.desinseg.com/WebServiceDesinseg/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ProductoInterface productoInterface=retrofit.create(ProductoInterface.class);
                Call<List<ModeloProducto>> call = productoInterface.GuardoProducto("nombre","descrip",
                        "ruta","ver","descor", BigDecimal.ONE,1,
                        1,2,1,1 );
                call.enqueue(new Callback<List<ModeloProducto>>() {
                    @Override
                    public void onResponse(Call<List<ModeloProducto>> call, Response<List<ModeloProducto>> response) {
                        int total=0;
                        total=response.body().size();
                        Toast toast= Toast.makeText(getApplicationContext(),"Tamanio "+total,Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }

                    @Override
                    public void onFailure(Call<List<ModeloProducto>> call, Throwable t) {
                        Toast toast= Toast.makeText(getApplicationContext(),"Error "+t.getMessage(),Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }
                });


            }
        });
    }
}