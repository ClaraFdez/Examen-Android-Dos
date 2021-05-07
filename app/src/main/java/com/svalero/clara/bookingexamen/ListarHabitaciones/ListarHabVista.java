package com.svalero.clara.bookingexamen.ListarHabitaciones;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.svalero.clara.bookingexamen.Fragments.HabitacionFragment;
import com.svalero.clara.bookingexamen.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

// va a coger los datos y mandarlos al fragment que va a contener y este se encargará de buscar los datos y presentarlos

public class ListarHabVista extends AppCompatActivity /*implements ListarHabContrato.View*/ {


    private int mes, dia, year;

    public String nombreHotel;
    public EditText fechaInicio;
    public EditText fechaFin;
    public EditText numPersonas;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_habitaciones);

       // recyclerView = (RecyclerView) findViewById(R.id.reciclerHabitacion);
       // recyclerView.setHasFixedSize(true);
       // layoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(layoutManager);

        fragmentManager = getSupportFragmentManager();
        inicializar();

        Bundle bundle = getIntent().getExtras();
        nombreHotel = bundle.getString("nombreHotelPasado");
            System.out.println("listarhabvista budle, nombreHotel: "+ nombreHotel);//------------------------------

        inicializar();

        fechaInicio.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                System.out.println("entrando en fecha inicia");
                elegirFechaEntrada(v);
            }
        });

        fechaFin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                System.out.println("entrando en fecha fin");
                elegirFechaSalida(v);
            }
        });
/*





        /*Bundle argumentos = new Bundle();
        argumentos.putString("nombreHotelPasado", nombreHotel);
        argumentos.putString("fechaInicio", fechaInicio.getText().toString());
        argumentos.putString("fechaFin", fechaFin.getText().toString());
        argumentos.putString("numPersonas", numPersonas.getText().toString());
        HabitacionFragment habitacionFragment = new HabitacionFragment();
        habitacionFragment.setArguments(argumentos);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_contenedor_habitacion, habitacionFragment);
        fragmentTransaction.commit();*/



       // fechaInicio = bundle.getString("fechaentrada");
       // fechaFin = bundle.getString("fechasalida");
       // numPersonas = bundle.getString("numPersonas");

       // listarHabPresenter = new ListarHabPresenter(this);
       // listarHabPresenter.getHabitaciones(this, fechaInicio, fechaFin, numPersonas, nombreHotel);

    }

    public void inicializar(){
        fechaInicio = findViewById(R.id.edtFechaInicio);
        fechaFin = findViewById(R.id.edtFechaFin);
        numPersonas = findViewById(R.id.edtNumPersonas);

    }


    public void buscarHabitacion(View view){
        Bundle argumentos = new Bundle();
        argumentos.putString("nombreHotelPasado", nombreHotel);
            System.out.println("listarhabvista, nombreHotel: "+ nombreHotel);//------------------------------
        argumentos.putString("fechaInicio", fechaInicio.getText().toString());
            System.out.println("listarhabvista, fechaInicio: "+ fechaInicio.getText().toString());//------------------------------
        argumentos.putString("fechaFin", fechaFin.getText().toString());
            System.out.println("listarhabvista, fechaFin: "+ fechaFin.getText().toString());//------------------------------
        argumentos.putString("numPersonas", numPersonas.getText().toString());
            System.out.println("listarhabvista, numPersonas: "+ numPersonas.getText().toString());//------------------------------

        HabitacionFragment habitacionFragment = new HabitacionFragment();
        habitacionFragment.setArguments(argumentos);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_contenedor_habitacion, habitacionFragment);
        fragmentTransaction.commit();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void elegirFechaEntrada(View v) {
        if(v == fechaInicio){
            final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        year = calendar.get(Calendar.YEAR);
            mes = calendar.get(Calendar.MONTH);
            dia = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fechaInicio.setText(dayOfMonth+ "/" +(month + 1)+ "/" + year);
                }
            }, year , mes , dia);
            datePickerDialog.show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void elegirFechaSalida(View v) {
        if(v == fechaFin){
            final Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
            mes = calendar.get(Calendar.MONTH);
            dia = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fechaFin.setText(dayOfMonth+ "/" +(month + 1)+ "/" + year);
                }
            }, year, mes, dia);
            datePickerDialog.show();
        }
    }





/*
    @Override
    public void successHab(ArrayList<Habitacion> listaHabitaciones) {
        HabitacionAdapter adapter = new HabitacionAdapter(listaHabitaciones);
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReservaVista.class);
                intent.putExtra("IdHabitacion", listaHabitaciones.get(recyclerView.getChildAdapterPosition(v)).getIdHabitacion());
                startActivity(intent);
            }

        });
    }

    @Override
    public void errorHab(String message) {
        message = "Error en la obtención de los datos del hotel";
    }
    */

}