package com.example.vectoresandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControls();
    }

    private Button btnMayor_Menor;
    private TextView mayor, menor;
    EditText nota1, nota2, nota3, nota4, nota5, nota6, nota7;


    private void setControls() {
        btnMayor_Menor = findViewById(R.id.btnBuscarMayor_menor);

        mayor = findViewById(R.id.txtMayor);
        menor = findViewById(R.id.txtMenor);
        nota1 = findViewById(R.id.edtNota1);
        nota2 = findViewById(R.id.edtNota2);
        nota3 = findViewById(R.id.edtNota3);
        nota4 = findViewById(R.id.edtNota4);
        nota5 = findViewById(R.id.edtNota5);
        nota6 = findViewById(R.id.edtNota6);
        nota7 = findViewById(R.id.edtNota7);

        btnMayor_Menor.setOnClickListener(this);
        vector = new float[7];
    }

    @Override
    public void onClick(View view) {

        bandera = 0;
        try {
            calcular();
            if (bandera == 0) {
                mayor.setText(String.valueOf(Nmayor));
                menor.setText(String.valueOf(Nmenor));
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "Verifique que los campos estén correctos", Toast.LENGTH_SHORT).show();
        }
    }

    float vector[];
    float Nmayor, Nmenor;
    int bandera;

    private void calcular() {
        vector[0] = Float.parseFloat(nota1.getText().toString());
        vector[1] = Float.parseFloat(nota2.getText().toString());
        vector[2] = Float.parseFloat(nota3.getText().toString());
        vector[3] = Float.parseFloat(nota4.getText().toString());
        vector[4] = Float.parseFloat(nota5.getText().toString());
        vector[5] = Float.parseFloat(nota6.getText().toString());
        vector[6] = Float.parseFloat(nota7.getText().toString());
        Nmenor = vector[0];
        Nmayor = vector[0];
        for (int i = 0; i < vector.length; i++) {

            if (vector[i] < 0) {
                bandera = 1;
            }
            if (vector[i] > 5) {
                bandera = 1;
            }

            if (vector[i] < Nmenor) {
                Nmenor = vector[i];
            }
            if (vector[i] > Nmayor) {
                Nmayor = vector[i];
            }
        }

    }
}