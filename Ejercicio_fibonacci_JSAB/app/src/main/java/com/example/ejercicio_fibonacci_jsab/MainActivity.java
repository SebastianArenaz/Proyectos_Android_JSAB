package com.example.ejercicio_fibonacci_jsab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();

    }

    private LinearLayout layoutLimite, layoutSinLimite;
    private ScrollView scrollPrincipal;
    private Button bntSecuenciaLimite, btnSecuenciaSinLimite, btnRealizarSecuencias, btnMas, btnMenos;
    private TextView resultadoSecuencias, cantidadSecuencias;
    private EditText numeroSecuencias;
    private int cantidad_secuencia;

    private void setControls() {

        this.bntSecuenciaLimite = findViewById(R.id.btnSecuenciasLimite);
        this.btnSecuenciaSinLimite = findViewById(R.id.btnSecuenciasSinLimite);
        this.btnRealizarSecuencias = findViewById(R.id.btnRealizarSecuencias);
        btnMas = findViewById(R.id.btnSecuenciasMas);
        btnMenos = findViewById(R.id.btnSecuenciasMenos);

        this.layoutLimite = findViewById(R.id.layoutLimite);
        this.layoutSinLimite = findViewById(R.id.layoutSinLimite);
        this.scrollPrincipal = findViewById(R.id.scrollPrincipal);

        cantidadSecuencias = findViewById(R.id.cantidadSecuencias);
        resultadoSecuencias = findViewById(R.id.Resultado_secuencias);
        numeroSecuencias = findViewById(R.id.txtNumerosecuencias);

        bntSecuenciaLimite.setOnClickListener(this);
        btnSecuenciaSinLimite.setOnClickListener(this);
        btnMas.setOnClickListener(this);
        btnRealizarSecuencias.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        cantidad_secuencia = 1;
        scrollPrincipal.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_transition));

    }

    private String serie_fibonacci_limite(int numero_repeticiones) {
        int primero = 1, ultimo = 1;
        String Secuencias = "0";
        Secuencias += (" , " + String.valueOf(ultimo));
        for (int i = 2; i < numero_repeticiones; i++) {
            Secuencias += (" , " + String.valueOf(ultimo));
            ultimo = ultimo + primero;
            primero = ultimo - primero;
        }
        return Secuencias;
    }

    private void limpiar() {
        cantidad_secuencia = 1;
        resultadoSecuencias.setText("0 , 1");
        numeroSecuencias.setText("");
        cantidadSecuencias.setText("1");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        int vector[] = new int[3];
        switch (id) {
            case R.id.btnSecuenciasLimite:
                layoutSinLimite.setVisibility(View.GONE);
                layoutLimite.setVisibility(View.VISIBLE);
                layoutLimite.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_transition));
                limpiar();

                break;
            case R.id.btnSecuenciasSinLimite:
                layoutLimite.setVisibility(View.GONE);
                layoutSinLimite.setVisibility(View.VISIBLE);
                layoutSinLimite.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_transition));
                resultadoSecuencias.setText(serie_fibonacci_limite(cantidad_secuencia));
                limpiar();
                break;

            case R.id.btnRealizarSecuencias:
                try {
                    resultadoSecuencias.setText(serie_fibonacci_limite(Integer.parseInt(numeroSecuencias.getText().toString())));
                } catch (Exception e) {
                    mensaje();
                }
                break;

            case R.id.btnSecuenciasMas:

                cantidad_secuencia += 1;
                resultadoSecuencias.setText(serie_fibonacci_limite(cantidad_secuencia));
                cantidadSecuencias.setText(String.valueOf(cantidad_secuencia));
                break;

            case R.id.btnSecuenciasMenos:

                if (cantidad_secuencia > 1) {
                    cantidad_secuencia -= 1;
                    resultadoSecuencias.setText(serie_fibonacci_limite(cantidad_secuencia));
                    cantidadSecuencias.setText(String.valueOf(cantidad_secuencia));
                } else {
                    mensaje();
                }

                break;
        }

    }

    private void mensaje() {

        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.scrollPrincipal),
                "El numero de secuencias a realizar deben ser mayores o iguales a 1", Snackbar.LENGTH_SHORT);
        mySnackbar.setAction("LISTO", this);
        mySnackbar.show();
    }
}