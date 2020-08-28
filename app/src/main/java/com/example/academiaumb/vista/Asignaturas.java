package com.example.academiaumb.vista;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.academiaumb.R;
import com.example.academiaumb.presentador.AsignaturasAdapter;

public class Asignaturas extends AppCompatActivity {

    private RecyclerView rvAsignaturas;
    private FloatingActionButton fabAgregarAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        rvAsignaturas = findViewById(R.id.rvAsignaturas);
        rvAsignaturas.setLayoutManager(new LinearLayoutManager(this));
        final AsignaturasAdapter asignaturasAdapter = new AsignaturasAdapter();
        asignaturasAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EspecificacionesAsignatura.class);
                intent.putExtra("id", asignaturasAdapter.getIdAsignatura(rvAsignaturas.getChildLayoutPosition(v)));
                startActivity(intent);
            }
        });
        rvAsignaturas.setAdapter(asignaturasAdapter);



        createFloatActionButton();
    }

    private void createFloatActionButton(){
        fabAgregarAsignatura = findViewById(R.id.fabAgregarAsignatura);
        fabAgregarAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AgregarAsignatura.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
