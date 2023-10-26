package com.example.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void menuInsertar(View view){
        Intent obj = new Intent(this,
                Alta.class);
        this.startActivity(obj);
    }

    public void menuConsultar(View view){
        Intent obj = new Intent(this, Consultar.class);
        this.startActivity(obj);
    }

    public void menuEliminar(View view){
        Intent obj = new Intent(this, Eliminar.class);
        this.startActivity(obj);
    }
}