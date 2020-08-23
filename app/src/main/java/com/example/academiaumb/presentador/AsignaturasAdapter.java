package com.example.academiaumb.presentador;


import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.academiaumb.R;
import com.example.academiaumb.model.dao.Asignatura;
import com.example.academiaumb.modelo.DaoApp;

import java.util.List;

public class AsignaturasAdapter extends RecyclerView.Adapter<AsignaturasAdapter.ViewHolder> implements View.OnClickListener{

    private final List<Asignatura> asignaturas;
    private View.OnClickListener listener;

    public AsignaturasAdapter() {
        asignaturas = DaoApp.getAsignaturaDao().loadAll();
    }

    public Long getIdAsignatura(int posicion){
        return asignaturas.get(posicion).getId();
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_asignaturas, viewGroup , false);
        view.setOnClickListener(listener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvNombreAsignatura.setText(asignaturas.get(i).getNombre());
        viewHolder.viewColor.setBackgroundColor(Color.parseColor(asignaturas.get(i).getColor()));
    }

    @Override
    public int getItemCount() {
        return asignaturas.size();
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

        final TextView tvNombreAsignatura;
        final View viewColor;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreAsignatura = itemView.findViewById(R.id.tvNombreAsignatura);
            viewColor = itemView.findViewById(R.id.viewColor);
        }
    }
}