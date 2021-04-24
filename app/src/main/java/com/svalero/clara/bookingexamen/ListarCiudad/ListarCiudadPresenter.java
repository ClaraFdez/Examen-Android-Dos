package com.svalero.clara.bookingexamen.ListarCiudad;


import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Hotel;
import java.util.ArrayList;

public class ListarCiudadPresenter implements ListarCiudadContrato.Presenter {

    private ListarCiudadContrato.View vista;
    private ListarCiudadModel model;

    public ListarCiudadPresenter(ListarCiudadContrato.View vista){
        this.vista = vista;
        this.model = new ListarCiudadModel();
    }

    public ListarCiudadPresenter(){
    }


    @Override
    public void getHotelesDestino(Context context, String ciudad) {
        this.model.getHotelesDestinoWS(context, ciudad, new ListarCiudadContrato.Model.OnListarCiudadListener() {
            @Override
            public void resolveCiudad(ArrayList<Hotel> listaHoteles) {
                System.out.println(("presenterCiudad: dentro del resolve"+listaHoteles));
                vista.successCiudad(listaHoteles);
            }

            @Override
            public void rejectCiudad(String error) {
                error = "Hoteles no encontrados";
            }
        });
    }
}
