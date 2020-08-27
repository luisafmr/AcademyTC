package com.example.academiaumb.vista;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.academiaumb.R;
import com.example.academiaumb.model.dao.Horario;
import com.example.academiaumb.modelo.DaoQueries;

public class DialogHorario {

    TextView txtAsignaturas, txtHoraInicio, txtHoraSalida, txtSalon;
    Button btnAfirmativo;

    public DialogHorario(final Context context, final int posicion) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_horario);

        final Horario horario = DaoQueries.getHorarioByPosicion(posicion);

        txtAsignaturas = dialog.findViewById(R.id.txtAsignaturas);
        txtHoraInicio = dialog.findViewById(R.id.txtHoraInicio);
        txtHoraSalida = dialog.findViewById(R.id.txtHoraSalida);
        txtSalon = dialog.findViewById(R.id.txtSalon);
        btnAfirmativo = dialog.findViewById(R.id.btnAfirmativo);

        if (horario == null) {
            btnAfirmativo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DaoQueries.AgregarHorario(txtAsignaturas.getText().toString(),
                            txtHoraInicio.getText().toString(),
                            txtHoraSalida.getText().toString(),
                            txtSalon.getText().toString(),
                            posicion);
                    Intent intent = new Intent(context, com.example.academiaumb.vista.Horario.class);
                    context.startActivity(intent);
                }
            });
        } else {
            txtAsignaturas.setText(horario.getAsignatura().getNombre());
            txtHoraInicio.setText(horario.getHoraEntrada());
            txtHoraSalida.setText(horario.getHoraSalida());
            txtSalon.setText(horario.getSalon());

            btnAfirmativo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DaoQueries.ModificarHorario(horario,
                            txtAsignaturas.getText().toString(),
                            txtHoraInicio.getText().toString(),
                            txtHoraSalida.getText().toString(),
                            txtSalon.getText().toString());
                    Intent intent = new Intent(context, com.example.academiaumb.vista.Horario.class);
                    context.startActivity(intent);
                }
            });
        }
        dialog.show();
    }
}
