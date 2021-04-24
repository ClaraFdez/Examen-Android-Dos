package com.svalero.clara.bookingexamen.Login;


import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Usuario;
import java.util.ArrayList;

public class LoginPresenter implements LoginContrato.Presenter{

    private LoginContrato.View vista;
    private LoginModel model;

    public LoginPresenter(LoginContrato.View vista){
        this.vista = vista;
        this.model = new LoginModel();
    }

    public LoginPresenter(){
    }

    @Override
    public void getLogin(Context context, String nombre, String pass) {
        this.model.getLoginWS(context, nombre, pass, new LoginContrato.Model.OnLoginListener() {
            @Override
            public void resolve(ArrayList<Usuario> listaUsuarios) {
                vista.success(listaUsuarios);

            }

            @Override
            public void reject(String error) {
                error = "Error al comprobar el login";
            }
        });
    }


}
