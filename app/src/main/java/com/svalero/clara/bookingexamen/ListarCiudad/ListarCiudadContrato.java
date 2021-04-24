package com.svalero.clara.bookingexamen.ListarCiudad;

import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Hotel;
import java.util.ArrayList;

public interface ListarCiudadContrato {

    interface View {
        void successCiudad(ArrayList<Hotel> listaHoteles);

        void errorCiudad(String message);
    }


    interface Presenter {
        void getHotelesDestino(Context context, String ciudad);

    }


    interface Model {

        void getHotelesDestinoWS(Context context, String ciudad, ListarCiudadContrato.Model.OnListarCiudadListener onListarCiudadListener);

        interface OnListarCiudadListener {
            void resolveCiudad(ArrayList<Hotel> listaHoteles);

            void rejectCiudad(String error);
        }
    }
}
