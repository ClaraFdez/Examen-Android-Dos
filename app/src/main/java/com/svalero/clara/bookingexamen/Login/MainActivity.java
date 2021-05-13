package com.svalero.clara.bookingexamen.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentManager;


import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.Toast;
import com.svalero.clara.bookingexamen.Beans.Usuario;
import com.svalero.clara.bookingexamen.R;
import com.svalero.clara.bookingexamen.Registro.RegistroVista;
import com.svalero.clara.bookingexamen.Reserva.ReservaVista;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoginContrato.View{
    private EditText edtLoginUsuario;
    private EditText edtLoginPass;

    private LoginPresenter loginPresenter;
    private ArrayList<Usuario> listaUsuario2;
    public boolean resultado;

    public String nombre;
    public String pass;
    public String idHabitacion;
    public String fechaInicio;
    public String fechaFin;
    public String nombreHotel;
    public String camasIndi;
    public String camasMat;
    public String precio;

    private FragmentManager fragmentManager;

    //nuevo1
    private Transition transition; //hay 3 librerias distintas para esto
    //fin nuevo1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        //inicializar();

        inicializar();

        Bundle bundle = getIntent().getExtras();
        idHabitacion = Integer.toString(bundle.getInt("IdHabitacion"));
        fechaInicio = bundle.getString("FechaInicio");
        fechaFin = bundle.getString("FechaFin");
        camasIndi = Integer.toString(bundle.getInt("CamasIndi"));
        nombreHotel = bundle.getString("NombreHotel");
        camasMat = Integer.toString(bundle.getInt("CamasMat"));
        precio = Integer.toString(bundle.getInt("Precio"));

    }

    public void inicializar(){
        edtLoginUsuario = findViewById(R.id.edtLoginUsuario);
        edtLoginPass = findViewById(R.id.edtLoginPass);
    }

    public void obtenerValores(){
        nombre = edtLoginUsuario.getText().toString();
        pass = edtLoginPass.getText().toString();
    }

    public void errorUsuario(){
        Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
    }


    public void loginEntrar(View view){
        obtenerValores();
        loginPresenter = new LoginPresenter(this);
        loginPresenter.getLogin(this, nombre, pass);
    }

    public void loginRegistrar (View view){
        //nuevo1
        transition = new Slide(Gravity.START);
        transition.setDuration(1000);
        transition.setInterpolator(new DecelerateInterpolator());

        getWindow().setExitTransition(transition);
        //fin nuevo1

        Intent i = new Intent(getApplicationContext(), RegistroVista.class);
        i.putExtra("IdHabitacion", idHabitacion);
        i.putExtra("FechaInicio", fechaInicio);
        i.putExtra("FechaFin", fechaFin);
        i.putExtra("NombreHotel", nombreHotel);
        i.putExtra("CamasIndi", camasIndi);
        i.putExtra("CamasMat", camasMat);
        i.putExtra("Precio", precio);

        //startActivity(i);
        startActivity(i, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    public boolean comprobar(ArrayList<Usuario> listaUsuario2){
        obtenerValores();
        boolean resp = true;
        for ( int i = 0; i<listaUsuario2.size(); i++){
            if(nombre == listaUsuario2.get(i).getEmail()){
                resp = false;
            }
        }
        return resp;
    }

    @Override
    public void success(ArrayList<Usuario> listaUsuario) {

        if( listaUsuario.isEmpty()) {

               errorUsuario();
               edtLoginPass.setText("");
               edtLoginUsuario.setText("");
            }else{
                Intent i = new Intent(getApplicationContext(), ReservaVista.class);
                i.putExtra("IdHabitacion", idHabitacion);
                i.putExtra("FechaInicio", fechaInicio);
                i.putExtra("FechaFin", fechaFin);
                i.putExtra("NombreHotel", nombreHotel);
                i.putExtra("CamasIndi", camasIndi);
                i.putExtra("CamasMat", camasMat);
                i.putExtra("Precio", precio);
                i.putExtra("Usuario", listaUsuario.get(0).getNombre());
                i.putExtra("Mail", listaUsuario.get(0).getEmail());
                i.putExtra("Telefono", Integer.toString(listaUsuario.get(0).getTelefono()));
                i.putExtra("IdUsuario", Integer.toString(listaUsuario.get(0).getId()));
                startActivity(i);
            }

    }

    @Override
    public void error(String message) {
        errorUsuario();
    }



}