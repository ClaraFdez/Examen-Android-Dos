package com.svalero.clara.bookingexamen.Ficha;

import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.Retrofit.ApiCliente;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FichaModel implements FichaContrato.Model{

    private OnFichaListener onFichaListener;
    private ArrayList<Hotel> listaHoteles;

    @Override
    public void getFichaHotelWS(Context context, String nombrePasado, OnFichaListener onFichaListener) {
        this.onFichaListener = onFichaListener;
        String param = "HOTEL.FICHA." + nombrePasado;
        ApiCliente apiCliente = new ApiCliente(context);
        final Call<ArrayList<Hotel>> peticion = apiCliente.getFicha(param);
        peticion.enqueue(new Callback<ArrayList<Hotel>>() {
            @Override
            public void onResponse(Call<ArrayList<Hotel>> call, Response<ArrayList<Hotel>> response) {
                if(response.isSuccessful()){
                    onFichaListener.resolveHotel(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Hotel>> call, Throwable t) {
                t.printStackTrace();
                onFichaListener.rejectHotel(t.getLocalizedMessage());
            }
        });

    }

}
