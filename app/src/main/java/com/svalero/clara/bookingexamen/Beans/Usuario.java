package com.svalero.clara.bookingexamen.Beans;


public class Usuario {

    private int id_usuario;
    private String nombre;
    private String ape1;
    private String dni;
    private String pass;
    private int telefono;
    private String email;


    public Usuario (int id_usuario, String nombre, String ape1, String dni, String pass, int telefono, String email){
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.dni = dni;
        this.pass = pass;
        this.telefono = telefono;
        this.email = email;
    }

    public Usuario(){

    }

    public int getId() { return id_usuario; }
    public void setId(int idUsuario) { this.id_usuario = idUsuario; }
    public String getNombre() { return nombre; }
    public void setNombreUsuario(String nombre) { this.nombre = nombre; }
    public String getApe1() { return ape1; }
    public void setApe1(String ape1) { this.ape1 = ape1; }
    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }


}
