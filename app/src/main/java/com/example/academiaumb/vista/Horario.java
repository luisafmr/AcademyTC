package com.example.academiaumb.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.academiaumb.R;
import com.example.academiaumb.presentador.HorarioAdapter;

public class Horario extends AppCompatActivity {

    RecyclerView rvHorario;
    HorarioAdapter horarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        horarioAdapter = new HorarioAdapter();
        horarioAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DialogHorario(v.getContext(),rvHorario.getChildAdapterPosition(v));
            }
        });

        rvHorario = findViewById(R.id.rvHorario);
        rvHorario.setLayoutManager(new GridLayoutManager(this, 6));
        rvHorario.setAdapter(horarioAdapter);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
