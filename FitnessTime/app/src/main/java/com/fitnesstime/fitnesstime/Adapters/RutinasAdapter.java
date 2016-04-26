package com.fitnesstime.fitnesstime.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fitnesstime.fitnesstime.Activities.ActivityPrincipal;
import com.fitnesstime.fitnesstime.Activities.ActivityPrincipalRutina;
import com.fitnesstime.fitnesstime.Activities.ActivityVerRutinas;
import com.fitnesstime.fitnesstime.Flujos.FlujoRutinas;
import com.fitnesstime.fitnesstime.Dominio.Rutina;
import com.fitnesstime.fitnesstime.R;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by julian on 06/03/16.
 */
public class RutinasAdapter extends
        RecyclerView.Adapter<RutinasAdapter.ViewHolder> {

    private List<Rutina> rutinas;
    public Activity activity;
    private Context context;
    protected int posicionActual= 0;

    public RutinasAdapter(List<Rutina> rutinas,  Activity activity, Context context) {
        this.rutinas = rutinas;
        this.activity = activity;
        this.context = context;
    }

    @Override
    public RutinasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_rutina, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {

        this.posicionActual = position;

        final Rutina rutina = rutinas.get(position);

        viewHolder.descripcion.setText(rutina.getDescripcion());
        viewHolder.rangoFecha.setText(rutina.getInicio() + " - " + rutina.getFin());
        if(rutina.getEsDeCarga())
            viewHolder.textoInicial.setText("C");
        else
            viewHolder.textoInicial.setText("A");
    }

    @Override
    public int getItemCount() {
        return rutinas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView descripcion;
        public TextView rangoFecha;
        public TextView textoInicial;
        public CardView card;

        public ViewHolder(View itemView) {
            super(itemView);
            card = (CardView)itemView.findViewById(R.id.card);
            card.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return false;
                }
            });
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FlujoRutinas flujo = new FlujoRutinas();
                    final Rutina rutina = rutinas.get(getAdapterPosition());
                    flujo.setEntidad(rutina);
                    ((ActivityPrincipal) activity).setFlujo(flujo);
                    ((ActivityPrincipal) activity).finish();
                    ((ActivityPrincipal) activity).startActivity(new Intent(((ActivityPrincipal) activity), ActivityVerRutinas.class));
                }
            });
            descripcion = (TextView) itemView.findViewById(R.id.descripcion_rutina);
            rangoFecha = (TextView) itemView.findViewById(R.id.rango_fecha_rutina);
            textoInicial = (TextView)itemView.findViewById(R.id.texto_inicial_carga_aerobico);
        }
    }

}
