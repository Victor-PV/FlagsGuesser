package com.vipevi.proyectofinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pantallaAjustesActivity extends AppCompatActivity {

    private Button botonAtras, botonAplicar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_ajustes);

        botonAtras = (Button) findViewById(R.id.botonAtras);
        botonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pantallaAjustesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}