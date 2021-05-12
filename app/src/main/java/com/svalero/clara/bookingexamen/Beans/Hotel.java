package com.svalero.clara.bookingexamen.Beans;



public class Hotel {

    private int idHotel;
    private String nombre;
    private String calle, ciudad, provincia, pais;
    private int puntuacion;
    private String descripcion;
    private String foto;
    private String estrellas;
    private int precio;

    public Hotel(int idHotel, String nombre, String calle, String ciudad, String provincia, String pais, int puntuacion, String descripcion, String foto, String estrellas){
        this.idHotel = idHotel;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.calle = calle;
        this.pais = pais;
        this.puntuacion = puntuacion;
        this.descripcion = descripcion;
        this.foto = foto;
        this.estrellas = estrellas;
    }
    public Hotel(String nombre, String ciudad, String foto, int puntuacion){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.foto = foto;
        this.puntuacion = puntuacion;
    }
    public Hotel(String nombre, String ciudad, String foto, int puntuacion, int precio){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.foto = foto;
        this.puntuacion = puntuacion;
        this.precio = precio;
    }

    public Hotel(String nombre, String descripcion, String ciudad, String calle, int puntuacion, String foto, String estrellas){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.calle = calle;
        this.puntuacion = puntuacion;
        this.foto = foto;
        this.estrellas = estrellas;
        this.descripcion = descripcion;
    }

    public Hotel(){
    }

    public int getIdHotel() { return idHotel; }
    public void setIdHotel(int idHotel) { this.idHotel = idHotel; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }
    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public String getEstrellas() { return estrellas; }
    public void setEstrellas(String estrellas) { this.estrellas = estrellas; }
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }

}
