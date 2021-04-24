package com.svalero.clara.bookingexamen.ListarHabitaciones;

import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Habitacion;
import com.svalero.clara.bookingexamen.Retrofit.ApiCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarHabModel implements ListarHabContrato.Model{

    private OnListarHabitacionListener onListarHabitacionListener;
    private ArrayList<Habitacion> listaHabitaciones;

    private String fechaInicio;
    private String fechaFin;
    private String numPersonas;
    private String nombre;

    @Override
    public void getHabitacionesWS(Context context, String fechaInicio, String fechaFin, String numPersonas, String nombre, OnListarHabitacionListener onListarHabitacionListener) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numPersonas = numPersonas;
        this.nombre = nombre;
        this.onListarHabitacionListener = onListarHabitacionListener;

        String param = "HABITACION.FIND_ALL."+fechaInicio+"."+fechaFin+"."+nombre+"."+numPersonas;

        ApiCliente apiCliente = new ApiCliente(context);
        final Call<ArrayList<Habitacion>> peticion = apiCliente.getHabitacion(param);
        peticion.enqueue(new Callback<ArrayList<Habitacion>>() {
            @Override
            public void onResponse(Call<ArrayList<Habitacion>> call, Response<ArrayList<Habitacion>> response) {
                if(response.isSuccessful()){
                    onListarHabitacionListener.resolveHab(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Habitacion>> call, Throwable t) {
                t.printStackTrace();
                onListarHabitacionListener.rejectHab(t.getLocalizedMessage());
            }
        });

    }

}
