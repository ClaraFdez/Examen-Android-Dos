package com.svalero.clara.bookingexamen.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.R;

import java.util.ArrayList;


public class ListarTodoAdapter extends RecyclerView.Adapter<ListarTodoAdapter.HotelViewHolder> implements View.OnClickListener {

    private ArrayList<Hotel> listaHoteles;
    private View.OnClickListener listener;
    //nuevo
    private Context context;
    //fin nuevo

    public static class HotelViewHolder extends RecyclerView.ViewHolder{

        public ImageView imagen;
        public TextView edtTodoNombre;
        public TextView edtTodoCiudad;
        public TextView edtPuntuacion;
        //nuevo
        public CardView cardViewListarTodo;
        //fin nuevo


        public HotelViewHolder(View v){
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imgListarTodo);
            edtTodoCiudad = (TextView) v.findViewById(R.id.edtTodoCiudad);
            edtTodoNombre = (TextView) v.findViewById(R.id.edtTodoNombre);
            edtPuntuacion = (TextView) v.findViewById(R.id.edtTodoPuntuacion);
            //nuevo
            cardViewListarTodo = (CardView) v.findViewById(R.id.cv_listar_todo);
            //fin nuevo

        }

    }
/*
    public ListarTodoAdapter (ArrayList<Hotel> listaHoteles){
        this.listaHoteles = listaHoteles;
    }
*/

    //nuevo
    public ListarTodoAdapter (ArrayList<Hotel> listaHoteles, Context context){
        this.listaHoteles = listaHoteles;
        this.context = context;
    }
    //fin nuevo


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
        //nuevo
        holder.cardViewListarTodo.setAnimation(AnimationUtils.loadAnimation(context, R.anim.transicion_cv));
        //fin nuevo

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
