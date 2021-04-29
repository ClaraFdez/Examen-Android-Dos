package com.svalero.clara.bookingexamen.ListarHabitaciones;

import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Habitacion;
import java.util.ArrayList;

public class ListarHabPresenter implements ListarHabContrato.Presenter{

    ListarHabContrato.View vista;
    ListarHabModel model;

    public ListarHabPresenter(ListarHabContrato.View vista){
        this.vista = vista;
        this.model = new ListarHabModel();
    }

    public ListarHabPresenter(){}


    @Override
    public void getHabitaciones(Context context, String fechaInicio, String fechaFin, String numPersonas, String nombre) {
        this.model.getHabitacionesWS(context, fechaInicio, fechaFin, numPersonas, nombre, new ListarHabContrato.Model.OnListarHabitacionListener() {
            @Override
            public void resolveHab(ArrayList<Habitacion> listaHabitaciones) {
                System.out.println("en listarhabpresenter, resolvehab, lo que viene de vuelta: "+ listaHabitaciones);//-------------------
                vista.successHab(listaHabitaciones);
            }

            @Override
            public void rejectHab(String error) {
                error = "Habitaciones no encontradas";
            }
        });
    }
}
