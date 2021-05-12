package com.svalero.clara.bookingexamen.Ficha;

import android.content.Context;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import java.util.ArrayList;


public class FichaPresenter implements FichaContrato.Presenter{

    private FichaContrato.View vista;
    private FichaModel model;

    public FichaPresenter(FichaContrato.View vista){
        this.vista = vista;
        this.model = new FichaModel();
    }

    public FichaPresenter(){
    }


    @Override
    public void getHotelFicha(Context context, String hotelPasado) {
        this.model.getFichaHotelWS(context, hotelPasado, new FichaContrato.Model.OnFichaListener() {


            @Override
            public void resolveHotel(ArrayList<Hotel> listaHoteles) {
                vista.successHotel(listaHoteles);
            }



            @Override
            public void rejectHotel(String error) {
                error = "Error";
            }
        });
    }



}
