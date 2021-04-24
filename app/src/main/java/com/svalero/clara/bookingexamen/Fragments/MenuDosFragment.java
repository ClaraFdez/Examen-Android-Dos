package com.svalero.clara.bookingexamen.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.svalero.clara.bookingexamen.ListarTodo.ListarTodoVista;
import com.svalero.clara.bookingexamen.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuDosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuDosFragment extends Fragment {

    private Button bttMenuDosSalir;
    private Button bttMenuDosCasa;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuDosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuDosFragment.
     */
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_dos, container, false);
    }

    public void salir(View view){
        System.exit(0);

    }

    public void casa(View view){
        Intent intent = new Intent(getActivity(), ListarTodoVista.class);
        startActivity(intent);
    }


}