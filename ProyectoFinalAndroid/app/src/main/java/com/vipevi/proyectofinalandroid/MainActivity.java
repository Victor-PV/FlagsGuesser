package com.vipevi.proyectofinalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txt, txt2;
    private Button botonRanking, botonAjustes, botonJugar, botonSalir;
    private SharedPreferences preferences;
    private ImageView banderaFondo, banderaFondo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("almacenamiento", Context.MODE_PRIVATE);

        botonRanking = (Button) findViewById(R.id.botonRanking);
        botonRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pantallaRankingActivity.class);
                startActivity(intent);
                finish();
            }
        });

        botonAjustes = (Button) findViewById(R.id.botonAjustes);
        botonAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pantallaAjustesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        botonSalir = (Button) findViewById(R.id.botonSalir);
        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imprmirbanderas();

    }

    public void datos(){
        int numero = (int) Math.ceil(Math.random() * 10);

        int num = preferences.getInt("numero", -1);
        txt2.setText("Num viejo: "+num);

        txt.setText("Num nuevo: " + numero);

        //Cargadasm falta mas
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        preferencesEditor.putInt("numero", numero);
        preferencesEditor.commit();

    }

    public void imprmirbanderas(){
        banderaFondo = (ImageView) findViewById(R.id.banderaFondo1);
        banderaFondo2 = (ImageView) findViewById(R.id.banderaFondo2);

        final TypedArray imgs = getResources().obtainTypedArray(R.array.apptour);
        final Random rand = new Random();
        final int rndInt = rand.nextInt(imgs.length());
        final int resID = imgs.getResourceId(rndInt, 0);

        banderaFondo2.setImageResource(resID);

        boolean isValido = false;
        while(!isValido){
            Random rand2 = new Random();
            int rndInt2 = rand2.nextInt(imgs.length());
            if(rndInt2 != rndInt){
                banderaFondo.setImageResource(imgs.getResourceId(rndInt2, 0));
                isValido = true;
            }
        }


    }
}