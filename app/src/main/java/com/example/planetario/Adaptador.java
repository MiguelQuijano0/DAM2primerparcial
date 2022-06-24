package com.example.planetario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class Adaptador extends BaseAdapter {


    private static LayoutInflater inflater = null;
    Context contexto;
    String[][] datos;
    int[] datosImg;

    public Adaptador(Context conexto, String[][] datos, int[] imagenes) {
        this.contexto = conexto;
        this.datos = datos;
        this.datosImg = imagenes;

        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView titulo = (TextView) vista.findViewById(R.id.textvTitulo);
        TextView duracion = (TextView) vista.findViewById(R.id.tvRotacion);
        TextView director = (TextView) vista.findViewById(R.id.tvtipoplaneta);

        ImageView imagen = (ImageView) vista.findViewById(R.id.ivImagen);

        titulo.setText(datos[i][0]);
        director.setText(datos[i][1]);
        duracion.setText("Tiempo de rotacion " + datos[i][2]);
        imagen.setImageResource(datosImg[i]);

        imagen.setTag(i);

        Animation animation = AnimationUtils.loadAnimation(contexto, android.R.anim.slide_in_left);
        vista.startAnimation(animation);

        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}