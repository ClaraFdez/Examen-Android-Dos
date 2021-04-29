package com.svalero.clara.bookingexamen.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.clara.bookingexamen.Beans.Habitacion;


import com.svalero.clara.bookingexamen.R;

import java.util.ArrayList;

public class HabitacionAdapter extends RecyclerView.Adapter<HabitacionAdapter.HabitacionViewHolder> implements View.OnClickListener {

    private ArrayList<Habitacion> listaHabitaciones;
    private View.OnClickListener listener;

    public static class HabitacionViewHolder extends RecyclerView.ViewHolder{

        private TextView txtHabRowNumPersonas1;
        private TextView txtHabRowCamasIndi1;
        private TextView txtHabRowCamasMatri1;
        private TextView txtHabRowPrecio;




        public HabitacionViewHolder(View v){
            super(v);
            txtHabRowCamasIndi1 = (TextView) v.findViewById(R.id.txtHabRowCamasIndi1);
            txtHabRowCamasMatri1 = (TextView) v.findViewById(R.id.txtHabRowCamasMatri1);
            txtHabRowNumPersonas1 = (TextView) v.findViewById(R.id.txtHabRowNumPersonas1);
            txtHabRowPrecio = (TextView) v.findViewById(R.id.txtHabRowPrecio);

        }

    }

    public HabitacionAdapter (ArrayList<Habitacion> listaHabitaciones){
        this.listaHabitaciones = listaHabitaciones;
    }



    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public HabitacionViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha_row, parent, false);
        v.setOnClickListener(this);
        return new HabitacionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HabitacionViewHolder holder, int position) {
        holder.txtHabRowCamasIndi1.setText(String.valueOf(listaHabitaciones.get(position).getCamasInd()));
        System.out.println("a ver que le llega dentro del viewholder de habitacionAdapter, camas ind: "+ listaHabitaciones.get(position).getCamasInd());//-------------------------
        holder.txtHabRowCamasMatri1.setText(String.valueOf(listaHabitaciones.get(position).getCamasMat()));
        System.out.println("a ver que le llega dentro del viewholder de habitacionAdapter, camas mat: "+ listaHabitaciones.get(position).getCamasMat());//--------
        holder.txtHabRowNumPersonas1.setText(String.valueOf(listaHabitaciones.get(position).getNumPersonas()));
        System.out.println("a ver que le llega dentro del viewholder de habitacionAdapter, num per: "+ listaHabitaciones.get(position).getNumPersonas());//--------
        holder.txtHabRowPrecio.setText(String.valueOf(listaHabitaciones.get(position).getPrecio()));
        System.out.println("a ver que le llega dentro del viewholder de habitacionAdapter, precio: "+ listaHabitaciones.get(position).getPrecio());//--------
    }

    @Override
    public int getItemCount() {
        return listaHabitaciones.size();
    }
}
