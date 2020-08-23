package com.example.academiaumb.presentador;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.academiaumb.R;
import com.example.academiaumb.model.dao.Anexo;
import com.example.academiaumb.modelo.DaoQueries;

import java.util.List;

public class AnexosAdapter extends RecyclerView.Adapter<AnexosAdapter.ViewHolder> {

    List<Anexo> anexos;
    List<AnotacionesAdapter> anotacionesAdapters;
    int colorValue;

    public AnexosAdapter(Long id) {
        anexos = DaoQueries.getAnexosByAsignaturaId(id);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_anexos, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvTitulo.setText(anexos.get(i).getTitulo());
        AnotacionesAdapter anotacionesAdapter = new AnotacionesAdapter(anexos.get(i).getId());
        colorValue = Color.parseColor(anexos.get(i).getAsignatura().getColor());
        viewHolder.tvTitulo.setTextColor(colorValue);
        //anotacionesAdapters.add(anotacionesAdapter);
        viewHolder.rvAnexos.setAdapter(anotacionesAdapter);
    }

    @Override
    public int getItemCount() {
        return anexos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitulo;
        RecyclerView rvAnexos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            rvAnexos = itemView.findViewById(R.id.rvAnexos);
            rvAnexos.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        }
    }
}
