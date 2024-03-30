package com.leotoloza.peliculas.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.leotoloza.peliculas.Modelo.Pelicula;
import com.leotoloza.peliculas.R;

public class DetalleMainActivity extends AppCompatActivity {
private SegundaViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_main);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(SegundaViewModel.class);
        vm.getMutablePelicula().observe(this, new Observer<Pelicula>() {
            @Override
            public void onChanged(Pelicula pelicula) {
                TextView titulo = findViewById(R.id.titulo2);
                TextView actores = findViewById(R.id.actores);
                TextView reseña = findViewById(R.id.reseña2);
                TextView director = findViewById(R.id.director);
                ImageView imagen = findViewById(R.id.imagen2);

                titulo.setText(pelicula.getTitulo());
                actores.setText("Actores: "+pelicula.getActores());
                reseña.setText(pelicula.getReseña());
                director.setText("Director: "+pelicula.getDirector());
                imagen.setImageResource(pelicula.getImagen());
            }
        });
      vm.recuperarPelicula(getIntent());
        Button btn = findViewById(R.id.btnAtras);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}