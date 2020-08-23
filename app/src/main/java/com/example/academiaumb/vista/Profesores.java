package com.example.academiaumb.vista;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.academiaumb.R;
import com.example.academiaumb.presentador.ProfesoresAdapter;

public class Profesores extends AppCompatActivity {

    RecyclerView rvProfesores;
    FloatingActionButton fabAgregarProfesores;
    ProfesoresAdapter profesoresAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);

        rvProfesores = findViewById(R.id.rvProfesoresss);

        profesoresAdapter = new ProfesoresAdapter();
        profesoresAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DialogProfesores(v.getContext(),
                        profesoresAdapter.getProfesores().get(rvProfesores.getChildAdapterPosition(v)).getId());
            }
        });

        rvProfesores.setLayoutManager(new LinearLayoutManager(this));
        rvProfesores.setAdapter(profesoresAdapter);

        crearFab();
    }

    public void crearFab() {
        fabAgregarProfesores = findViewById(R.id.fabAgregarProfesor);
        fabAgregarProfesores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DialogProfesores(v.getContext());
            }
        });
    }
}
