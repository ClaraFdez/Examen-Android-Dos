package com.svalero.clara.bookingexamen.ListarCiudad;

import android.content.Context;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.Retrofit.ApiCliente;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListarCiudadModel implements ListarCiudadContrato.Model{

    private ListarCiudadContrato.Model.OnListarCiudadListener onListarCiudadListener;
    private ArrayList<Hotel> listaHoteles;
    private String ciudad;

    @Override
    public void getHotelesDestinoWS(Context context, String ciudad, OnListarCiudadListener onListarCiudadListener) {
        this.onListarCiudadListener = onListarCiudadListener;
        this.ciudad = ciudad;
        String param = "HOTEL.FIND_DESTINO."+ciudad;

        ApiCliente apiCliente = new ApiCliente(context);
        final Call<ArrayList<Hotel>> peticion = apiCliente.getCiudad(param);
        peticion.enqueue(new Callback<ArrayList<Hotel>>() {
            @Override
            public void onResponse(Call<ArrayList<Hotel>> call, Response<ArrayList<Hotel>> response) {
                if(response.isSuccessful()){
                    onListarCiudadListener.resolveCiudad(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Hotel>> call, Throwable t) {
                t.printStackTrace();
                onListarCiudadListener.rejectCiudad(t.getLocalizedMessage());
            }
        });

    }

}
