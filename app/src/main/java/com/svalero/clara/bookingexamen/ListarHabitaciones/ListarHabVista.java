package com.svalero.clara.bookingexamen.ListarHabitaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.svalero.clara.bookingexamen.Adaptadores.HabitacionAdapter;
import com.svalero.clara.bookingexamen.Beans.Habitacion;
import com.svalero.clara.bookingexamen.R;
import com.svalero.clara.bookingexamen.Reserva.ReservaVista;

import java.util.ArrayList;

public class ListarHabVista extends AppCompatActivity implements ListarHabContrato.View {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ListarHabPresenter listarHabPresenter;

    public String nombreHotel;
    public String fechaInicio;
    public String fechaFin;
    public String numPersonas = "null";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_habitaciones);

        recyclerView = (RecyclerView) findViewById(R.id.reciclerHabitacion);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Bundle bundle = getIntent().getExtras();
        nombreHotel = bundle.getString("nombreHotelPasado");
        fechaInicio = bundle.getString("fechaentrada");
        fechaFin = bundle.getString("fechasalida");
        numPersonas = bundle.getString("numPersonas");

        listarHabPresenter = new ListarHabPresenter(this);
        listarHabPresenter.getHabitaciones(this, fechaInicio, fechaFin, numPersonas, nombreHotel);

    }

    @Override
    public void successHab(ArrayList<Habitacion> listaHabitaciones) {
        HabitacionAdapter adapter = new HabitacionAdapter(listaHabitaciones);
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReservaVista.class);
                intent.putExtra("IdHabitacion", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getIdHabitacion());
                startActivity(intent);
            }

        });
    }

    @Override
    public void errorHab(String message) {
        message = "Error en la obtención de los datos del hotel";
    }
}