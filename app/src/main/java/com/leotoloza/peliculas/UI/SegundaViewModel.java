package com.leotoloza.peliculas.UI;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.leotoloza.peliculas.Modelo.Pelicula;


public class SegundaViewModel extends AndroidViewModel {

    private MutableLiveData<Pelicula> mutablePelicula;


    public SegundaViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Pelicula> getMutablePelicula() {
        if (mutablePelicula==null){
            mutablePelicula=new MutableLiveData<>();
        }

        return mutablePelicula;
    }


    public void recuperarPelicula(Intent intent){

        Pelicula pelicula=(Pelicula)intent.getSerializableExtra("pelicula");

        if (pelicula!=null){
        //pelicula.getActores();

            mutablePelicula.setValue(pelicula);
        }
    }
}


