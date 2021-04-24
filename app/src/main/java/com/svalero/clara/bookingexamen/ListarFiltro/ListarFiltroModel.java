package com.svalero.clara.bookingexamen.ListarFiltro;

import android.content.Context;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.Retrofit.ApiCliente;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListarFiltroModel implements ListarFiltroContrato.Model {

    private ListarFiltroContrato.Model.OnListarFiltroListener onListarFiltroListener;
    private ArrayList<Hotel> listaHoteles;
    private String filtroDado;
    private String ciudadPasada;

    @Override
    public void getHotelesFiltroWS(Context context, String filtroDado, String ciudadPasada, OnListarFiltroListener onListarFiltroListener) {
        this.onListarFiltroListener = onListarFiltroListener;
        this.filtroDado = filtroDado;
        this.ciudadPasada = ciudadPasada;
        String param = "HOTEL."+ filtroDado + "." + ciudadPasada;

        ApiCliente apiCliente = new ApiCliente(context);
        final Call<ArrayList<Hotel>> peticion = apiCliente.getFiltro(param);
        peticion.enqueue(new Callback<ArrayList<Hotel>>() {
            @Override
            public void onResponse(Call<ArrayList<Hotel>> call, Response<ArrayList<Hotel>> response) {
                if(response.isSuccessful()){
                    onListarFiltroListener.resolve(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Hotel>> call, Throwable t) {
                t.printStackTrace();
                onListarFiltroListener.reject(t.getLocalizedMessage());
            }
        });

    }

}

