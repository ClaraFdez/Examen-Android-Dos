package com.svalero.clara.bookingexamen.Fin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.svalero.clara.bookingexamen.ListarTodo.ListarTodoVista;
import com.svalero.clara.bookingexamen.R;

public class Fin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        final Handler handler = new Handler();
        handler.postDelayed(()-> {
            System.exit(0);
            this.finish();
        }, 2500);
    }
}