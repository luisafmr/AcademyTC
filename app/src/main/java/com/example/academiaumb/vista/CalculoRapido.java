package com.example.academiaumb.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.academiaumb.R;

public class CalculoRapido extends AppCompatActivity {
    TextView txtPorcentaje1, txtPorcentaje2, txtPorcentaje3, txtNota1, txtNota2, txtNota3;
    Button btnPorcentajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui_porcentajes_nota);
        txtPorcentaje1 = findViewById(R.id.txtPorcentaje1);
        txtPorcentaje2 = findViewById(R.id.txtPorcentaje2);
        txtPorcentaje3 = findViewById(R.id.txtPorcentaje3);
        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        txtNota3 = findViewById(R.id.txtNota3);
        btnPorcentajes = findViewById(R.id.btnPorcentajes);

        btnPorcentajes.setText(R.string.calculoRapido);
        btnPorcentajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double porcentaje1 = verificarValor(txtPorcentaje1.getText().toString())/100;
                double porcentaje2 = verificarValor(txtPorcentaje2.getText().toString())/100;
                double porcentaje3 = verificarValor(txtPorcentaje3.getText().toString())/100;

                double total = porcentaje1+porcentaje2+porcentaje3;
                Log.d("valor",""+total);
                if (total == 1){
                    double nota1 = verificarValor(txtNota1.getText().toString());
                    double nota2 = verificarValor(txtNota2.getText().toString());
                    double nota3 = verificarValor(txtNota3.getText().toString());
                    double resultado = (nota1*porcentaje1)+(nota2*porcentaje2)+(nota3*porcentaje3);
                    if (nota1 > 5 || nota2 > 5 || nota3 > 5){
                        Toast.makeText(v.getContext(),R.string.notaNoValida,Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(v.getContext(),v.getContext().getString(R.string.resultado)+resultado,Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(v.getContext(),R.string.porcentaNoValido,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public double verificarValor(String valor){
        if (valor.isEmpty() || valor==null){
            return 0;
        }else{
            return Double.parseDouble(valor);
        }
    }
}
