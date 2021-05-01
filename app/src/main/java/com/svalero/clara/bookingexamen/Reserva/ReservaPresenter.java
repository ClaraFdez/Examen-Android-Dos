package com.svalero.clara.bookingexamen.Reserva;

import android.content.Context;


public class ReservaPresenter implements ReservaContrato.Presenter{

    private ReservaContrato.View vista;
    private ReservaModel model;

    public ReservaPresenter(ReservaContrato.View vista){
        this.vista = vista;
        this.model = new ReservaModel();
    }

    public ReservaPresenter(){

    }

    @Override
    public void setReserva(Context context, String idUsuario, String fechaInicio, String fechaFin, String idHabitacion) {
        this.model.setReservaWS(context, idUsuario, fechaInicio, fechaFin, idHabitacion, new ReservaContrato.Model.OnReservaListener() {
            @Override
            public void resolveReserva(String success) {
                vista.successReserva(success);
            }

            @Override
            public void rejectReserva(String error) {
                vista.errorReserva("No se ha podido guardar con éxito");
            }
        });
    }


}
