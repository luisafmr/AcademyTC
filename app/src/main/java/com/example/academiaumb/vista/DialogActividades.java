package com.example.academiaumb.vista;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.academiaumb.R;
import com.example.academiaumb.model.dao.Actividad;
import com.example.academiaumb.modelo.DaoApp;
import com.example.academiaumb.modelo.DaoQueries;
import com.example.academiaumb.vista.agenda.Agenda;

import java.util.Calendar;
import java.util.Date;

public class DialogActividades {

    EditText txtAsignatura, txtTitulo, txtFechaEntrega;
    Spinner txtTipo;
    Button btnAfirmativo, btnNegativo;
    Dialog dialog;
    Date fecha;
    String categoria;
    String[] datos;


    public DialogActividades(Context context, final String categoria) {
        this.categoria = categoria;
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_actividad);

        txtAsignatura = dialog.findViewById(R.id.txtAsignatura);
        txtTitulo = dialog.findViewById(R.id.txtTitulo);
        txtFechaEntrega = dialog.findViewById(R.id.txtFechaEntrega);
        txtTipo = dialog.findViewById(R.id.txtTipo);
        btnAfirmativo = dialog.findViewById(R.id.btnAfirmativo);
        btnNegativo = dialog.findViewById(R.id.btnNegativo);

        txtFechaEntrega.setClickable(true);
        txtFechaEntrega.setKeyListener(null);
        txtFechaEntrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate(v);
            }
        });
        btnAfirmativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoQueries.agregarActividad(txtTitulo.getText().toString(),
                        fecha,
                        txtTipo.getSelectedItem().toString(),
                        categoria,
                        txtAsignatura.getText().toString());
                Intent intent = new Intent(dialog.getContext(), Agenda.class);
                if (categoria == dialog.getContext().getString(R.string.tipoExamen)) {
                    intent.putExtra("tab", 1);
                }
                dialog.getContext().startActivity(intent);
            }
        });

        btnNegativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        contenidoLista();
        dialog.show();
    }

    public DialogActividades(Context context, final String categoria, long id) {
        this.categoria = categoria;
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_actividad);

        txtAsignatura = dialog.findViewById(R.id.txtAsignatura);
        txtTitulo = dialog.findViewById(R.id.txtTitulo);
        txtFechaEntrega = dialog.findViewById(R.id.txtFechaEntrega);
        txtTipo = dialog.findViewById(R.id.txtTipo);
        btnAfirmativo = dialog.findViewById(R.id.btnAfirmativo);
        btnNegativo = dialog.findViewById(R.id.btnNegativo);
        btnAfirmativo.setText(R.string.modificar);

        final Actividad actividad = DaoApp.getActividadDao().loadByRowId(id);

        txtAsignatura.setText(actividad.getAsignatura().getNombre());
        txtTitulo.setText(actividad.getNombre());
        fecha = actividad.getFechaEntrega();
        txtFechaEntrega.setText(String.valueOf(fecha.getDate()) + "/" + String.valueOf(fecha.getMonth() + 1) + "/" + String.valueOf(fecha.getYear()));

        txtFechaEntrega.setClickable(true);
        txtFechaEntrega.setKeyListener(null);
        txtFechaEntrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate(v);
            }
        });
        btnAfirmativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoQueries.modificarActividad(actividad,
                        txtTitulo.getText().toString(),
                        fecha,
                        txtTipo.getSelectedItem().toString(),
                        categoria,
                        txtAsignatura.getText().toString());
                Intent intent = new Intent(dialog.getContext(), Agenda.class);
                if (categoria == dialog.getContext().getString(R.string.tipoExamen)) {
                    intent.putExtra("tab", 1);
                }
                dialog.getContext().startActivity(intent);
            }
        });

        btnNegativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        contenidoLista();
        if (this.categoria == dialog.getContext().getString(R.string.tipoExamen)) {
            switch (actividad.getTipo()) {
                case "Quiz":
                    txtTipo.setSelection(0);
                    break;
                case "Parcial":
                    txtTipo.setSelection(1);
                    break;
                case "Virtual":
                    txtTipo.setSelection(2);
                    break;
            }
        } else {
            switch (actividad.getTipo()) {
                case "Ensayo":
                    txtTipo.setSelection(0);
                    break;
                case "Guia":
                    txtTipo.setSelection(1);
                    break;
                case "Tarea":
                    txtTipo.setSelection(2);
                    break;
                case "otro":
                    txtTipo.setSelection(3);
                    break;
            }
        }
        dialog.show();
    }

    public void selectDate(View view) {
        final EditText editText = (EditText) view;
        final int day, month, year;

        final Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(dialog.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String stringDay, stringMonth;
                fecha = new Date(year, month, dayOfMonth);

                if (month < 9) {
                    stringMonth = "0" + (month + 1);
                } else {
                    stringMonth = String.valueOf((month + 1));
                }
                if (dayOfMonth < 10) {
                    stringDay = "0" + dayOfMonth;
                } else {
                    stringDay = String.valueOf(dayOfMonth);
                }
                editText.setText(stringDay + "/" + stringMonth + "/" + year);
            }

        }, year, month, day);
        datePickerDialog.show();
    }

    public void contenidoLista() {
        if (categoria == dialog.getContext().getString(R.string.tipoActividad)) {
            datos = new String[]{"Ensayo", "Guia", "Tarea", "otro"};
        } else {
            datos = new String[]{"Quiz", "Parcial", "Virtual"};
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(dialog.getContext(), android.R.layout.simple_list_item_1, datos);
        txtTipo.setAdapter(adapter);
    }
}
