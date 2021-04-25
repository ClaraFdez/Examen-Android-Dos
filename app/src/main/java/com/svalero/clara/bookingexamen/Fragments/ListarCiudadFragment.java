package com.svalero.clara.bookingexamen.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.svalero.clara.bookingexamen.Adaptadores.CiudadAdapter;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.Ficha.FichaVista;
import com.svalero.clara.bookingexamen.ListarCiudad.ListarCiudadContrato;
import com.svalero.clara.bookingexamen.ListarCiudad.ListarCiudadPresenter;
import com.svalero.clara.bookingexamen.R;

import java.util.ArrayList;


public class ListarCiudadFragment extends Fragment implements ListarCiudadContrato.View {

    private ListarCiudadPresenter listarCiudadPresenter;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    public ListarCiudadFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listar_ciudad, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.reciclerCiudad);

        String destinopasado = getArguments().getString("destinopasado");

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        listarCiudadPresenter = new ListarCiudadPresenter(this);
        listarCiudadPresenter.getHotelesDestino(getContext(), destinopasado);

        return view;
    }

    @Override
    public void successCiudad(ArrayList<Hotel> listaHoteles) {
        CiudadAdapter adapterCiudad;
        adapterCiudad = new CiudadAdapter(listaHoteles);
        recyclerView.setAdapter(adapterCiudad);

        adapterCiudad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FichaVista.class);
                intent.putExtra("NombreHotelRowTodo", listaHoteles.get(recyclerView.getChildAdapterPosition(v)).getNombre());
                startActivity(intent);
            }
        });
    }

    @Override
    public void errorCiudad(String message) {

    }
}