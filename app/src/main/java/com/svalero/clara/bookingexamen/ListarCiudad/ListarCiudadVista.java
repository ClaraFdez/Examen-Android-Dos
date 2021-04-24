package com.svalero.clara.bookingexamen.ListarCiudad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.svalero.clara.bookingexamen.Adaptadores.CiudadAdapter;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.Ficha.FichaVista;
import com.svalero.clara.bookingexamen.ListarFiltro.ListarFiltroVista;
import com.svalero.clara.bookingexamen.R;
import java.util.ArrayList;

public class ListarCiudadVista extends AppCompatActivity implements ListarCiudadContrato.View{

    String destinopasado;
    private ListarCiudadPresenter listarCiudadPresenter;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_ciudad_vista);


        recyclerView = (RecyclerView) findViewById(R.id.reciclerCiudad);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        Bundle bundle = getIntent().getExtras();
        destinopasado = bundle.getString("destinopasado");

        listarCiudadPresenter = new ListarCiudadPresenter(this);
        listarCiudadPresenter.getHotelesDestino(this, destinopasado);

    }


    @Override
    public void successCiudad(ArrayList<Hotel> listaHoteles) {

        CiudadAdapter adapterCiudad;
        adapterCiudad = new CiudadAdapter(listaHoteles);
        recyclerView.setAdapter(adapterCiudad);

        adapterCiudad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FichaVista.class);
                intent.putExtra("NombreHotelRowTodo", listaHoteles.get(recyclerView.getChildAdapterPosition(v)).getNombre());
                startActivity(intent);
            }
        });
    }

    @Override
    public void errorCiudad(String message) {
       message = "Error";
    }


    public void puntuacion(View v){
        Intent intent = new Intent(getApplicationContext(), ListarFiltroVista.class);
        intent.putExtra("ciudadPasada", destinopasado);
        intent.putExtra("filtro", "FIND_PUNTUACION");
        startActivity(intent);
    }

    public void precioAsc(View v){
        Intent intent = new Intent(getApplicationContext(), ListarFiltroVista.class);
        intent.putExtra("ciudadPasada", destinopasado);
        intent.putExtra("filtro", "PRECIO_ASC");
        startActivity(intent);
    }

    public void precioDes(View v){
        Intent intent = new Intent(getApplicationContext(), ListarFiltroVista.class);
        intent.putExtra("ciudadPasada", destinopasado);
        intent.putExtra("filtro", "PRECIO_DESC");
        startActivity(intent);
    }

    public void masReservados(View v){
        Intent intent = new Intent(getApplicationContext(), ListarFiltroVista.class);
        intent.putExtra("ciudadPasada", destinopasado);
        intent.putExtra("filtro", "RESERVADOS");
        startActivity(intent);
    }

}