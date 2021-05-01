package com.svalero.clara.bookingexamen.Beans;

import android.widget.Toast;

import com.svalero.clara.bookingexamen.Login.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;

public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String ape1;
    //private String ape2;
    private String dni;
    private String pass;
    private int telefono;
    private String email;


    public Usuario (int idUsuario, String nombreUsuario, String ape1/*, String ape2*/, String dni, String pass, int telefono, String email){
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.ape1 = ape1;
        //this.ape2 = ape2;
        this.dni = dni;
        this.pass = pass;
        this.telefono = telefono;
        this.email = email;
    }

    public Usuario(){

    }

    public int getId() { return idUsuario; }
    public void setId(int idUsuario) { this.idUsuario = idUsuario; }
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public String getApe1() { return ape1; }
    public void setApe1(String ape1) { this.ape1 = ape1; }
    //public String getApe2() { return ape2; }
    //public void setApe2(String ape2) { this.ape2 = ape2; }
    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

/*
    public static ArrayList<Usuario> getArrayListFromJSon(JSONArray datos){
        ArrayList<Usuario> listaUsuario = null;
        Usuario usuario = null;
        System.out.println("dentro del getJson este de la clase usuario");//-----------------------------
        try{
            if(datos != null && datos.length()>0){
                System.out.println("dentro del if");
                listaUsuario = new ArrayList<Usuario>();
            }else{
                System.out.println("dentro del else");
                listaUsuario = new ArrayList<Usuario>();
                usuario = new Usuario();
                usuario.setEmail("null");
                usuario.setPass("null");
                listaUsuario.add(usuario);

            }
            for ( int i = 0; i < datos.length(); i++){
                JSONObject json_data = datos.getJSONObject(i);
                usuario = new Usuario();
                usuario.setEmail(json_data.getString("email"));
                usuario.setPass(json_data.getString("contrasena"));

                listaUsuario.add(usuario);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        return listaUsuario;
    }

*/

}
