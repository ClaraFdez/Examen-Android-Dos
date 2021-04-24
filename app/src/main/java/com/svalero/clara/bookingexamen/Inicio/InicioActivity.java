package com.svalero.clara.bookingexamen.Inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.svalero.clara.bookingexamen.ListarTodo.ListarTodoVista;
import com.svalero.clara.bookingexamen.Login.MainActivity;
import com.svalero.clara.bookingexamen.R;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        final Handler handler = new Handler();
        handler.postDelayed(()-> {
            Intent intent = new Intent(getBaseContext(), ListarTodoVista.class);
            startActivity(intent);
            this.finish();
        }, 2500);
    }
}