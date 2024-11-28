package com.example.ciclodevida;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnEnviar = (Button)findViewById(R.id.cmdEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencao = new Intent(MainActivity.this, SegundaActivity.class);
                startActivity(intencao);
            }
        });
    }

    @Override
    protected void onStart() {
        Toast.makeText(MainActivity.this, "Método OnStart Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método OnStart Ativado");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(MainActivity.this, "Método onResume Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método onResume Ativado");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Toast.makeText(MainActivity.this, "Método onPause Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método OnPause Ativado");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(MainActivity.this, "Método onRestart Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método onRestart Ativado");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(MainActivity.this, "Método onStop Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método onStop Ativado");
        super.onStop();
    }

    @Override
    protected void onDestroy() {

        Toast.makeText(MainActivity.this, "Método onDestroy Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método onDestroy Ativado");
        super.onDestroy();
    }
}