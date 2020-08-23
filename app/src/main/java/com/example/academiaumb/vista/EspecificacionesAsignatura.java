package com.example.academiaumb.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.academiaumb.R;
import com.example.academiaumb.model.dao.Asignatura;
import com.example.academiaumb.modelo.DaoApp;
import com.example.academiaumb.modelo.DaoQueries;
import com.example.academiaumb.presentador.EspecificacionesAsignaturaAdapter;

public class EspecificacionesAsignatura extends AppCompatActivity {

    RecyclerView rvEspecificaciones;
    EspecificacionesAsignaturaAdapter eaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especificaciones_asignatura);
        long id = getIntent().getLongExtra("id",0);
        eaa = new EspecificacionesAsignaturaAdapter(id);
        this.setTitle(DaoApp.getAsignaturaDao().loadByRowId(id).getNombre());

        rvEspecificaciones = findViewById(R.id.rvEspecificaciones);
        rvEspecificaciones.setLayoutManager(new LinearLayoutManager(this));
        rvEspecificaciones.setAdapter(eaa);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Asignaturas.class);
        startActivity(intent);
    }
}
