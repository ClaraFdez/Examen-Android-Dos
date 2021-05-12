package com.svalero.clara.bookingexamen.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.svalero.clara.bookingexamen.Adaptadores.HabitacionAdapter;
import com.svalero.clara.bookingexamen.Beans.Habitacion;
import com.svalero.clara.bookingexamen.ListarHabitaciones.ListarHabContrato;
import com.svalero.clara.bookingexamen.ListarHabitaciones.ListarHabPresenter;
import com.svalero.clara.bookingexamen.Login.MainActivity;
import com.svalero.clara.bookingexamen.R;

import java.util.ArrayList;


public class HabitacionFragment extends Fragment implements ListarHabContrato.View {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ListarHabPresenter listarHabPresenter;

    String fechaInicio;
    String fechaFin;
    String nombreHotel;
    String numPersonas;

    private View layoutError;
    private View layoutCargando;
    private Button bttReintentar;

    public HabitacionFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_habitacion, container, false);

        nombreHotel = getArguments().getString("nombreHotelPasado");
        fechaInicio = getArguments().getString("fechaInicio");
        fechaFin = getArguments().getString("fechaFin");
        numPersonas = getArguments().getString("numPersonas");

        recyclerView = (RecyclerView) view.findViewById(R.id.reciclerHabitacion);
        layoutCargando = (View) view.findViewById(R.id.layout_habitacion_progressBar);
        layoutError = (View) view.findViewById(R.id.layoutError);
        bttReintentar = (Button) view.findViewById(R.id.bttReintentar);

        layoutCargando.setVisibility(View.VISIBLE);
        layoutError.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        listarHabPresenter = new ListarHabPresenter(this);
        listarHabPresenter.getHabitaciones(getContext(), fechaInicio, fechaFin, numPersonas, nombreHotel);

        bttReintentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutCargando.setVisibility(View.GONE);
                listarHabPresenter.getHabitaciones(getContext(), fechaInicio, fechaFin, numPersonas, nombreHotel);
            }
        });

        return view;
    }

    @Override
    public void successHab(ArrayList<Habitacion> listaHabitaciones) {
        layoutCargando.setVisibility(View.GONE);
        layoutError.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        HabitacionAdapter adapter = new HabitacionAdapter(listaHabitaciones);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("IdHabitacion", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getIdHabitacion());
                intent.putExtra("FechaInicio", fechaInicio);
                intent.putExtra("FechaFin", fechaFin);
                intent.putExtra("NombreHotel", nombreHotel);
                intent.putExtra("CamasIndi", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getCamasInd());
                intent.putExtra("CamasMat", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getCamasMat());
                intent.putExtra("Precio", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getPrecio());
                startActivity(intent);
            }

        });
    }

    @Override
    public void errorHab(String message) {
        layoutCargando.setVisibility(View.GONE);
        layoutError.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        message = "Error en la obtención de los datos del hotel";
    }



}