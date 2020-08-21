package com.example.academiaumb.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.academiaumb.R;
import com.example.academiaumb.presentador.AgregarAsignaturaPresentador;

public class AgregarAsignatura extends AppCompatActivity {

    private EditText txtAsignaturas, txtProfesor, txtColor, txtDetalles;
    Button btnGuardar;

    AgregarAsignaturaPresentador aap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui_agregar_asignatura);

        txtAsignaturas = findViewById(R.id.txtAsignaturas);
        txtProfesor = findViewById(R.id.txtProfesor);
        txtColor = findViewById(R.id.txtColor);
        txtDetalles = findViewById(R.id.txtDetalles);

        aap = new AgregarAsignaturaPresentador(this);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDatos(v);
            }
        });
    }

    public boolean verificarCampoVacio() {
        if (txtAsignaturas.getText().toString().isEmpty() || txtAsignaturas.getText().toString() == null) {
            mostrarMensaje(R.string.errorFormularioAsignaturaVacia);
            return true;
        } else {
            if (txtColor.getText().toString().isEmpty() || txtColor.getText().toString() == null) {
                mostrarMensaje(R.string.errorFormularioColorVacio);
                return true;
            } else {
                return false;
            }
        }
    }

    public void mostrarMensaje(int mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    public void enviarDatos(View view) {
        if (!verificarCampoVacio()) {
            aap.agregarAsignatura(txtAsignaturas.getText().toString(),
                    txtProfesor.getText().toString(),
                    txtColor.getText().toString(),
                    txtDetalles.getText().toString());
        }
    }

    public void cambiarVista(){
        Intent intent = new Intent(this, Asignaturas.class);
        startActivity(intent);
    }


}
