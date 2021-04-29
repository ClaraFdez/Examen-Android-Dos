package com.svalero.clara.bookingexamen.Reserva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.svalero.clara.bookingexamen.Ficha.FichaVista;
import com.svalero.clara.bookingexamen.ListarHabitaciones.ListarHabVista;
import com.svalero.clara.bookingexamen.R;

public class ReservaVista extends AppCompatActivity implements ReservaContrato.View{

    private TextView txtReservaNombre, txtReservaTelefono, txtReservaEmail, txtReservaNombreHotel;
    private TextView txtReservaCamasIndi, txtReservaCamasMatri, txtReservaFechaEntrada, txtReservaFechaSalida, txtReservaPrecio;

    public String idHabitacion;
    public String fechaInicio;
    public String fechaFin;
    public String idUsuario;
    public String nombreHotel;
    public String camasIndi;
    public String camasMat;
    public String precio;
    public String nombreUsurio;
    public String eMail;
    public String telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_vista);

        inicializar();

        Bundle bundle = getIntent().getExtras();
        idHabitacion = bundle.getString("IdHabitacion");
        fechaInicio = bundle.getString("FechaInicio");
        fechaFin = bundle.getString("FechaFin");
        idUsuario = bundle.getString("IdUsuario");
        nombreHotel = bundle.getString("NombreHotel");
        camasIndi = bundle.getString("CamasIndi");
        camasMat = bundle.getString("CamasMat");
        precio = bundle.getString("Precio");
        nombreUsurio = bundle.getString("Usuario");
        eMail = bundle.getString("Mail");
        telefono = bundle.getString("Telefono");

        darValores();

    }

    public void inicializar(){
        txtReservaNombre = findViewById(R.id.txtReservaNombre);
        txtReservaTelefono = findViewById(R.id.txtReservaTelefono);
        txtReservaEmail = findViewById(R.id.txtReservaEmail);
        txtReservaNombreHotel = findViewById(R.id.txtReservaNombreHotel);
        txtReservaCamasIndi = findViewById(R.id.txtReservaCamasIndi);
        txtReservaCamasMatri = findViewById(R.id.txtReservaCamasMatri);
        txtReservaFechaEntrada = findViewById(R.id.txtReservaFechaEntrada);
        txtReservaFechaSalida = findViewById(R.id.txtReservaFechaSalida);
        txtReservaPrecio = findViewById(R.id.txtReservaPrecio);
    }

    public void darValores(){
        txtReservaNombre.setText(nombreUsurio);
        txtReservaTelefono.setText(telefono);
        txtReservaEmail.setText(eMail);
        txtReservaNombreHotel.setText(nombreHotel);
        txtReservaCamasIndi.setText(camasIndi);
        txtReservaCamasMatri.setText(camasMat);
        txtReservaFechaEntrada.setText(fechaInicio);
        txtReservaFechaSalida.setText(fechaFin);
        txtReservaPrecio.setText(precio);
    }

    public void registrarReserva(View view){
       ReservaPresenter reservaPresenter = new ReservaPresenter();
       reservaPresenter.setReserva(this, idUsuario, fechaInicio, fechaFin, idHabitacion);
    }

    @Override
    public void successReserva(String success) {
        Toast.makeText(this, "Reservado con exito", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, ListarHabVista.class);
        startActivity(intent);
    }

    @Override
    public void errorReserva(String mensaje) {
        Toast.makeText(this, "Error en la reserva", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, FichaVista.class);
        startActivity(intent);
    }
}