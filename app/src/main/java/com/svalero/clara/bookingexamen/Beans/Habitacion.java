package com.svalero.clara.bookingexamen.Beans;



public class Habitacion {

    private int precio;
    private String fecha_inicio;
    private String fecha_fin;
    private int id_habitacion;
    private int id_hotel;
    private int numero_personas;
    private int camas_individuales;
    private int camas_matrimonio;
    private String nombreHot;


    public Habitacion(int precio, String fecha_inicio, String fecha_fin, int id_habitacion, int id_hotel, int numero_personas, int camas_individuales, int camas_matrimonio){
        this.precio = precio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_habitacion = id_habitacion;
        this.id_hotel = id_hotel;
        this.numero_personas = numero_personas;
        this.camas_individuales = camas_individuales;
        this.camas_matrimonio = camas_matrimonio;

    }

    public Habitacion(){
    }

    public Habitacion(int id_habitacion, int numero_personas, int camas_individuales, int camas_matrimonio, int precio){
        this.id_habitacion = id_habitacion;
        this.numero_personas = numero_personas;
        this.camas_individuales = camas_individuales;
        this. camas_matrimonio = camas_matrimonio;
        this.precio = precio;
    }


    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    public String getFechaEntrada() { return fecha_inicio; }
    public void setFechaEntrada(String fechaEntrada) { this.fecha_inicio = fechaEntrada; }
    public String getFechaSalida() { return fecha_fin; }
    public void setFechaSalida(String fechaSalida) { this.fecha_fin = fechaSalida; }
    public int getIdHabitacion() { return id_habitacion; }
    public void setIdHabitacion(int idHabitacion) { this.id_habitacion = idHabitacion; }
    public int getIdHotel() { return id_hotel; }
    public void setIdHotel(int idHotel) { this.id_hotel = idHotel; }
    public int getNumPersonas() { return numero_personas; }
    public void setNumPersonas(int numPersonas) { this.numero_personas = numPersonas; }
    public int getCamasInd() { return camas_individuales; }
    public void setCamasInd(int camasInd) { this.camas_individuales = camasInd; }
    public int getCamasMat() { return camas_matrimonio; }
    public void setCamasMat(int camasMat) { this.camas_matrimonio = camasMat; }
    public String getNombreHotel() {return nombreHot; }
    public void setNombreHotel(String nombreHotel) {this.nombreHot = nombreHotel;}



}
