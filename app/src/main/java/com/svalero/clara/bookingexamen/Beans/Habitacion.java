package com.svalero.clara.bookingexamen.Beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class Habitacion {

    private int precio;
    private String fechaEntrada;
    private String fechaSalida;
    private int idHabitacion;
    private int idHotel;
    private int numPersonas;
    private int camasInd;
    private int camasMat;
    private String nombreHotel;


    public Habitacion(int precio, String fechaEntrada, String fechaSalida, int idHabitacion, int idHotel, int numPersonas, int camasInd, int camasMat){
        this.precio = precio;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.idHabitacion = idHabitacion;
        this.idHotel = idHotel;
        this.numPersonas = numPersonas;
        this.camasInd = camasInd;
        this.camasMat = camasMat;

    }

    public Habitacion(){
    }

    public Habitacion(String nombreHotel, int idHabitacion, int numPersonas, int camasInd, int camasMat, int precio){
        this.nombreHotel = nombreHotel;//-----------------------
        this.idHabitacion = idHabitacion;
        this.numPersonas = numPersonas;
        this.camasInd = camasInd;
        this. camasMat = camasMat;
        this.precio = precio;
    }


    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    public String getFechaEntrada() { return fechaEntrada; }
    public void setFechaEntrada(String fechaEntrada) { this.fechaEntrada = fechaEntrada; }
    public String getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(String fechaSalida) { this.fechaSalida = fechaSalida; }
    public int getIdHabitacion() { return idHabitacion; }
    public void setIdHabitacion(int idHabitacion) { this.idHabitacion = idHabitacion; }
    public int getIdHotel() { return idHotel; }
    public void setIdHotel(int idHotel) { this.idHotel = idHotel; }
    public int getNumPersonas() { return numPersonas; }
    public void setNumPersonas(int numPersonas) { this.numPersonas = numPersonas; }
    public int getCamasInd() { return camasInd; }
    public void setCamasInd(int camasInd) { this.camasInd = camasInd; }
    public int getCamasMat() { return camasMat; }
    public void setCamasMat(int camasMat) { this.camasMat = camasMat; }
    public String getNombreHotel() {return nombreHotel; }
    public void setNombreHotel(String nombreHotel) {this.nombreHotel = nombreHotel;}

    /*
    public static ArrayList<Habitacion> getArrayListFromJSon(JSONArray datos){
        ArrayList<Habitacion> lista = null;
        Habitacion habitacion = null;
        try{
            if(datos != null && datos.length()>0){
                lista = new ArrayList<Habitacion>();
            }
            for ( int i = 0; i < datos.length(); i++){
                JSONObject json_data = datos.getJSONObject(i);
                habitacion = new Habitacion();

                habitacion.setIdHabitacion(json_data.getInt("id_habitacion"));
                habitacion.setNumPersonas(json_data.getInt("numero_personas"));
                habitacion.setCamasInd(json_data.getInt("camas_individuales"));
                habitacion.setCamasMat(json_data.getInt("camas_matrimonio"));
                habitacion.setPrecio(json_data.getInt("precio"));

                lista.add(habitacion);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        return lista;
    }*/

}
