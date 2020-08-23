package com.example.academiaumb.vista;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.academiaumb.R;
import com.example.academiaumb.model.dao.Profesor;
import com.example.academiaumb.modelo.DaoApp;
import com.example.academiaumb.modelo.DaoQueries;

public class DialogProfesores {

    EditText txtNombreProfesor, txtCorreo, txtTelefono;
    Button btnAfirmativo, btnNegativo;

    public DialogProfesores(final Context context) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_profesor);

        txtNombreProfesor = dialog.findViewById(R.id.txtNombreProfesor);
        txtCorreo = dialog.findViewById(R.id.txtCorreo);
        txtTelefono = dialog.findViewById(R.id.txtTelefono);
        btnAfirmativo = dialog.findViewById(R.id.btnAfirmativo);
        btnNegativo = dialog.findViewById(R.id.btnNegativo);

        btnAfirmativo.setText(R.string.agregar);
        btnAfirmativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoQueries.agregarProfesor(txtNombreProfesor.getText().toString(),
                        txtCorreo.getText().toString(),
                        txtTelefono.getText().toString());
                Intent intent = new Intent(context, Profesores.class);
                context.startActivity(intent);
            }
        });
        btnNegativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public DialogProfesores(final Context context, final long id) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_profesor);

        txtNombreProfesor = dialog.findViewById(R.id.txtNombreProfesor);
        txtCorreo = dialog.findViewById(R.id.txtCorreo);
        txtTelefono = dialog.findViewById(R.id.txtTelefono);
        btnAfirmativo = dialog.findViewById(R.id.btnAfirmativo);
        btnNegativo = dialog.findViewById(R.id.btnNegativo);

        Profesor profesor = DaoApp.getProfesorDao().loadByRowId(id);
        txtNombreProfesor.setText(profesor.getNombre());
        txtCorreo.setText(profesor.getCorreo());
        txtTelefono.setText(profesor.getTelefono());

        btnNegativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnAfirmativo.setText(R.string.modificar);
        btnAfirmativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoQueries.modificarProfesor(id,
                        txtNombreProfesor.getText().toString(),
                        txtCorreo.getText().toString(),
                        txtTelefono.getText().toString());
                Intent intent = new Intent(context, Profesores.class);
                context.startActivity(intent);
            }
        });
        dialog.show();
    }

}
