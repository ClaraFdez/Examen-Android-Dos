package com.svalero.clara.bookingexamen.Retrofit;

import com.svalero.clara.bookingexamen.Beans.Habitacion;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.Beans.Usuario;
import java.util.ArrayList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BookingApiInterfaz {

    // Nos trae una lista con todos los hoteles
    @GET("Controller")
    Call<ArrayList<Hotel>> getHotel(@Query("ACTION") String params);

    // Nos trae una lista con los hoteles según el filtro deseado
    @GET("Controller")
    Call<ArrayList<Hotel>> getFiltro(@Query("ACTION") String params);

    // Nos trae los hoteles de la ciudad seleccionada
    @GET("Controller")
    Call<ArrayList<Hotel>> getCiudad(@Query("ACTION") String params);

    // Nos trae la ficha del hotel elegido
    @GET("Controller")
    Call<ArrayList<Hotel>> getFicha(@Query("ACTION") String params);

    //Nos trae las habitaciones libres de un hotel según fecha de entrada y salida
    @GET("Controller")
    Call<ArrayList<Habitacion>> getHabitacion(@Query("ACTION") String params);

    //Nos trae el usuario de la base de datos
    @GET("Controller")
    Call<ArrayList<Usuario>> getUsuario(@Query("ACTION") String params);

    // Inserta un usuario
    @POST("Controller")
    Call<ResponseBody> addUsuario(@Query("ACTION") String params);

    //Inserta una reserva y nos la devuelve
    @POST("Controller")
    Call<ResponseBody> addReserva(@Query("ACTION") String params);

    //Inserta en la tabla Sobre
    @POST("Controller")
    Call<ResponseBody> addSobre(@Query("ACTION") String params);

}
