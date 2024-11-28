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

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("Segunda Activity");

    }

    @Override
    protected void onStart() {
        Toast.makeText(SegundaActivity.this, "Método OnStart Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método OnStart Ativado");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(SegundaActivity.this, "Método onResume Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método onResume Ativado");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Toast.makeText(SegundaActivity.this, "Método onPause Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método OnPause Ativado");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(SegundaActivity.this, "Método onRestart Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método onRestart Ativado");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(SegundaActivity.this, "Método onStop Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método onStop Ativado");
        super.onStop();
    }

    @Override
    protected void onDestroy() {

        Toast.makeText(SegundaActivity.this, "Método onDestroy Ativado!!", Toast.LENGTH_SHORT).show();
        Log.i("Ciclo de vida!!", "Método onDestroy Ativado");
        super.onDestroy();
    }
}