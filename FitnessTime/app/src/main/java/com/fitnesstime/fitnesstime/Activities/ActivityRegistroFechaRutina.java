package com.fitnesstime.fitnesstime.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.fitnesstime.fitnesstime.Modelo.Rutina;
import com.fitnesstime.fitnesstime.R;

import java.util.Calendar;

public class ActivityRegistroFechaRutina extends ActivityFlujo {

    private Button siguiente;

    private DatePicker fechaInicio;
    private int yearInicio;
    private int monthInicio;
    private int dayInicio;

    private DatePicker fechaFin;
    private int yearFin;
    private int monthFin;
    private int dayFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_fecha_rutina);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Rutinas");

        iniciarBotones();
    }

    @Override
    public void guardarDatos() {
        Rutina entidadRegistro = (Rutina)flujo.getEntidad();
        entidadRegistro.setFechaInicio(dayInicio + "/" + monthInicio + "/" + yearInicio);
        entidadRegistro.setFechaFin(dayFin + "/" + monthFin + "/" + yearFin);
    }

    @Override
    public void cargarDatos() {
        Rutina entidadRegistro = (Rutina)flujo.getEntidad();
        setearDiasDeInicioYFin(entidadRegistro.getFechaInicio(), entidadRegistro.getFechaFin());
    }

    @Override
    public boolean tieneSiguiente() {
        return true;
    }

    @Override
    public boolean tieneAnterior() {
        return true;
    }

    @Override
    public boolean esElPrimero()
    {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                activityAnterior();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Inicia las acciones de los botones del activity.
    private void iniciarBotones()
    {
        siguiente = (Button)findViewById(R.id.boton_siguiente_fecha_rutina);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
                activitySigiente();
            }
        });
    }

    private void setearDiasDeInicioYFin(String fechaInicio, String fechaFin)
    {
        if(fechaInicio == null)
        {
            final Calendar c = Calendar.getInstance();
            yearInicio = c.get(Calendar.YEAR);
            monthInicio = c.get(Calendar.MONTH);
            dayInicio = c.get(Calendar.DAY_OF_MONTH);
        }
        else{
            String[] splitFecha = fechaInicio.split("/");
            yearInicio = Integer.parseInt(splitFecha[2]);
            monthInicio = Integer.parseInt(splitFecha[1]);
            dayInicio = Integer.parseInt(splitFecha[0]);
        }

        if(fechaFin == null)
        {
            final Calendar c = Calendar.getInstance();
            yearFin = c.get(Calendar.YEAR);
            monthFin = c.get(Calendar.MONTH);
            dayFin = c.get(Calendar.DAY_OF_MONTH);
        }
        else{
            String[] splitFecha = fechaFin.split("/");
            yearFin = Integer.parseInt(splitFecha[2]);
            monthFin = Integer.parseInt(splitFecha[1]);
            dayFin = Integer.parseInt(splitFecha[0]);
        }
        iniciarDatePickers();
    }

    private void iniciarDatePickers()
    {
        fechaInicio = (DatePicker) findViewById(R.id.fecha_inicio_rutina);
        fechaInicio.init(yearInicio, monthInicio, dayInicio, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int año, int mes, int dia) {
                yearInicio = año;
                monthInicio = mes;
                dayInicio = dia;
            }
        });

        fechaFin = (DatePicker) findViewById(R.id.fecha_fin_rutina);
        fechaFin.init(yearFin, monthFin, dayFin, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int año, int mes, int dia) {
                yearFin = año;
                monthFin = mes;
                dayFin = dia;
            }
        });
    }
}