package com.svalero.clara.bookingexamen.Beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Reserva {

    private int idReserva;
    private int idHabitacion;
    private int idUsuario;
    private String fechaInicio;
    private String fechaFin;
    private int numCamas;
    private int precio;
    private String nombreHotel;

    public Reserva(int idReserva, int idHabitacion, int idUsuario, String fechaInicio, String fechaFin, int numCamas, int precio, String nombreHotel){
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.idUsuario = idUsuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numCamas = numCamas;
        this. precio = precio;
        this.nombreHotel = nombreHotel;
    }

    public Reserva(){
    }

    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }
    public int getIdHabitacion() { return idHabitacion; }
    public void setIdHabitacion(int idHabitacion) { this.idHabitacion = idHabitacion; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }
    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    public String getNombreHotel() { return nombreHotel; }
    public void setNombreHotel(String nombreHotel) { this.nombreHotel = nombreHotel; }
    public int getNumCamas() { return numCamas; }
    public void setNumCamas(int numCamas) { this.numCamas = numCamas; }


    public static ArrayList<Reserva> getArrayListFromJSon(JSONArray datos){
        ArrayList<Reserva> listaReserva = null;
        Reserva reserva = null;
        try{
            if(datos != null && datos.length()>0){
                listaReserva = new ArrayList<Reserva>();
            }
            for ( int i = 0; i < datos.length(); i++){
                JSONObject json_data = datos.getJSONObject(i);
                reserva = new Reserva();
                reserva.setIdReserva(json_data.getInt("id_reserva"));
                reserva.setNombreHotel(json_data.getString("nombre"));
                reserva.setIdHabitacion(json_data.getInt("id_habitacion"));
                reserva.setIdUsuario(json_data.getInt("id_usuario"));
                reserva.setFechaInicio(json_data.getString("fecha_inicio"));
                reserva.setFechaFin(json_data.getString("fecha_fin"));
                reserva.setPrecio(json_data.getInt("precio"));

                listaReserva.add(reserva);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        return listaReserva;
    }

}
