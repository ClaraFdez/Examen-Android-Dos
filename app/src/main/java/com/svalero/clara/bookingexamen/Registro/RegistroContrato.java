package com.svalero.clara.bookingexamen.Registro;

import android.content.Context;
import com.svalero.clara.bookingexamen.Beans.Usuario;


public interface RegistroContrato {

    interface View {
        void successRegistro(String success);

        void errorRegistro(String mensaje);
    }


    interface Presenter {
        void setUsuarioRegistro(Context context, Usuario usuario);

    }


    interface Model {

        void setUsuarioRegistroWS(Context context, Usuario usuario, RegistroContrato.Model.OnRegistroListener onRegistroListener);

        interface OnRegistroListener {
            void resolveRegistro(String success);

            void rejectRegistro(String error);
        }

    }

}
