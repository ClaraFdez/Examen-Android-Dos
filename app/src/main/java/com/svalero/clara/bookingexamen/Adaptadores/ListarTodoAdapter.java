package com.svalero.clara.bookingexamen.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.R;

import java.util.ArrayList;
import java.util.List;

public class ListarTodoAdapter extends RecyclerView.Adapter<ListarTodoAdapter.HotelViewHolder> implements View.OnClickListener {

    private ArrayList<Hotel> listaHoteles;
    //private List<Hotel> listaHoteles;
    private View.OnClickListener listener;

    public static class HotelViewHolder extends RecyclerView.ViewHolder{

        public ImageView imagen;
        public TextView edtTodoNombre;
        public TextView edtTodoCiudad;
        public TextView edtPuntuacion;




        public HotelViewHolder(View v){
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imgListarTodo);
            edtTodoCiudad = (TextView) v.findViewById(R.id.edtTodoCiudad);
            edtTodoNombre = (TextView) v.findViewById(R.id.edtTodoNombre);
            edtPuntuacion = (TextView) v.findViewById(R.id.edtTodoPuntuacion);

        }

    }

    public ListarTodoAdapter (ArrayList<Hotel> listaHoteles){
        this.listaHoteles = listaHoteles;
    }

    /*public ListarTodoAdapter (List<Hotel> listaHoteles){
        this.listaHoteles = listaHoteles;
    }*/

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
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int i) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listar_todo_row, parent, false);
        v.setOnClickListener(this);

       return new HotelViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, int position) {
        String url = "http://192.168.1.124:8080/Booking_2/images/" + listaHoteles.get(position).getFoto() + ".jpg";

        Picasso.get().load(url).into(holder.imagen);
        holder.edtTodoNombre.setText(listaHoteles.get(position).getNombre());
        holder.edtTodoCiudad.setText(listaHoteles.get(position).getCiudad());
        holder.edtPuntuacion.setText("Puntuacion: " + listaHoteles.get(position).getPuntuacion());

    }

    @Override
    public int getItemCount() {
        return listaHoteles.size();
    }



}
