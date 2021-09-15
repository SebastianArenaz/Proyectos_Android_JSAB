package com.example.miprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pantalla2 extends AppCompatActivity {

    Button btnclick;
    TextView sebas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        btnclick= (Button) findViewById(R.id.nuevaPan);
        sebas = (TextView) findViewById(R.id.so) ;

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sebas.setText("haroolddd hptaaaa");
            }
        });
    }
}