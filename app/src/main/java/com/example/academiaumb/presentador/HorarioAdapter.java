package com.example.academiaumb.presentador;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.academiaumb.R;
import com.example.academiaumb.model.dao.Horario;
import com.example.academiaumb.modelo.DaoApp;

import java.util.List;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.ViewHolder> implements View.OnClickListener {

    private List<Horario> horarios;
    private View.OnClickListener listener;

    public HorarioAdapter() {
        horarios = DaoApp.getHorarioDao().loadAll();
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_horario, null, false);
        view.setOnClickListener(listener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        for (int j = 0; j < horarios.size(); j++) {
            if (horarios.get(j).getPosicion() == i) {
                viewHolder.tvNombreMateria.setText(horarios.get(j).getAsignatura().getNombre());
                viewHolder.tvHoraEntrada.setText(horarios.get(j).getHoraEntrada());
                viewHolder.tvHoraSalida.setText(horarios.get(j).getHoraSalida());
                viewHolder.tvSalon.setText(horarios.get(j).getSalon());
                int colorValue = Color.parseColor(horarios.get(j).getAsignatura().getColor());
                viewHolder.cvFondo.getBackground().setColorFilter(new PorterDuffColorFilter(colorValue, PorterDuff.Mode.SRC_IN));
                return;
            }
        }
    }

    @Override
    public int getItemCount() {
        return 42;
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

        TextView tvNombreMateria, tvHoraEntrada, tvHoraSalida, tvSalon;
        CardView cvFondo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreMateria = itemView.findViewById(R.id.tvNombreMateria);
            tvHoraEntrada = itemView.findViewById(R.id.tvHoraEntrada);
            tvHoraSalida = itemView.findViewById(R.id.tvHoraSalida);
            tvSalon = itemView.findViewById(R.id.tvSalon);
            cvFondo = itemView.findViewById(R.id.cvFondo);
        }
    }
}
