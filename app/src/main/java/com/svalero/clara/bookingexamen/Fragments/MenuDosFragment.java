package com.svalero.clara.bookingexamen.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.svalero.clara.bookingexamen.Fin.Fin;
import com.svalero.clara.bookingexamen.ListarTodo.ListarTodoVista;
import com.svalero.clara.bookingexamen.R;


public class MenuDosFragment extends Fragment {

    private ImageButton bttMenuDosSalir;
    private ImageButton bttMenuDosCasa;


    public MenuDosFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_dos, container, false);

        bttMenuDosCasa = (ImageButton) view.findViewById(R.id.bttMenuDosCasa);
        bttMenuDosSalir = (ImageButton) view.findViewById(R.id.bttMenuDosSalir);

        bttMenuDosSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), Fin.class);
                startActivity(intent);
            }
        });

        bttMenuDosCasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ListarTodoVista.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void pasarCasa(){
        Intent intent = new Intent(getContext(), ListarTodoVista.class);
    }

}