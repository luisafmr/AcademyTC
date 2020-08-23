package com.example.academiaumb.presentador;

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
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.academiaumb.R;
import com.example.academiaumb.model.dao.Anotacion;
import com.example.academiaumb.modelo.DaoQueries;
import com.example.academiaumb.vista.VisorImagen;

import java.util.List;

public class AnotacionesAdapter extends RecyclerView.Adapter<AnotacionesAdapter.ViewHolder> {

    List<Anotacion> anotaciones;
    int colorValue;

    public AnotacionesAdapter(long id) {
        anotaciones = DaoQueries.getAnotacionesByAnexoId(id);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_anotaciones, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvContenido.setText(anotaciones.get(i).getDetalle());
        viewHolder.cargarUri(anotaciones.get(i).getUrlImagen());

        colorValue = Color.parseColor(anotaciones.get(i).getAnexo().getAsignatura().getColor());
        Drawable prendido = viewHolder.btnImagen.getContext().getDrawable(R.drawable.redondeo);
        Drawable apagado = viewHolder.btnImagen.getContext().getDrawable(R.drawable.valor_apagado);
        prendido.setColorFilter(new PorterDuffColorFilter(colorValue, PorterDuff.Mode.SRC_IN));

        if (anotaciones.get(i).getUrlImagen() == null || anotaciones.get(i).getUrlImagen().isEmpty()) {
            viewHolder.btnImagen.setBackground(apagado);
            viewHolder.btnImagen.setOnClickListener(null);
        } else {
            viewHolder.btnImagen.setBackground(prendido);
        }
        if (anotaciones.get(i).getUrlVoz() == null || anotaciones.get(i).getUrlVoz().isEmpty()) {
            viewHolder.btnAudio.setBackground(apagado);
            viewHolder.btnAudio.setOnClickListener(null);
        } else {
            viewHolder.btnAudio.setBackground(prendido);
        }

    }

    @Override
    public int getItemCount() {
        return anotaciones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvContenido;
        ImageButton btnImagen, btnAudio;
        String imagenUri;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvContenido = itemView.findViewById(R.id.tvContenido);
            btnImagen = itemView.findViewById(R.id.btnImagen);
            btnAudio = itemView.findViewById(R.id.btnAudio);

            btnImagen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), VisorImagen.class);
                    intent.putExtra("uri", imagenUri);
                    btnImagen.getContext().startActivity(intent);
                }
            });
        }

        public void cargarUri(String uri) {
            imagenUri = uri;
        }
    }
}
