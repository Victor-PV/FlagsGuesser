package com.vipevi.proyectofinalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt, txt2;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("almacenamiento", Context.MODE_PRIVATE);
    }

//    public void onClick(View view){

        //       switch(view.getId()){
            //           case R.id.txtW:
                //             txt.setText("");
    //        break;
            //    }
            //  }

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
}