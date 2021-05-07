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
        // Required empty public constructor
    }

/*
    // TODO: Rename and change types and number of parameters
    public static MenuDosFragment newInstance(String param1, String param2) {
        MenuDosFragment fragment = new MenuDosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_dos, container, false);

        bttMenuDosCasa = (ImageButton) view.findViewById(R.id.bttMenuDosCasa);
        bttMenuDosSalir = (ImageButton) view.findViewById(R.id.bttMenuDosSalir);

        bttMenuDosSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //System.exit(0);
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


        // Inflate the layout for this fragment
        return view;
    }
/*
    public void salir(View view){
        System.exit(0);

    }

    public void casa(View view){
        Intent intent = new Intent(getActivity(), ListarTodoVista.class);
        startActivity(intent);
    }
*/
    public void pasarCasa(){
        Intent intent = new Intent(getContext(), ListarTodoVista.class);
    }

}