package com.leotoloza.peliculas.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.leotoloza.peliculas.Modelo.Pelicula;
import com.leotoloza.peliculas.R;
import com.leotoloza.peliculas.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ActivityMainViewModel mv;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = new Intent();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ActivityMainViewModel.class);
        mv.getListaMutable().observe(this, new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {
                PeliculaAdapter pa = new PeliculaAdapter(peliculas, MainActivity.this,getLayoutInflater());
                GridLayoutManager glm=new GridLayoutManager(MainActivity.this,2,GridLayoutManager.VERTICAL,false);
                RecyclerView rc=binding.lista;
                rc.setLayoutManager(glm);
                rc.setAdapter(pa);
            }
        });
mv.crearLista();
    }
}