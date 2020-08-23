package com.example.academiaumb.presentador;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.academiaumb.R;
import com.example.academiaumb.model.dao.Actividad;
import com.example.academiaumb.modelo.DaoApp;
import com.example.academiaumb.modelo.DaoQueries;

import java.util.Date;
import java.util.List;

public class ActividadesAdapter extends RecyclerView.Adapter<ActividadesAdapter.ViewHolder> implements View.OnClickListener{

    List<Actividad> actividades;
    private View.OnClickListener listener;

    public ActividadesAdapter(String categoria) {
        actividades = DaoQueries.getActividadesByCategoria(categoria);
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_actividades, viewGroup, false);
        view.setOnClickListener(listener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Date fecha = actividades.get(i).getFechaEntrega();
        viewHolder.tvNombreAsignatura.setText(actividades.get(i).getAsignatura().getNombre());
        viewHolder.tvFechaEntrega.setText(String.valueOf(fecha.getDate()) + "/" + String.valueOf(fecha.getMonth() + 1) + "/" + String.valueOf(fecha.getYear()));

        int colorValue = Color.parseColor(actividades.get(i).getAsignatura().getColor());
        Drawable drawable = viewHolder.imgTipo.getContext().getDrawable(R.drawable.redondeo);
        drawable.setColorFilter(new PorterDuffColorFilter(colorValue, PorterDuff.Mode.SRC_IN));
        viewHolder.imgTipo.setBackground(drawable);
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (v != null) {
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreAsignatura, tvFechaEntrega;
        ImageView imgTipo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreAsignatura = itemView.findViewById(R.id.tvNombreAsignatura);
            tvFechaEntrega = itemView.findViewById(R.id.tvFechaEntrega);
            imgTipo = itemView.findViewById(R.id.imgTipo);
        }
    }
}
