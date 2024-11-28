package com.example.intentexplicita;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.intentexplicita.Model.Usuario;

public class MainActivity extends AppCompatActivity {
EditText edtUsuario, edtSenha;
Button btnLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.txtUsuario);
        edtSenha = (EditText) findViewById(R.id.txtSenha);
        btnLogar = (Button) findViewById(R.id.cmdLogar);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();
                Intent intencao = new Intent(MainActivity.this, SegundaActivity.class);
                usuario.setEmail(edtUsuario.getText().toString());
                usuario.setSenha(edtSenha.getText().toString());
                /*
                intencao.putExtra("email", edtUsuario.getText().toString());
                intencao.putExtra("senha", edtSenha.getText().toString());
                 */
                intencao.putExtra("objeto", usuario);
                startActivity(intencao);
            }
        });
    }
}