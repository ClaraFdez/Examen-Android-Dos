package com.svalero.clara.bookingexamen.ListarTodo;

import android.content.Context;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.Retrofit.ApiCliente;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListarTodoModel implements ListarTodoContrato.Model/*, Callback<ArrayList<Hotel>>*/{
/*
    OnListarTodoListener onListarTodoListener;

    @Override
    public void getListarTodoWS(OnListarTodoListener onListarTodoListener) {
        this.onListarTodoListener = onListarTodoListener;

        String param ="HOTEL.FIND_ALL";//-----------------

        ApiCliente apiCliente = new ApiCliente();
        final Call<ArrayList<Hotel>> peticion = apiCliente.getHoteles(param);
        peticion.enqueue(this);

    }

    @Override
    public void onResponse(Call<ArrayList<Hotel>> call, Response<ArrayList<Hotel>> response) {
        if(response != null && response.body() != null){
            onListarTodoListener.resolve(new ArrayList<Hotel>(response.body()));

        }
    }

    @Override
    public void onFailure(Call<ArrayList<Hotel>> call, Throwable t) {
        t.printStackTrace();
        onListarTodoListener.reject(t.getLocalizedMessage());
    }*/


    @Override
    public void getListarTodoWS(Context context, final OnListarTodoListener onListarTodoListener) {

        String param ="HOTEL.FIND_ALL";//-----------------

        //Call<ArrayList<Hotel>> peticion = ApiCliente.getHoteles(param);
        //peticion.enqueue(this);

        ApiCliente apiCliente = new ApiCliente(context);
        final Call<ArrayList<Hotel>> peticion = apiCliente.getHoteles(param);
        peticion.enqueue(new Callback<ArrayList<Hotel>>() {
            @Override
            public void onResponse(Call<ArrayList<Hotel>> call, Response<ArrayList<Hotel>> response) {

                if(response != null && response.body() != null){
                    onListarTodoListener.resolve(new ArrayList<Hotel>(response.body()));

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Hotel>> call, Throwable t) {
                t.printStackTrace();
                onListarTodoListener.reject(t.getLocalizedMessage());
            }
        });

    }

}