package com.svalero.clara.bookingexamen.Registro;


import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Usuario;
import com.svalero.clara.bookingexamen.Retrofit.ApiCliente;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroModel implements RegistroContrato.Model{

    private OnRegistroListener onRegistroListener;
    Usuario usuario;
    private ArrayList<Usuario> listaUsuario;

    @Override
    public void setUsuarioRegistroWS(Context context, final Usuario usuario, OnRegistroListener onRegistroListener) {
        this.onRegistroListener = onRegistroListener;
        this.usuario = new Usuario();

        String param = "USUARIO.ADD." + usuario.getPass() + "." + usuario.getNombreUsuario() + "." + usuario.getApe1() + "." + usuario.getEmail() + "." + usuario.getDni() + "." + usuario.getTelefono();

        ApiCliente apiCliente = new ApiCliente(context);
        final Call<ResponseBody> peticion = apiCliente.addUsuario(param);
        peticion.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    onRegistroListener.resolveRegistro("Usuario añadido");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                onRegistroListener.rejectRegistro(t.getLocalizedMessage());
            }
        });

    }

}
