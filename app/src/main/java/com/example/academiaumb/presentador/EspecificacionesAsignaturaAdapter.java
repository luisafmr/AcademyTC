package com.example.academiaumb.presentador;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.academiaumb.R;
import com.example.academiaumb.model.dao.Asignatura;
import com.example.academiaumb.model.dao.Horario;
import com.example.academiaumb.modelo.DaoApp;
import com.example.academiaumb.modelo.DaoQueries;
import com.example.academiaumb.vista.EspecificacionesAsignatura;

import java.util.List;

public class EspecificacionesAsignaturaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Asignatura asignatura;

    public EspecificacionesAsignaturaAdapter(Long id) {
        asignatura = DaoApp.getAsignaturaDao().loadByRowId(id);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i) {
            case 0:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gui_agregar_asignatura, viewGroup, false);
                return new VhAgregarAsignatura(view);
            case 1:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gui_porcentajes_nota, viewGroup, false);
                return new VhPorcentajes(view);
            case 2:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gui_dias_materia, viewGroup, false);
                return new VhDiasMateria(view);
            case 3:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gui_agenda, viewGroup, false);
                return new VhAgenda(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (i) {
            case 0:
                final VhAgregarAsignatura vhAgregarAsignatura = (VhAgregarAsignatura) viewHolder;
                Context context = vhAgregarAsignatura.imgAsignatura.getContext();

                vhAgregarAsignatura.txtAsignaturas.setText(asignatura.getNombre());
                vhAgregarAsignatura.txtProfesor.setText(asignatura.getProfesor().getNombre());
                vhAgregarAsignatura.txtColor.setText(asignatura.getColor());
                llenarCampo(vhAgregarAsignatura.txtDetalles, asignatura.getDetalles());

                int colorValue = Color.parseColor(asignatura.getColor());

                Drawable drawable = context.getDrawable(R.drawable.ic_formulario_asignatura_24px);
                drawable.setColorFilter(new PorterDuffColorFilter(colorValue, PorterDuff.Mode.SRC_IN));
                vhAgregarAsignatura.imgAsignatura.setImageDrawable(drawable);

                drawable = context.getDrawable(R.drawable.ic_formulario_profesor_24px);
                drawable.setColorFilter(new PorterDuffColorFilter(colorValue, PorterDuff.Mode.SRC_IN));
                vhAgregarAsignatura.imgProfesor.setImageDrawable(drawable);


                drawable = context.getDrawable(R.drawable.ic_formulario_color_24px);
                drawable.setColorFilter(new PorterDuffColorFilter(colorValue, PorterDuff.Mode.SRC_IN));
                vhAgregarAsignatura.imgColor.setImageDrawable(drawable);

                drawable = context.getDrawable(R.drawable.ic_formulario_detalles_24px);
                drawable.setColorFilter(new PorterDuffColorFilter(colorValue, PorterDuff.Mode.SRC_IN));
                vhAgregarAsignatura.imgDetalles.setImageDrawable(drawable);

                vhAgregarAsignatura.btnGuardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DaoQueries.modificarAsignatura(vhAgregarAsignatura.txtAsignaturas.getText().toString(),
                                vhAgregarAsignatura.txtProfesor.getText().toString(),
                                vhAgregarAsignatura.txtColor.getText().toString(),
                                vhAgregarAsignatura.txtDetalles.getText().toString(),
                                asignatura);
                        Intent intent = new Intent(v.getContext(), EspecificacionesAsignatura.class);
                        intent.putExtra("id", (long) asignatura.getId());
                        v.getContext().startActivity(intent);
                    }
                });
                break;
            case 1:
                final VhPorcentajes vhPorcentajes = (VhPorcentajes) viewHolder;
                context = vhPorcentajes.txtNota1.getContext();
                llenarCampo(vhPorcentajes.txtPorcentaje1, String.valueOf(asignatura.getCorte().getCorte1()));
                llenarCampo(vhPorcentajes.txtPorcentaje2, String.valueOf(asignatura.getCorte().getCorte2()));
                llenarCampo(vhPorcentajes.txtPorcentaje3, String.valueOf(asignatura.getCorte().getCorte3()));
                llenarCampo(vhPorcentajes.txtNota1, String.valueOf(asignatura.getCorte().getNota1()));
                llenarCampo(vhPorcentajes.txtNota2, String.valueOf(asignatura.getCorte().getNota2()));
                llenarCampo(vhPorcentajes.txtNota3, String.valueOf(asignatura.getCorte().getNota3()));

                colorValue = Color.parseColor(asignatura.getColor());

                drawable = context.getDrawable(R.drawable.ic_formulario_corte_24px);
                drawable.setColorFilter(new PorterDuffColorFilter(colorValue, PorterDuff.Mode.SRC_IN));
                vhPorcentajes.imgCorte1.setImageDrawable(drawable);
                vhPorcentajes.imgCorte2.setImageDrawable(drawable);
                vhPorcentajes.imgCorte3.setImageDrawable(drawable);

                drawable = context.getDrawable(R.drawable.ic_formulario_nota_24px);
                drawable.setColorFilter(new PorterDuffColorFilter(colorValue, PorterDuff.Mode.SRC_IN));
                vhPorcentajes.imgNota1.setImageDrawable(drawable);
                vhPorcentajes.imgNota2.setImageDrawable(drawable);
                vhPorcentajes.imgNota3.setImageDrawable(drawable);



                vhPorcentajes.btnPorcentajes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DaoQueries.modificarCortes(asignatura.getId(), new int[]{
                                !vhPorcentajes.txtPorcentaje1.getText().toString().isEmpty()?Integer.parseInt(vhPorcentajes.txtPorcentaje1.getText().toString()):0,
                                !vhPorcentajes.txtPorcentaje2.getText().toString().isEmpty()?Integer.parseInt(vhPorcentajes.txtPorcentaje2.getText().toString()):0,
                                !vhPorcentajes.txtPorcentaje3.getText().toString().isEmpty()?Integer.parseInt(vhPorcentajes.txtPorcentaje3.getText().toString()):0,
                                !vhPorcentajes.txtNota1.getText().toString().isEmpty()?Integer.parseInt(vhPorcentajes.txtNota1.getText().toString()):0,
                                !vhPorcentajes.txtNota2.getText().toString().isEmpty()?Integer.parseInt(vhPorcentajes.txtNota2.getText().toString()):0,
                                !vhPorcentajes.txtNota3.getText().toString().isEmpty()?Integer.parseInt(vhPorcentajes.txtNota3.getText().toString()):0,
                        });
                        Intent intent = new Intent(v.getContext(), EspecificacionesAsignatura.class);
                        intent.putExtra("id", (long) asignatura.getId());
                        v.getContext().startActivity(intent);
                    }
                });
                break;
            case 2:
                VhDiasMateria vhDiasMateria = (VhDiasMateria) viewHolder;
                List<Horario> horarios = asignatura.getHorarios();
                context = vhDiasMateria.tvLunes.getContext();

                colorValue = Color.parseColor(asignatura.getColor());
                drawable = context.getDrawable(R.drawable.valor_apagado);
                drawable.setColorFilter(new PorterDuffColorFilter(colorValue, PorterDuff.Mode.SRC_IN));

                if (horarios != null && !horarios.equals(null)) {
                    for (int y = 0; y < horarios.size(); y++) {

                        if (horarios.get(y).getDia() != null){

                            switch (horarios.get(y).getDia()) {
                                case "1":
                                      vhDiasMateria.tvLunes.setBackground(drawable);
                                    break;
                                case "2":
                                    vhDiasMateria.tvMartes.setBackground(drawable);
                                    break;
                                case "3":
                                      vhDiasMateria.tvMiercoles.setBackground(drawable);
                                    break;
                                case "4":
                                     vhDiasMateria.tvJueves.setBackground(drawable);
                                    break;
                                case "5":
                                     vhDiasMateria.tvViernes.setBackground(drawable);
                                    break;
                                case "6":
                                     vhDiasMateria.tvSabado.setBackground(drawable);
                                    break;
                                case "7":
                                      vhDiasMateria.tvDomingo.setBackground(drawable);
                                    break;
                            }
                        }
                    }
                }

                vhDiasMateria.btnMostrarMas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
            case 3:
                VhAgenda vhAgenda = (VhAgenda) viewHolder;
                break;
        }
    }

    public void llenarCampo(TextView campo, String valor) {
        if (valor == null || valor == "null") {
            campo.setText("");
        } else {
            campo.setText(valor);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class VhAgenda extends RecyclerView.ViewHolder {
        public VhAgenda(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class VhAgregarAsignatura extends RecyclerView.ViewHolder {

        TextView txtAsignaturas, txtProfesor, txtColor, txtDetalles;
        Button btnGuardar;
        ImageView imgAsignatura, imgProfesor, imgColor, imgDetalles;

        public VhAgregarAsignatura(@NonNull View itemView) {
            super(itemView);
            txtAsignaturas = itemView.findViewById(R.id.txtAsignaturas);
            txtProfesor = itemView.findViewById(R.id.txtProfesor);
            txtColor = itemView.findViewById(R.id.txtColor);
            txtDetalles = itemView.findViewById(R.id.txtDetalles);
            btnGuardar = itemView.findViewById(R.id.btnGuardar);
            imgAsignatura = itemView.findViewById(R.id.imgAsigntarura);
            imgProfesor = itemView.findViewById(R.id.imgProfesor);
            imgColor = itemView.findViewById(R.id.imgColor);
            imgDetalles = itemView.findViewById(R.id.imgDetalles);
        }


    }

    public class VhDiasMateria extends RecyclerView.ViewHolder {

        TextView tvLunes, tvMartes, tvMiercoles, tvJueves, tvViernes, tvSabado, tvDomingo;
        Button btnMostrarMas;

        public VhDiasMateria(@NonNull View itemView) {
            super(itemView);
            tvLunes = itemView.findViewById(R.id.tvLunes);
            tvMartes = itemView.findViewById(R.id.tvMartes);
            tvMiercoles = itemView.findViewById(R.id.tvMiercoles);
            tvJueves = itemView.findViewById(R.id.tvJueves);
            tvViernes = itemView.findViewById(R.id.tvViernes);
            tvSabado = itemView.findViewById(R.id.tvSabado);
            tvDomingo = itemView.findViewById(R.id.tvDomingo);
            btnMostrarMas = itemView.findViewById(R.id.btnMostrarMas);
        }
    }

    public class VhPorcentajes extends RecyclerView.ViewHolder {

        TextView txtPorcentaje1, txtPorcentaje2, txtPorcentaje3, txtNota1, txtNota2, txtNota3;
        Button btnPorcentajes;
        ImageView imgCorte1, imgCorte2, imgCorte3, imgNota1, imgNota2, imgNota3;

        public VhPorcentajes(@NonNull View itemView) {
            super(itemView);
            txtPorcentaje1 = itemView.findViewById(R.id.txtPorcentaje1);
            txtPorcentaje2 = itemView.findViewById(R.id.txtPorcentaje2);
            txtPorcentaje3 = itemView.findViewById(R.id.txtPorcentaje3);
            txtNota1 = itemView.findViewById(R.id.txtNota1);
            txtNota2 = itemView.findViewById(R.id.txtNota2);
            txtNota3 = itemView.findViewById(R.id.txtNota3);
            btnPorcentajes = itemView.findViewById(R.id.btnPorcentajes);
            imgCorte1 = itemView.findViewById(R.id.imgCorte1);
            imgCorte2 = itemView.findViewById(R.id.imgCorte2);
            imgCorte3 = itemView.findViewById(R.id.imgCorte3);
            imgNota1 = itemView.findViewById(R.id.imgNota1);
            imgNota2 = itemView.findViewById(R.id.imgNota2);
            imgNota3 = itemView.findViewById(R.id.imgNota3);
        }
    }

}
