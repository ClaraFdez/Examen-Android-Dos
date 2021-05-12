package com.svalero.clara.bookingexamen.ListarCiudad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import com.svalero.clara.bookingexamen.Fragments.ListarCiudadFragment;
import com.svalero.clara.bookingexamen.Fragments.ListarFiltroFragment;
import com.svalero.clara.bookingexamen.R;


public class ListarCiudadVista extends AppCompatActivity{

    String destinopasado;

    private View layoutErrorCiudad;
    private View layoutListarCiudadProgressBar;
    private View layoutCiudadRecicler;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_ciudad_vista);

        fragmentManager = getSupportFragmentManager();
        inicializar();

        Bundle bundle = getIntent().getExtras();
        destinopasado = bundle.getString("destinopasado");

        Bundle argumentos = new Bundle();
        argumentos.putString("destinopasado", destinopasado);
        ListarCiudadFragment listarCiudadFragment = new ListarCiudadFragment();
        listarCiudadFragment.setArguments(argumentos);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_ciudad_contenedor, listarCiudadFragment);
        fragmentTransaction.commit();
    }


    public void puntuacion(View v){
        Bundle argumentos = new Bundle();
        argumentos.putString("destinopasado", destinopasado);
        argumentos.putString("filtro", "FIND_PUNTUACION");

        ListarFiltroFragment listarFiltroFragment = new ListarFiltroFragment();
        listarFiltroFragment.setArguments(argumentos);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_ciudad_contenedor, listarFiltroFragment);
        fragmentTransaction.commit();
    }

    public void precioAsc(View v){
        Bundle argumentos = new Bundle();
        argumentos.putString("destinopasado", destinopasado);
        argumentos.putString("filtro", "PRECIO_ASC");

        ListarFiltroFragment listarFiltroFragment = new ListarFiltroFragment();
        listarFiltroFragment.setArguments(argumentos);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_ciudad_contenedor, listarFiltroFragment);
        fragmentTransaction.commit();
    }

    public void precioDes(View v){
        Bundle argumentos = new Bundle();
        argumentos.putString("destinopasado", destinopasado);
        argumentos.putString("filtro", "PRECIO_DESC");

        ListarFiltroFragment listarFiltroFragment = new ListarFiltroFragment();
        listarFiltroFragment.setArguments(argumentos);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_ciudad_contenedor, listarFiltroFragment);
        fragmentTransaction.commit();
    }

    public void masReservados(View v){
        Bundle argumentos = new Bundle();
        argumentos.putString("destinopasado", destinopasado);
        argumentos.putString("filtro", "RESERVADOS");

        ListarFiltroFragment listarFiltroFragment = new ListarFiltroFragment();
        listarFiltroFragment.setArguments(argumentos);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_ciudad_contenedor, listarFiltroFragment);
        fragmentTransaction.commit();
    }

    public void botonReintentarciudad(View v){
        layoutListarCiudadProgressBar.setVisibility(View.VISIBLE);

    }

    public void inicializar(){
        layoutErrorCiudad = findViewById(R.id.layoutErrorCiudad);
        layoutListarCiudadProgressBar = findViewById(R.id.layout_listar_ciudad_progressBar);
        layoutCiudadRecicler = findViewById(R.id.layout_ciudad_contenedor);

    }

}