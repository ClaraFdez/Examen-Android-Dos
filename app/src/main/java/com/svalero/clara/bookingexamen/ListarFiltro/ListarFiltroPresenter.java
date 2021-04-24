package com.svalero.clara.bookingexamen.ListarFiltro;

import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Hotel;
import java.util.ArrayList;

public class ListarFiltroPresenter implements ListarFiltroContrato.Presenter{

    private ListarFiltroContrato.View vista;
    private ListarFiltroModel model;

    public ListarFiltroPresenter(ListarFiltroContrato.View vista){
        this.vista = vista;
        this.model = new ListarFiltroModel();
    }

    public ListarFiltroPresenter(){
    }

    @Override
    public void getHotelesFiltro(Context context, String filtroDado, String ciudadPasada) {

        this.model.getHotelesFiltroWS(context, filtroDado, ciudadPasada, new ListarFiltroContrato.Model.OnListarFiltroListener() {
            @Override
            public void resolve(ArrayList<Hotel> listaHoteles) {
                System.out.println(("presenter: dentro del resolve"+listaHoteles));
                vista.success(listaHoteles);
            }

            @Override
            public void reject(String error) {
                error = "Hoteles no encontrados";
            }
        });

    }
}
