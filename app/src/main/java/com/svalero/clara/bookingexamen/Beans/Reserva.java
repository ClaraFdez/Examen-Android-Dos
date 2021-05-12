package com.svalero.clara.bookingexamen.Beans;



public class Reserva {

    private int idReserva;
    private int idHabitacion;
    private int idUsuario;
    private String fechaInicio;
    private String fechaFin;
    private int numCamas;
    private int precio;
    private String nombreHotel;


    //EL QUE NECESITAMOS PARA INSERTAR UNA RESERVA (TABLA RESERVA Y TABLA SOBRE)
    public Reserva(int idReserva, int idHabitacion, int idUsuario, String fechaInicio, String fechaFin){
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.idUsuario = idUsuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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


}
