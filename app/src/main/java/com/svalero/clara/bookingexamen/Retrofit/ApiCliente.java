package com.svalero.clara.bookingexamen.Retrofit;

import android.content.Context;

import com.svalero.clara.bookingexamen.Beans.Habitacion;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.Beans.Usuario;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCliente {

    private Retrofit retrofit;
    private Context context;
    private static final String URL_BASE = "http://192.168.1.124:8080/Booking_2/";

    public ApiCliente(Context context){
        this.context = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public Call<ArrayList<Hotel>> getHoteles(String param){
        BookingApiInterfaz bookingApiInterfaz = retrofit.create(BookingApiInterfaz.class);
        //String param ="HOTEL.FIND_ALL";
        return bookingApiInterfaz.getHotel(param);
    }

    public Call<ArrayList<Hotel>> getFiltro(String param){
        BookingApiInterfaz bookingApiInterfaz = retrofit.create(BookingApiInterfaz.class);
        return bookingApiInterfaz.getFiltro(param);
    }

    public Call<ArrayList<Hotel>> getCiudad(String param){
        BookingApiInterfaz bookingApiInterfaz = retrofit.create(BookingApiInterfaz.class);
        return bookingApiInterfaz.getCiudad(param);
    }

    public Call<ArrayList<Hotel>> getFicha(String param){
        BookingApiInterfaz bookingApiInterfaz = retrofit.create(BookingApiInterfaz.class);
        return bookingApiInterfaz.getFicha(param);
    }

    public Call<ArrayList<Habitacion>> getHabitacion(String param){
        BookingApiInterfaz bookingApiInterfaz =retrofit.create(BookingApiInterfaz.class);
        return bookingApiInterfaz.getHabitacion(param);
    }

    public Call<ArrayList<Usuario>> getUsuario(String param){
        BookingApiInterfaz bookingApiInterfaz = retrofit.create(BookingApiInterfaz.class);
        return bookingApiInterfaz.getUsuario(param);
    }

    public Call<ResponseBody> addUsuario(String param){
        BookingApiInterfaz bookingApiInterfaz = retrofit.create(BookingApiInterfaz.class);
        return bookingApiInterfaz.addUsuario(param);
    }
}
