package com.example.planetario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_detalles_planetas<Entidad> extends AppCompatActivity {
    private TextView tvTitulo, tvDescripcion;
    private ImageView imgFoto;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_planetas);
        TextView titulo = (TextView) findViewById(R.id.textoviewTitulo);
        TextView detalles = (TextView) findViewById(R.id.textovdescripcion);
        boton = findViewById(R.id.button);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null) {
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));
        }
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_detalles_planetas.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_back_out,R.anim.zoom_back_in);
            }
        });
    }
}