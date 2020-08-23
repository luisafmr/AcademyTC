package com.example.academiaumb.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.academiaumb.R;
import com.example.academiaumb.vista.agenda.Agenda;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnAsignaturas;
    private ImageButton btnCalculadora;
    private ImageButton btnCalendario;
    private ImageButton btnAgenda;
    private ImageButton btnProfesores;
    private ImageButton btnAnotaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnAsignaturas = findViewById(R.id.btnAsignaturas);
        btnCalculadora = findViewById(R.id.btnCalculadora);
        btnCalendario = findViewById(R.id.btnCalendario);
        btnAgenda = findViewById(R.id.btnAgenda);
        btnProfesores = findViewById(R.id.btnProfesores);
        btnAnotaciones = findViewById(R.id.btnAnotaciones);
    }

    public void navegar(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnAsignaturas:
                intent = new Intent(this, Asignaturas.class);
                break;
            case R.id.btnAgenda:
                intent = new Intent(this, Agenda.class);
                break;
            case R.id.btnCalculadora:
                intent = new Intent(this, CalculoRapido.class);
                break;
            case R.id.btnCalendario:
                intent = new Intent(this, Horario.class);
                break;
            case R.id.btnProfesores:
                intent = new Intent(this, Profesores.class);
                break;
            case R.id.btnAnotaciones:
                intent = new Intent(this, Anexos.class);
                break;
            case R.id.btnEventos:
                intent = new Intent(this, Picker.class);
                break;
            default:
                Toast.makeText(this, R.string.errorInesperado, Toast.LENGTH_LONG).show();
                return;
        }
        startActivity(intent);
    }
}