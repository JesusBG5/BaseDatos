package com.example.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Eliminar extends AppCompatActivity {

    EditText cajaME, cajaNE, cajaTE;
    Contacto lista [];
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        cajaME = findViewById(R.id.cajaMatE);
        cajaNE = findViewById(R.id.cajaNombreE);
        cajaTE = findViewById(R.id.cajaTelE);

        AdminSQLiteOpenHelper obj = new
                AdminSQLiteOpenHelper(this,
                "agenda2", null, 1);
        SQLiteDatabase db = obj.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM agenda", null);
        if (c != null) {
            c.moveToFirst();
            lista = new Contacto[c.getCount()];
            int i = 0;
            do {
                String matricula = c.getString(0);
                String nombre = c.getString(1);
                String telefono = c.getString(2);
                lista[i] = new Contacto(nombre, matricula,telefono);
                i++;
            } while (c.moveToNext());
        }
        c.close();
        db.close();

        cajaME.setText(lista[0].matricula);
        cajaNE.setText(lista[0].nombre);
        cajaTE.setText(lista[0].telefono);
    }

    public void siguiente(View view){
        if(contador<lista.length-1){
            contador++;
            cajaME.setText(lista[contador].matricula);
            cajaNE.setText(lista[contador].nombre);
            cajaTE.setText(lista[contador].telefono);
        }
    }

    public void anterior(View view){
        if(contador>0){
            contador--;
            cajaME.setText(lista[contador].matricula);
            cajaNE.setText(lista[contador].nombre);
            cajaTE.setText(lista[contador].telefono);
        }
    }

    public void eliminar(View view){
        AdminSQLiteOpenHelper obj = new
                AdminSQLiteOpenHelper(this,
                "agenda2", null, 1);
        SQLiteDatabase db = obj.getWritableDatabase();
        db.execSQL("DELETE FROM agenda WHERE matricula = '"+cajaME.getText()+"'");
        db.close();
        Intent obj2 = new Intent(this,Eliminar.class);
        this.startActivity(obj2);
        this.finish();
    }
}