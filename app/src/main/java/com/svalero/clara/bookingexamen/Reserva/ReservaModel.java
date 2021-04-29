package com.svalero.clara.bookingexamen.Reserva;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.svalero.clara.bookingexamen.Beans.Habitacion;
import com.svalero.clara.bookingexamen.Beans.Reserva;
import com.svalero.clara.bookingexamen.Ficha.FichaVista;
import com.svalero.clara.bookingexamen.Retrofit.ApiCliente;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ReservaModel implements ReservaContrato.Model{

    String idUsuario;
    String fechaInicio;
    String fechaFin;
    String idHabitacion;

    @Override
    public void setReservaWS(Context context, String idUsuario, String fechaInicio, String fechaFin, String idHabitacion, OnReservaListener onReservaListener) {
        this.idUsuario = idUsuario;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.idHabitacion = idHabitacion;

        String param = "RESERVA.RESERVAR."+idUsuario+"."+fechaInicio+"."+fechaFin;

        ApiCliente apiCliente = new ApiCliente(context);
        final Call<ArrayList<Reserva>> peticion = apiCliente.addReserva(param);
        peticion.enqueue(new Callback<ArrayList<Reserva>>() {
            @Override
            public void onResponse(Call<ArrayList<Reserva>> call, Response<ArrayList<Reserva>> response) {
                if(response.isSuccessful()){
                    String idReserva = Integer.toString(response.body().get(0).getIdReserva());

                    String param1 = "RESERVA.SOBRE."+idReserva+"."+idHabitacion;

                    ApiCliente apiCliente1 = new ApiCliente(context);
                    final Call<ResponseBody> peticion1 = apiCliente1.addSobre(param1);
                    peticion1.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if(response.isSuccessful()){
                                onReservaListener.resolveReserva("Guardado con éxito");
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            t.printStackTrace();
                           onReservaListener.rejectReserva(t.getLocalizedMessage());
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Reserva>> call, Throwable t) {
                t.printStackTrace();
                onReservaListener.rejectReserva(t.getLocalizedMessage());
            }
        });

    }


}
