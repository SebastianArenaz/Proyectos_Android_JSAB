package com.example.area_figuras_geometricas;

import android.widget.RadioButton;
import android.widget.TextView;

public class asignar_figura {
    RadioButton radiobutonSeleccionado;

    public void asignarFigura(int figura,TextView titulo) {
        if (figura == 1) {
            titulo.setText("CUADRADO");
        }
        if (figura == 2) {
            titulo.setText("TRIANGULO");
        }
        if (figura == 3) {
            titulo.setText("RECTANGULO");
        }
    }

    public double calcular_areas(int figura,double base,double altura){
        double area=0;
        switch (figura){
            //tomamos la base como el lado del cuadrado
            case 1:
                area=base*base;
                break;
            case 2:
                area=(base*altura)/2;
                break;
            case 3:
                area=(base*altura);
                break;
        }
        return area;
    }
}
