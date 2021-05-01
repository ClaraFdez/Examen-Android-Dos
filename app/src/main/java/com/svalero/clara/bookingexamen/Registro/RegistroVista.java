package com.svalero.clara.bookingexamen.Registro;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.svalero.clara.bookingexamen.Beans.Usuario;
import com.svalero.clara.bookingexamen.Login.MainActivity;
import com.svalero.clara.bookingexamen.R;


public class RegistroVista extends AppCompatActivity implements RegistroContrato.View{

    private EditText edtRegistroNombre;
    private EditText edtRegistroApe1;
    //private EditText edtRegistroApe2;
    private EditText edtRegistrodni;
    private EditText edtRegistroTelefono;
    private EditText edtRegistroEmail;
    private EditText edtRegistroPass;
    //private Button bttRegistroAceptar;

    String nombre, ape1, ape2, dni, email, pass;
    int tlf;

    public String idHabitacion;
    public String fechaInicio;
    public String fechaFin;
    public String nombreHotel;
    public String camasIndi;
    public String camasMat;
    public String precio;

    Usuario usuario;
    RegistroPresenter registroPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vista);

        inicializar();

        Bundle bundle = getIntent().getExtras();
        idHabitacion = Integer.toString(bundle.getInt("IdHabitacion"));
        fechaInicio = bundle.getString("FechaInicio");
        fechaFin = bundle.getString("FechaFin");
        camasIndi = Integer.toString(bundle.getInt("CamasIndi"));
        nombreHotel = bundle.getString("NombreHotel");
        camasMat = Integer.toString(bundle.getInt("CamasMat"));
        precio = Integer.toString(bundle.getInt("Precio"));

    }

    public void inicializar(){
        edtRegistroNombre = findViewById(R.id.edtRegistroNombre);
        edtRegistroApe1 = findViewById(R.id.edtRegistroApe1);
        edtRegistrodni = findViewById(R.id.edtRegistroDNI);
        edtRegistroTelefono = findViewById(R.id.edtRegistroTelefono);
        edtRegistroEmail = findViewById(R.id.edtRegistroEmail);
        edtRegistroPass = findViewById(R.id.edtRegistroPass);
    }

    public void registrarse(View view){
        obtenerDatos();
        usuario = new Usuario();
        usuario.setNombreUsuario(nombre);
        usuario.setApe1(ape1);
        usuario.setDni(dni);
        usuario.setEmail(email);
        usuario.setPass(pass);
        usuario.setTelefono(tlf);
        RegistroPresenter registroPresenter = new RegistroPresenter(this);
        registroPresenter.setUsuarioRegistro(this, usuario);
    }


    public void obtenerDatos(){
        nombre = edtRegistroNombre.getText().toString();
        ape1 = edtRegistroApe1.getText().toString();
        dni = edtRegistrodni.getText().toString();
        tlf = Integer.parseInt(edtRegistroTelefono.getText().toString());
        email = edtRegistroEmail.getText().toString();
        pass = edtRegistroPass.getText().toString();
    }


    @Override
    public void successRegistro(String success) {
        registrado(success);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("IdHabitacion", idHabitacion);
        intent.putExtra("FechaInicio", fechaInicio);
        intent.putExtra("FechaFin", fechaFin);
        intent.putExtra("NombreHotel", nombreHotel);
        intent.putExtra("CamasIndi", camasIndi);
        intent.putExtra("CamasMat", camasMat);
        intent.putExtra("Precio", precio);
        startActivity(intent);
    }

    @Override
    public void errorRegistro(String mensaje) {
        noRegistrado(mensaje);
    }


    public void registrado(String success){
        Toast.makeText(this, success, Toast.LENGTH_LONG);
    }

    public void noRegistrado(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG);
    }

}