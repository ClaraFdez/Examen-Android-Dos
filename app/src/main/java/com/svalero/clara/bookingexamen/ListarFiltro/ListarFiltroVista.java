package com.svalero.clara.bookingexamen.ListarFiltro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.svalero.clara.bookingexamen.Adaptadores.CiudadAdapter;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.Ficha.FichaVista;
import com.svalero.clara.bookingexamen.R;
import java.util.ArrayList;

public class ListarFiltroVista extends AppCompatActivity /*implements ListarFiltroContrato.View*/{

    /*private ListarFiltroPresenter listarFiltroPresenter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private TextView precio;

    String filtroPasado;
    String ciudadPasada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_filtro_vista);

        //bundle con el filtro en concreto que se desea
        Bundle bundle = getIntent().getExtras();
        filtroPasado = bundle.getString("filtro");
        ciudadPasada = bundle.getString("ciudadPasada");



        listarFiltroPresenter = new ListarFiltroPresenter(this);
        listarFiltroPresenter.getHotelesFiltro(this, filtroPasado,ciudadPasada);

        recyclerView = (RecyclerView) findViewById(R.id.reciclerFiltro);//nombre recycler en el html
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }


    @Override
    public void success(ArrayList<Hotel> listaHoteles) {
        CiudadAdapter adapter;
        adapter = new CiudadAdapter(listaHoteles);
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FichaVista.class);
                intent.putExtra("NombreHotelRowTodo", listaHoteles.get(recyclerView.getChildAdapterPosition(v)).getNombre());
                startActivity(intent);
            }
        });

    }

    @Override
    public void error(String mensaje) {
        mensaje = "Error en la obtención de los datos";
    }*/
}