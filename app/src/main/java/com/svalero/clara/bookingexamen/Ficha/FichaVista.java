package com.svalero.clara.bookingexamen.Ficha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.ListarHabitaciones.ListarHabVista;
import com.svalero.clara.bookingexamen.ListarTodo.ListarTodoVista;
import com.svalero.clara.bookingexamen.R;

import java.util.ArrayList;

public class FichaVista extends AppCompatActivity implements FichaContrato.View{

    private TextView txtFichaNom;
    private TextView txtFichaDir;
    private TextView txtFichaDes;
    private ImageView imagen;
    private TextView txtPuntuacion;
    private TextView txtEstrellas;

    private View layoutCargando;
    private View layoutError;
    private View layoutFicha;

    private FichaPresenter fichaPresenter;
    public String nombreHotelPasado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha);

        Bundle bundle = getIntent().getExtras();
        nombreHotelPasado = bundle.getString("NombreHotelRowTodo");

        inicializar();

        layoutCargando.setVisibility(View.VISIBLE);
        layoutError.setVisibility(View.GONE);
        layoutFicha.setVisibility(View.GONE);

        fichaPresenter = new FichaPresenter(this);
        fichaPresenter.getHotelFicha(this, nombreHotelPasado);

    }



    public void volver(View v){
        Intent intent = new Intent(getApplicationContext(), ListarTodoVista.class);
        startActivity(intent);
    }

    //pasamos el nombre del hotel para luego unirlo a los datos de fecha y ver las habitaciones disponibles
    public void buscarDisponibilidad(View view){
        Intent intent = new Intent(getApplicationContext(), ListarHabVista.class);
        intent.putExtra("nombreHotelPasado", nombreHotelPasado);
        startActivity(intent);

    }


    public void inicializar(){
        txtFichaNom = findViewById(R.id.txtFichaNom);
        txtFichaDir = findViewById(R.id.txtFichaDir);
        txtFichaDes = findViewById(R.id.txtFichaDes);
        imagen = findViewById(R.id.imagenFicha);
        txtPuntuacion = findViewById(R.id.txtFichaPuntuacion);
        txtEstrellas = findViewById(R.id.txtFichaEstrellas);

        layoutCargando = findViewById(R.id.layout_ficha_progressBar);
        layoutError = findViewById(R.id.layoutError);
        layoutFicha = findViewById(R.id.layout_ficha);
    }


    public String pasarPuntuacion(String dato){
        String resultado="";
        switch (dato){
            case "una":
                resultado = "1";
                break;
            case "dos":
                resultado = "2";
                break;
            case "tres":
                resultado = "3";
                break;
            case "cuatro":
                resultado = "4";
                break;
            case "cinco":
                resultado = "5";
                break;
            case "seis":
                resultado = "5+";
                break;

        }

        return resultado;
    }


    public void botonReintentarFicha(View view){
        layoutCargando.setVisibility(View.VISIBLE);
        fichaPresenter.getHotelFicha(this, nombreHotelPasado);
    }


    @Override
    public void successHotel(ArrayList<Hotel> listaHoteles) {
        layoutCargando.setVisibility(View.GONE);
        layoutError.setVisibility(View.GONE);
        layoutFicha.setVisibility(View.VISIBLE);

        txtFichaNom.setText(listaHoteles.get(0).getNombre());
        String direccion = listaHoteles.get(0).getCalle() + ", " +listaHoteles.get(0).getCiudad();
        txtFichaDir.setText(direccion);
        txtFichaDes.setText(listaHoteles.get(0).getDescripcion());
        txtEstrellas.setText(pasarPuntuacion(listaHoteles.get(0).getEstrellas()));
        txtPuntuacion.setText(String.valueOf(listaHoteles.get(0).getPuntuacion()));
        String url = "http://192.168.1.124:8080/Booking_2/images/" + listaHoteles.get(0).getFoto() + ".jpg";
        Picasso.get().load(url).into(imagen);
    }



    @Override
    public void errorHotel(String message) {
        layoutCargando.setVisibility(View.GONE);
        layoutError.setVisibility(View.VISIBLE);
        layoutFicha.setVisibility(View.GONE);
        message = "Error en la obtención de los datos del hotel";
    }


}