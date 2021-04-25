package com.svalero.clara.bookingexamen.ListarTodo;

import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.ListarHabitaciones.ListarHabContrato;

import java.util.ArrayList;
import java.util.List;

public interface ListarTodoContrato {

    interface View {
        void success(ArrayList<Hotel> listaHoteles);

        void error(String message);
    }


    interface Presenter {
        void getHoteles(Context context);
        //void getHoteles();

    }


    interface Model {

        //void getListarTodoWS(OnListarTodoListener onListarTodoListener);
        void getListarTodoWS(Context context, OnListarTodoListener onListarTodoListener);

        interface OnListarTodoListener {
            void resolve(ArrayList<Hotel> listaHoteles);

            void reject(String error);
        }

    }

}