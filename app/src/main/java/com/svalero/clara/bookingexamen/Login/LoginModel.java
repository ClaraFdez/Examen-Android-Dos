package com.svalero.clara.bookingexamen.Login;

import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Usuario;
import com.svalero.clara.bookingexamen.Retrofit.ApiCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginContrato.Model{

    private OnLoginListener onLoginListener;
    String nombre, pass;
    ArrayList<Usuario> listaUsuario;

    @Override
    public void getLoginWS(Context context, String nombre, String pass, OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
        this.nombre = nombre;
        this.pass = pass;

        String param = "USUARIO.BUSCAR."+nombre+"."+pass;
        ApiCliente apiCliente = new ApiCliente(context);
        final Call<ArrayList<Usuario>> peticion = apiCliente.getUsuario(param);
        peticion.enqueue(new Callback<ArrayList<Usuario>>() {
            @Override
            public void onResponse(Call<ArrayList<Usuario>> call, Response<ArrayList<Usuario>> response) {
                if(response.isSuccessful()){
                    onLoginListener.resolve(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {
                t.printStackTrace();
                onLoginListener.reject(t.getLocalizedMessage());
            }
        });

    }

}
