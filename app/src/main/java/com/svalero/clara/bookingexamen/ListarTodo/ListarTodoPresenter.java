package com.svalero.clara.bookingexamen.ListarTodo;

import android.content.Context;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import java.util.ArrayList;


public class ListarTodoPresenter implements ListarTodoContrato.Presenter{

    private ListarTodoContrato.View vista;
    private ListarTodoModel model;

    public ListarTodoPresenter(ListarTodoContrato.View vista){
        this.vista = vista;
        this.model = new ListarTodoModel();
    }

    public ListarTodoPresenter(){
    }


    @Override
    public void getHoteles(Context context) {

        this.model.getListarTodoWS(context, new ListarTodoContrato.Model.OnListarTodoListener() {

            @Override
            public void resolve(ArrayList<Hotel> listaHoteles) {
                vista.success(listaHoteles);
            }

            @Override
            public void reject(String error) {
                error = "Hoteles no encontrados";
            }
        });

    }


}
