package com.svalero.clara.bookingexamen.Login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.svalero.clara.bookingexamen.Beans.Usuario;
import com.svalero.clara.bookingexamen.ListarTodo.ListarTodoVista;
import com.svalero.clara.bookingexamen.R;
import com.svalero.clara.bookingexamen.Registro.RegistroVista;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoginContrato.View{
    private EditText edtLoginUsuario;
    private EditText edtLoginPass;

    private LoginPresenter loginPresenter;
    private ArrayList<Usuario> listaUsuario2;
    public boolean resultado;

    public String nombre;
    public String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

    }

    public void inicializar(){
        edtLoginUsuario = findViewById(R.id.edtLoginUsuario);
        edtLoginPass = findViewById(R.id.edtLoginPass);
    }

    public void obtenerValores(){
        nombre = edtLoginUsuario.getText().toString();
        pass = edtLoginPass.getText().toString();
    }

    public void errorUsuario(){
        Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
    }

    public void errorRegistro(){
        Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
    }

    public void loginEntrar(View view){
        obtenerValores();
        loginPresenter = new LoginPresenter(this);
        loginPresenter.getLogin(this, nombre, pass);
       // Intent i = new Intent(getApplicationContext(),ListarTodoVista.class);
        //startActivity(i);
    }

    public void loginRegistrar (View view){
        Intent i = new Intent(getApplicationContext(), RegistroVista.class);
        startActivity(i);
        /*Intent i = new Intent(getApplicationContext(),ListarTodoVista.class);
        startActivity(i);*/
    }

    public boolean comprobar(ArrayList<Usuario> listaUsuario2){ //-------------- quizas en registroview
        obtenerValores();
        boolean resp = true;
        for ( int i = 0; i<listaUsuario2.size(); i++){
            if(nombre == listaUsuario2.get(i).getEmail()){
                resp = false;
            }
        }
        return resp;
    }

    @Override
    public void success(ArrayList<Usuario> listaUsuario) {
        if(! listaUsuario.isEmpty()) {
            if((listaUsuario.get(0).getEmail()).equalsIgnoreCase("null")){
               errorUsuario();
               edtLoginPass.setText("");
               edtLoginUsuario.setText("");
            }else{
                Intent i = new Intent(getApplicationContext(), ListarTodoVista.class);
                startActivity(i);
            }
        }
    }

    @Override
    public void error(String message) {
        errorUsuario();
    }



}