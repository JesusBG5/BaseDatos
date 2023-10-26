package com.example.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Consultar extends AppCompatActivity {

    TextView txtLista ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        try {

            txtLista = this.findViewById(R.id.txtLista);
            txtLista.setText("");
            AdminSQLiteOpenHelper obj = new
                    AdminSQLiteOpenHelper(this,
                    "agenda2", null, 1);
            SQLiteDatabase db = obj.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM agenda", null);
            if (c != null) {
                c.moveToFirst();
                do {
                    String matricula = c.getString(0);
                    String nombre = c.getString(1);
                    String telefono = c.getString(2);
                    txtLista.setText(txtLista.getText() +
                            matricula + " " + nombre + " " +
                            telefono);
                } while (c.moveToNext());
            }
            c.close();
            db.close();
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }
}