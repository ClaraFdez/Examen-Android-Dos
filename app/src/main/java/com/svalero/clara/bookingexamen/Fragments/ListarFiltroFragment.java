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
import com.svalero.clara.bookingexamen.ListarFiltro.ListarFiltroContrato;
import com.svalero.clara.bookingexamen.ListarFiltro.ListarFiltroPresenter;
import com.svalero.clara.bookingexamen.R;

import java.util.ArrayList;


public class ListarFiltroFragment extends Fragment implements ListarFiltroContrato.View {

    private ListarFiltroPresenter listarFiltroPresenter;
    private RecyclerView reciclerFiltro;
    private RecyclerView.LayoutManager layoutManager;


    public ListarFiltroFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listar_filtro, container, false);

        String destinopasado = getArguments().getString("destinopasado");
        String filtro = getArguments().getString("filtro");

        listarFiltroPresenter = new ListarFiltroPresenter(this);
        listarFiltroPresenter.getHotelesFiltro(getContext(), filtro, destinopasado);

        reciclerFiltro = (RecyclerView) view.findViewById(R.id.reciclerFiltro);
        reciclerFiltro.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        reciclerFiltro.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void success(ArrayList<Hotel> listaHoteles) {
        CiudadAdapter adapter;
        adapter = new CiudadAdapter(listaHoteles);
        reciclerFiltro.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FichaVista.class);
                intent.putExtra("NombreHotelRowTodo", listaHoteles.get(reciclerFiltro.getChildAdapterPosition(v)).getNombre());
                startActivity(intent);
            }
        });
    }

    @Override
    public void error(String message) {

    }
}