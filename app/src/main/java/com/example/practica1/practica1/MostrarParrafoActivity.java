package com.example.practica1.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MostrarParrafoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_parrafo);

        Intent intent = getIntent();
        String mensaje = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int number = Integer.parseInt(intent.getStringExtra("number"));
       // int numero = intent.getStringExtra("number");
        TextView textView = new TextView(this);
        textView.setTextSize(40);


        // El parrafo lo pasamos a un array
        String[] palabras = mensaje.split("\\s+");
        for (int i = 0; i < palabras.length; i++) {
            palabras[i] = palabras[i].replaceAll("[^\\w]", "");
        }
        //Random
        Random rand = new Random();
        String randomElement = "";
        for (int i = 0; i < number; i++) {
            int randomIndex = rand.nextInt(palabras.length);
            randomElement += palabras[randomIndex] + " ";
        }
        //Cantidad de palabras
        int cantidad = mensaje.split("\\s+|\n").length;
        textView.setText("La cantidad de palabras es : " + cantidad + " " + "Palabras Random : " + randomElement);

        ViewGroup layout = (ViewGroup)findViewById(R.id.activity_mostrar_parrafo);
        layout.addView(textView);
    }
}
