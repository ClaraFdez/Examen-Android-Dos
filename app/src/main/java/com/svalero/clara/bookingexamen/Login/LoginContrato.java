package com.svalero.clara.bookingexamen.Login;



import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Usuario;
import java.util.ArrayList;

public interface LoginContrato {

    interface View {
        void success(ArrayList<Usuario> listaUsuario);

        void error(String message);
    }


    interface Presenter {
        void getLogin(Context context, String nombre, String pass);


    }


    interface Model {

        void getLoginWS(Context context, String nombre, String pass, OnLoginListener onLoginListener);

        interface OnLoginListener {
            void resolve(ArrayList<Usuario> listaUsuario);

            void reject(String error);
        }

    }

}
