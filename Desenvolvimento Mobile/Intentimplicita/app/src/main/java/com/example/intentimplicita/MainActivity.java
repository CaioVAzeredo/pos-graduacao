package com.example.intentimplicita;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtURL, edtTelefone;
    Button btnAbrirNavegador, btnLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*
            URL
        */
        edtURL = (EditText) findViewById(R.id.txtURL);
        btnAbrirNavegador = (Button) findViewById(R.id.cmdAbrirNavegador);

        btnAbrirNavegador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencao = new Intent(Intent.ACTION_VIEW, Uri.parse(edtURL.getText().toString()));
                startActivity(intencao);
            }
        });

        /*
            LIGAR
        */
        edtTelefone = (EditText) findViewById(R.id.txtTelefone);
        btnLigar = (Button) findViewById(R.id.cmdLigar);

        btnLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telefone = edtTelefone.getText().toString();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", telefone, null));
                startActivity(intent);
            }
        });
    }
}