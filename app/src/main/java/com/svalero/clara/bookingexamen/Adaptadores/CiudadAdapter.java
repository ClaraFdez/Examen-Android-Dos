package com.svalero.clara.bookingexamen.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.R;

import java.util.ArrayList;

public class CiudadAdapter extends RecyclerView.Adapter<CiudadAdapter.CiudadViewHolder> implements View.OnClickListener {

    private ArrayList<Hotel> listaHoteles;
    private View.OnClickListener listener;

    public static class CiudadViewHolder extends RecyclerView.ViewHolder{

        public ImageView imagen;
        public TextView edtCiudadNombre;
        public TextView edtCiudad;
        public TextView edtCiudadPuntuacion;
        public TextView edtPrecio;


        public CiudadViewHolder(View v){
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imgCiudad);
            edtCiudad = (TextView) v.findViewById(R.id.edtCiudad);
            edtCiudadNombre = (TextView) v.findViewById(R.id.edtCiudadNombre);
            edtCiudadPuntuacion = (TextView) v.findViewById(R.id.edtCiudadPuntuacion);
            edtPrecio = (TextView) v.findViewById(R.id.txtCiudadPrecio);

        }

    }

    public CiudadAdapter (ArrayList<Hotel> listaHoteles){
        this.listaHoteles = listaHoteles;
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
    public CiudadViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ciudad_row, parent, false);
        v.setOnClickListener(this);
        return new CiudadViewHolder(v);
    }



    @Override
    public void onBindViewHolder(CiudadViewHolder holder, int position) {
        String url = "http://192.168.1.124:8080/Booking_2/images/" + listaHoteles.get(position).getFoto() + ".jpg";

        Picasso.get().load(url).into(holder.imagen);
        holder.edtCiudadNombre.setText(listaHoteles.get(position).getNombre());
        holder.edtCiudad.setText(listaHoteles.get(position).getCiudad());
        holder.edtCiudadPuntuacion.setText("Puntuacion: " + listaHoteles.get(position).getPuntuacion());
        holder.edtPrecio.setText(listaHoteles.get(position).getPrecio()+ " euros");

    }



    @Override
    public int getItemCount() {
        return listaHoteles.size();
    }
}
