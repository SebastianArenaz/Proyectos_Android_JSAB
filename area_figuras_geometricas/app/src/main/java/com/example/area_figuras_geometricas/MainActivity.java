package com.example.area_figuras_geometricas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControls();
        l.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_transition));
    }

    double res1, res2;
    TextInputLayout campo2IL, campo1IL;
    Button calcular_area;
    TextView titulo_figura, texto_area, resultado;
    RadioButton rRectangulo, rCuadrado, rTriangulo;
    EditText campo1, campo2;
    CardView l;
    private int figura_seleccionada;
    asignar_figura asignar_figura;

    private void setControls() {
        this.titulo_figura = findViewById(R.id.titulo_figura);
        this.texto_area = findViewById(R.id.texto_area);
        this.resultado = findViewById(R.id.resultado);
        this.rRectangulo = findViewById(R.id.r_rectangulo);
        this.rCuadrado = findViewById(R.id.r_cuadrado);
        this.rTriangulo = findViewById(R.id.r_triangulo);
        this.campo1 = findViewById(R.id.campo1);
        this.campo2 = findViewById(R.id.campo2);
        this.campo2IL = findViewById(R.id.campo2IL);
        this.campo1IL = findViewById(R.id.campo1IL);
        this.l = findViewById(R.id.carta);
        rCuadrado.setChecked(true);
        this.calcular_area = findViewById(R.id.calcular_area);


        rRectangulo.setOnClickListener(this);
        rTriangulo.setOnClickListener(this);
        rCuadrado.setOnClickListener(this);
        asignar_figura = new asignar_figura();
        campo2IL.setVisibility(View.INVISIBLE);
        figura_seleccionada = 1;
        res1 = 0;
        res2 = 0;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        campo2IL.setVisibility(View.VISIBLE);
        campo1IL.setErrorEnabled(false);
        campo2IL.setErrorEnabled(false);
        l.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_transition));
        limpiar();

        switch (id) {
            case R.id.r_cuadrado:
                campo1IL.setHint("Ingrese el lado");
                figura_seleccionada = 1;
                asignar_figura.asignarFigura(figura_seleccionada, titulo_figura);
                campo2IL.setVisibility(View.INVISIBLE);
                break;
            case R.id.r_triangulo:
                campo1IL.setHint("Ingrese la base");
                figura_seleccionada = 2;
                asignar_figura.asignarFigura(figura_seleccionada, titulo_figura);
                break;
            case R.id.r_rectangulo:
                campo1IL.setHint("Ingrese la base");
                figura_seleccionada = 3;
                asignar_figura.asignarFigura(figura_seleccionada, titulo_figura);
                break;

        }

    }

    public void calcularA(View v) {
        double area = 0, k = 0;
        campo1IL.setErrorEnabled(false);
        campo2IL.setErrorEnabled(false);
        try {
            convertir_campo_buscar_errores(campo1, campo2, campo1IL,campo2IL);
            area = asignar_figura.calcular_areas(figura_seleccionada,
                    res1, campo2IL.getVisibility() == View.VISIBLE ? res2 : 0);

            resultado.setText(String.valueOf(area));
        } catch (Exception e) {
            mensajeError();
        }

    }

    public void limpiar() {
        resultado.setText("0.0");
        campo1.setText("");
        campo2.setText("");

    }

    private void mensajeError() {
        // Toast.makeText(getApplicationContext(),
        //      "Verifique que los campos estén correctos", Toast.LENGTH_SHORT).show();
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.layoutPrincipal),
                "Ha ocurrido algo, Verifique los campos", Snackbar.LENGTH_SHORT);
        mySnackbar.setAction("LISTO", this);
        mySnackbar.show();
    }

    private void convertir_campo_buscar_errores(EditText campo1, EditText campo2, TextInputLayout error1, TextInputLayout error2) throws IOException {
        try {
            res1 = Double.parseDouble(campo1.getText().toString());
        } catch (Exception e) {
            error1.setErrorEnabled(true);
            error1.setError("Ingrese un numero valido");
        }
        try {
            res2 = Double.parseDouble(campo2.getText().toString());
        } catch (Exception e) {
            error2.setErrorEnabled(true);
            error2.setError("Ingrese un numero valido");
        }


    }

}