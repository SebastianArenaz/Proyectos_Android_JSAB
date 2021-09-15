package com.example.miprueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miprueba.operaciones.operaciones;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView vista;
    operaciones operaciones;
    Button btn;
    private String numero1, numero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creamos los objetos y las instancias
        vista = (TextView) findViewById(R.id.txtresultado);
        btn = (Button) findViewById(R.id.nuevaPan);
        operaciones = new operaciones();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pantalla2.class);

                startActivity(intent);
            }
        });

    }

    //evento para sumar
    public void sum(View v) {
        ob_Num();
        try {
            operaciones.ob_conv(numero1, numero2);
            vista.setText(String.valueOf(operaciones.sum()));
        } catch (Exception e) {
            mensajeError();
        }
    }

    //evento para restar
    public void res(View v) {
        ob_Num();
        try {
            operaciones.ob_conv(numero1, numero2);
            vista.setText(String.valueOf(operaciones.res()));
        } catch (Exception e) {
            mensajeError();
        }
    }

    //evento para multiplicar
    public void mul(View v) {
        ob_Num();
        try {
            operaciones.ob_conv(numero1, numero2);
            vista.setText(String.valueOf(operaciones.mul()));
        } catch (Exception e) {
            mensajeError();
        }
    }

    private void mensajeError() {
       // Toast.makeText(getApplicationContext(),
          //      "Verifique que los campos estén correctos", Toast.LENGTH_SHORT).show();
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.myLayout),
                "Ha ocurrido algo, Verifique los campos", Snackbar.LENGTH_SHORT);
        mySnackbar.setAction("LISTO", new MainActivity());
        mySnackbar.show();

    }
    //evento para dividir
    public void div(View v) {
        ob_Num();
        try {
            operaciones.ob_conv(numero1, numero2);
            vista.setText(String.valueOf(operaciones.div()));
        } catch (Exception e) {
            mensajeError();
        }
    }

    //metodo para obtener los numeros de los campos
    private void ob_Num() {
        numero1 = ((EditText) findViewById(R.id.campo1)).getText().toString();
        numero2 = ((EditText) findViewById(R.id.campo2)).getText().toString();
    }

    @Override
    public void onClick(View view) {

    }
}
