package com.svalero.clara.bookingexamen.ListarHabitaciones;

import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Habitacion;
import java.util.ArrayList;

public interface ListarHabContrato {

    interface View {
        void successHab(ArrayList<Habitacion> listaHabitaciones);

        void errorHab(String message);
    }


    interface Presenter {
        void getHabitaciones(Context context, String fechaInicio, String fechaFin, String numPersonas, String hotel);

    }


    interface Model {

        void getHabitacionesWS(Context context, String fechaInicio, String fechaFin, String numPersonas, String hotel, OnListarHabitacionListener onListarHabitacionListener);

        interface OnListarHabitacionListener {
            void resolveHab(ArrayList<Habitacion> listaHabitaciones);

            void rejectHab(String error);
        }

    }
}
