package com.svalero.clara.bookingexamen.Reserva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.svalero.clara.bookingexamen.R;

public class ReservaVista extends AppCompatActivity {

    private TextView txtReservaNombre, txtReservaTelefono, txtReservaEmail, txtReservaNombreHotel;
    private TextView txtReservaCamasIndi, txtReservaCamasMatri, txtReservaFechaEntrada, txtReservaFechaSalida, txtReservaPrecio;

    public String idHabitacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_vista);

        inicializar();

        Bundle bundle = getIntent().getExtras();
        idHabitacion = bundle.getString("IdHabitacion");

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

    public void registrarReserva(View view){
        //en construccion
        Toast.makeText(this, "En construcción", Toast.LENGTH_LONG);
    }

}