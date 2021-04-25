package com.svalero.clara.bookingexamen.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.svalero.clara.bookingexamen.R;



public class MenuUnoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_menu_uno, container, false);

        ImageButton imageButton;
        imageButton = (ImageButton) view.findViewById(R.id.bttMenuUnoSalir);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        return view;
    }

}