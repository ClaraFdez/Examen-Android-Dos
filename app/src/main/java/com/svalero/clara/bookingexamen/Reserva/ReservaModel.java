package com.svalero.clara.bookingexamen.Reserva;

import android.content.Context;
import com.svalero.clara.bookingexamen.Retrofit.ApiCliente;
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

        String param = "RESERVA.RESERVAR."+idUsuario+"."+fechaInicio+"."+fechaFin+ "."+idHabitacion;

        ApiCliente apiCliente = new ApiCliente(context);
        final Call<ResponseBody> peticion = apiCliente.addReserva(param);
        peticion.enqueue(new Callback<ResponseBody>() {
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
