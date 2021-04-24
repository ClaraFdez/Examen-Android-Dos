package com.svalero.clara.bookingexamen.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.svalero.clara.bookingexamen.Beans.Habitacion;
import com.svalero.clara.bookingexamen.R;
import java.util.ArrayList;

public class FichaAdapter extends RecyclerView.Adapter<FichaAdapter.HabitacionViewHolder> implements View.OnClickListener{

    private ArrayList<Habitacion> listaHabitaciones;
    private View.OnClickListener listener;

    public static class HabitacionViewHolder extends RecyclerView.ViewHolder{
        public TextView numPersonas;
        public TextView camasIndividuales;
        public TextView camasMatrimonio;
        public TextView precio;
        public TextView id_habitacion;



        public HabitacionViewHolder(View v){
            super(v);
            numPersonas = (TextView) v.findViewById(R.id.txtHabRowNumPersonas1);
            camasIndividuales = (TextView) v.findViewById(R.id.txtHabRowCamasIndi1);
            camasMatrimonio = (TextView) v.findViewById(R.id.txtHabRowCamasMatri1);
            precio = (TextView) v.findViewById(R.id.txtHabRowPrecio);
            id_habitacion = (TextView) v.findViewById((R.id.txtIdHabitacion));
        }

    }

    public FichaAdapter (ArrayList<Habitacion> listaHabitaciones){
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
    public FichaAdapter.HabitacionViewHolder onCreateViewHolder(ViewGroup parent, int i) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha_row, parent, false);
        v.setOnClickListener(this);

        return new FichaAdapter.HabitacionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FichaAdapter.HabitacionViewHolder holder, int position) {
        holder.numPersonas.setText(listaHabitaciones.get(position).getNumPersonas());
        holder.camasIndividuales.setText(listaHabitaciones.get(position).getCamasInd());
        holder.camasMatrimonio.setText(listaHabitaciones.get(position).getCamasMat());
        holder.precio.setText(listaHabitaciones.get(position).getPrecio());
        holder.id_habitacion.setText(listaHabitaciones.get(position).getIdHabitacion());

    }

    @Override
    public int getItemCount() {
        return listaHabitaciones.size();
    }

}
