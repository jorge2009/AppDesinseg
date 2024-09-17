package com.desinseg.desinseg2app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.desinseg.desinseg2app.cliente.Cliente;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("Desinseg App");
        toolbar.inflateMenu(R.menu.menu);
        setSupportActionBar(toolbar);



    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if(item.getItemId()==R.id.cliente){
                Intent intent=new Intent(getApplicationContext(), Cliente.class);
                startActivity(intent);
            }
            if(item.getItemId()==R.id.descarga){
                Toast.makeText(Principal.this, "descarga", Toast.LENGTH_SHORT).show();
            }
            if(item.getItemId()==R.id.producto){
                Toast.makeText(Principal.this, "producto", Toast.LENGTH_SHORT).show();
            }
            if(item.getItemId()==R.id.servicio){
                Toast.makeText(Principal.this, "servicio", Toast.LENGTH_SHORT).show();
            }
            if(item.getItemId()==R.id.software){
                Toast.makeText(Principal.this, "software", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    });
    }
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}