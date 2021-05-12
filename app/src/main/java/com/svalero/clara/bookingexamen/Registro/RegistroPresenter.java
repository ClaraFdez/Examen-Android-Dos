package com.svalero.clara.bookingexamen.Registro;

import android.content.Context;
import com.svalero.clara.bookingexamen.Beans.Usuario;


public class RegistroPresenter implements RegistroContrato.Presenter{

    private RegistroContrato.View vista;
    private RegistroModel model;

    public RegistroPresenter(RegistroContrato.View vista){
        this.vista = vista;
        this.model = new RegistroModel();
    }

    public RegistroPresenter(){
    }


    @Override
    public void setUsuarioRegistro(Context context, Usuario usuario) {
        this.model.setUsuarioRegistroWS(context, usuario, new RegistroContrato.Model.OnRegistroListener() {
            @Override
            public void resolveRegistro(String success) {
                vista.successRegistro(success);
            }

            @Override
            public void rejectRegistro(String error) {
                vista.errorRegistro("Fallo en el registro");
            }
        });
    }
}
