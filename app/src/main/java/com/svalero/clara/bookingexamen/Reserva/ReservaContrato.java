package com.svalero.clara.bookingexamen.Reserva;

import android.content.Context;


public interface ReservaContrato {

    interface View {
        void successReserva(String success);

        void errorReserva(String mensaje);
    }


    interface Presenter {
        void setReserva(Context context, String idUsuario, String fechaInicio, String fechaFin, String idHabitacion);

    }


    interface Model {

        void setReservaWS(Context context, String idUsuario, String fechaInicio, String fechaFin, String idHabitacion, ReservaContrato.Model.OnReservaListener onReservaListener);

        interface OnReservaListener {
            void resolveReserva(String success);

            void rejectReserva(String error);
        }

    }

}
