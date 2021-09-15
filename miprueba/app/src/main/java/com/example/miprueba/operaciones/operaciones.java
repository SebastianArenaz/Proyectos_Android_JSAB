package com.example.miprueba.operaciones;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miprueba.R;

public class operaciones {


    private double numero1 = 0, numero2 = 0;


    public double sum() {

        double r = realizar_operaciones(1, numero1, numero2);
        return r;
    }

    public double res() {

        double r = realizar_operaciones(2, numero1, numero2);
        return r;
    }

    public double mul() {

        double r = realizar_operaciones(3, numero1, numero2);
        return r;
    }

    public double div() {

        double r = realizar_operaciones(4, numero1, numero2);
        return r;
    }


    //con este metodo convertimos los numeros que recibimos como string en double
    public void ob_conv(String numero1, String numero2) {
        this.numero1 = Double.parseDouble(numero1.toString());
        this.numero2 = Double.parseDouble(numero2.toString());


    }

    //en este metodo hacemos las operaciones aritmeticas correspondientes
    private double realizar_operaciones(int tipo_operacion, double numero1, double numero2) {

        double resultado = 0;

        if (tipo_operacion == 1) {
            resultado = numero1 + numero2;
        }
        if (tipo_operacion == 2) {
            resultado = numero1 - numero2;
        }
        if (tipo_operacion == 3) {
            resultado = numero1 * numero2;
        }
        if (tipo_operacion == 4) {
            resultado = numero1 / numero2;
        }
        return resultado;


    }


}


