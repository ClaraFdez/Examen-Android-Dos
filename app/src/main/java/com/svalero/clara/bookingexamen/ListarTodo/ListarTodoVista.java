package com.svalero.clara.bookingexamen.ListarTodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.svalero.clara.bookingexamen.Adaptadores.ListarTodoAdapter;
import com.svalero.clara.bookingexamen.Beans.Hotel;
import com.svalero.clara.bookingexamen.Ficha.FichaVista;
import com.svalero.clara.bookingexamen.ListarCiudad.ListarCiudadVista;
import com.svalero.clara.bookingexamen.R;
import java.util.ArrayList;
import java.util.List;

public class ListarTodoVista extends AppCompatActivity implements ListarTodoContrato.View{

    private EditText edtTodoDestino;
    private ImageButton imgTodoBuscar;
    String destino;
    private ListarTodoPresenter listarTodoPresenter;
    private RecyclerView recyclerView;

    private View layoutError;
    private View layoutCargando;
    private View layoutListarTodo;

    private RecyclerView.LayoutManager layoutManager;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_todo_vista);

        fragmentManager = getSupportFragmentManager();
        inicializar();

        layoutCargando.setVisibility(View.VISIBLE);
        layoutListarTodo.setVisibility(View.GONE);
        layoutError.setVisibility(View.GONE);


System.out.println("1.Antes de getHoteles");//------------------------------------------------------------------
        listarTodoPresenter = new ListarTodoPresenter(this);
        listarTodoPresenter.getHoteles(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerTodo);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }


    public void buscarDestino(View view){
        destino = edtTodoDestino.getText().toString();
        Intent intent = new Intent(getApplicationContext(), ListarCiudadVista.class);
        intent.putExtra("destinopasado", destino);
        startActivity(intent);
    }

    public void botonReintentar(View view){
        layoutCargando.setVisibility(View.VISIBLE);
        listarTodoPresenter.getHoteles(this);
    }

    public void inicializar(){
        edtTodoDestino = findViewById(R.id.edtTodoDestino);
        layoutCargando = findViewById(R.id.layout_listar_todo_progressBar);
        layoutError = findViewById(R.id.layoutError);
        layoutListarTodo = findViewById(R.id.layoutListarTodo);
    }


    @Override
    public void success(ArrayList<Hotel> listaHoteles) {

        layoutCargando.setVisibility(View.GONE);
        layoutListarTodo.setVisibility(View.VISIBLE);

        ListarTodoAdapter adapter;
        adapter = new ListarTodoAdapter(listaHoteles);
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
        layoutCargando.setVisibility(View.GONE);
        layoutListarTodo.setVisibility(View.GONE);
        layoutError.setVisibility(View.VISIBLE);

        mensaje = "Error en la obtención de los datos";
    }
}