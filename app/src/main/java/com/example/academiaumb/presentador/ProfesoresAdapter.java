package com.example.academiaumb.presentador;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.academiaumb.R;
import com.example.academiaumb.model.dao.Profesor;
import com.example.academiaumb.modelo.DaoApp;

import java.util.List;

public class ProfesoresAdapter extends RecyclerView.Adapter<ProfesoresAdapter.ViewHolder> implements View.OnClickListener {

    List<Profesor> profesores;
    private View.OnClickListener listener;

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public ProfesoresAdapter() {
        profesores = DaoApp.getProfesorDao().loadAll();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_profesores, viewGroup, false);
        view.setOnClickListener(listener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvNombre.setText(profesores.get(i).getNombre());
        rellenar(viewHolder.tvCorreo, profesores.get(i).getCorreo());
        rellenar(viewHolder.tvTelefono, profesores.get(i).getTelefono());
    }

    @Override
    public int getItemCount() {
        return profesores.size();
    }

    public void rellenar(TextView elemento, String valor) {
        switch (elemento.getId()) {
            case R.id.tvCorreo:
                if (valor == null || valor.equals(null)) {
                    elemento.setText(elemento.getContext().getString(R.string.correo));
                }
                elemento.setText(elemento.getContext().getString(R.string.correo) + valor);
                break;
            case R.id.tvTelefono:
                if (valor == null || valor.equals(null)) {
                    elemento.setText(elemento.getContext().getString(R.string.telefono));
                }
                elemento.setText(elemento.getContext().getString(R.string.telefono) + valor);
                break;
        }

    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (v != null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombre, tvCorreo, tvTelefono;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvCorreo = itemView.findViewById(R.id.tvCorreo);
            tvTelefono = itemView.findViewById(R.id.tvTelefono);
        }


    }
}
