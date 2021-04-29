package com.svalero.clara.bookingexamen.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.svalero.clara.bookingexamen.Adaptadores.HabitacionAdapter;
import com.svalero.clara.bookingexamen.Beans.Habitacion;
import com.svalero.clara.bookingexamen.ListarHabitaciones.ListarHabContrato;
import com.svalero.clara.bookingexamen.ListarHabitaciones.ListarHabPresenter;
import com.svalero.clara.bookingexamen.Login.MainActivity;
import com.svalero.clara.bookingexamen.R;
import com.svalero.clara.bookingexamen.Reserva.ReservaVista;

import java.util.ArrayList;


public class HabitacionFragment extends Fragment implements ListarHabContrato.View {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ListarHabPresenter listarHabPresenter;


    public HabitacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_habitacion, container, false);

        String nombreHotel = getArguments().getString("nombreHotelPasado");
        String fechaInicio = getArguments().getString("fechaInicio");
        String fechaFin = getArguments().getString("fechaFin");
        String numPersonas = getArguments().getString("numPersonas");

        recyclerView = (RecyclerView) view.findViewById(R.id.reciclerHabitacion);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        listarHabPresenter = new ListarHabPresenter(this);
        listarHabPresenter.getHabitaciones(getContext(), fechaInicio, fechaFin, numPersonas, nombreHotel);

        return view;
    }

    @Override
    public void successHab(ArrayList<Habitacion> listaHabitaciones) {
        System.out.println("dentro del success de habitacion fragment");//---------------------------------------
        HabitacionAdapter adapter = new HabitacionAdapter(listaHabitaciones);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("IdHabitacion", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getIdHabitacion());
                intent.putExtra("FechaInicio", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getFechaEntrada());
                intent.putExtra("FechaFin", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getFechaSalida());
                intent.putExtra("NombreHotel", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getNombreHotel());
                intent.putExtra("CamasIndi", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getCamasInd());
                intent.putExtra("CamasMat", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getCamasMat());
                intent.putExtra("Precio", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getPrecio());
                startActivity(intent);
            }

        });
    }

    @Override
    public void errorHab(String message) {
        message = "Error en la obtención de los datos del hotel";
    }


}