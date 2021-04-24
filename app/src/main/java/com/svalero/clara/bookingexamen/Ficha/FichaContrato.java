package com.svalero.clara.bookingexamen.Ficha;

import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Habitacion;
import com.svalero.clara.bookingexamen.Beans.Hotel;

import java.util.ArrayList;
import java.util.Date;

public interface FichaContrato {

    interface View {
        void successHotel(ArrayList<Hotel> listaHoteles);
        void errorHotel(String message);
    }


    interface Presenter {
        void getHotelFicha(Context context, String hotelPasado);

    }


    interface Model {

        void getFichaHotelWS(Context context, String hotelPasado, OnFichaListener onFichaListener);

        interface OnFichaListener {
            void resolveHotel(ArrayList<Hotel> listaHoteles);
            void rejectHotel(String error);
        }

    }

}
