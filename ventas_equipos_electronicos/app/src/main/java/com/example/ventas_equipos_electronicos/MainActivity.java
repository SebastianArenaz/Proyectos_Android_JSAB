package com.example.ventas_equipos_electronicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControls();
    }

    private double total_pagar;
    TextView resultado;
    CardView pantallaResultado;
    ScrollView s;
    RadioButton r1, r2, r3;
    CheckBox c1, c2, c3;
    Button total, atrás;


    private void setControls() {
        this.r1 = findViewById(R.id.radio1);
        this.r2 = findViewById(R.id.radio2);
        this.r3 = findViewById(R.id.radio3);
        this.resultado = findViewById(R.id.total);
        this.c1 = findViewById(R.id.checkbox1);
        this.c2 = findViewById(R.id.checkbox2);
        this.c3 = findViewById(R.id.checkbox3);
        this.s = findViewById(R.id.scroll_Todo);
        this.pantallaResultado = findViewById(R.id.pantallaResultado);
        total = findViewById(R.id.btnComprar);
        atrás = findViewById(R.id.btnAtras);

        total_pagar = 0;

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnComprar:
                realizar_compra();
                break;
            case R.id.btnAtras:
                total_pagar = 0;
                s.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_transition));
                s.setVisibility(View.VISIBLE);
                reiniciar();
                pantallaResultado.setVisibility(View.INVISIBLE);

                break;
        }


    }

    private void reiniciar() {

        r1.setChecked(false);
        r2.setChecked(false);
        r3.setChecked(false);

        c1.setChecked(false);
        c2.setChecked(false);
        c3.setChecked(false);

    }

    private void realizar_compra() {
        if (c1.isChecked()) {
            total_pagar += 150000;
        }
        if (c2.isChecked()) {
            total_pagar += 250000;
        }
        if (c3.isChecked()) {
            total_pagar += 200000;
        }

        if (r1.isChecked()) {
            total_pagar += 1000000;
        }
        if (r2.isChecked()) {
            total_pagar += 2000000;
        }
        if (r3.isChecked()) {
            total_pagar += 1500000;
        }
        resultado.setText("$ " + String.valueOf(total_pagar));
        s.setVisibility(View.INVISIBLE);
        pantallaResultado.setVisibility(View.VISIBLE);
        pantallaResultado.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_transition));

    }
}