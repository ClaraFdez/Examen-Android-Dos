package com.svalero.clara.bookingexamen.ListarFiltro;

import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Hotel;
import java.util.ArrayList;

public interface ListarFiltroContrato {

    interface View {
        void success(ArrayList<Hotel> listaHoteles);

        void error(String message);
    }


    interface Presenter {
        void getHotelesFiltro(Context context, String filtroDado, String ciudad);

    }


    interface Model {

        void getHotelesFiltroWS(Context context, String filtroDado, String ciudad, ListarFiltroContrato.Model.OnListarFiltroListener onListarFiltroListener);

        interface OnListarFiltroListener {
            void resolve(ArrayList<Hotel> listaHoteles);

            void reject(String error);
        }

    }

}
