package com.example.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Alta extends AppCompatActivity {

    EditText cajaN,cajaM,cajaT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);
        cajaM = this.findViewById(R.id.cajaMat);
        cajaN = this.findViewById(R.id.cajaNombre);
        cajaT = this.findViewById(R.id.cajaTel);
    }

    public void guardar(View view){
        try {
            AdminSQLiteOpenHelper obj = new
                    AdminSQLiteOpenHelper(this,
                    "agenda2", null, 1);
            SQLiteDatabase db = obj.getWritableDatabase();
            ContentValues datos = new ContentValues();
            datos.put("nombre", cajaN.getText().toString());
            datos.put("telefono", cajaT.getText().toString());
            datos.put("matricula", cajaM.getText().toString());
            db.insert("agenda", null, datos);
            db.close();
            Toast.makeText(this,"Contacto guardado 😁"  ,
                    Toast.LENGTH_LONG).show();
        }catch(Exception e){
            Toast.makeText(this,e.toString(),
                    Toast.LENGTH_LONG).show();
        }
    }
}