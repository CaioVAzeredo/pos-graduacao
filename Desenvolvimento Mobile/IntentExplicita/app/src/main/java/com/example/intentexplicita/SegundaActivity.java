package com.example.intentexplicita;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.intentexplicita.Model.Usuario;

public class SegundaActivity extends AppCompatActivity {
    TextView tvEmail, tvSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda);

        tvEmail = (TextView) findViewById(R.id.ldlEmail);
        tvSenha = (TextView) findViewById(R.id.lblSenha);
        //Recebendo os dados da tela MainActivity - Bundle(Extras)
        Bundle dados = getIntent().getExtras();
        Usuario usuario = (Usuario) dados.getSerializable("objeto");

        /*
        String usuario =dados.getString("email");
        String senha =dados.getString("senha");

         */
        tvEmail.setText(usuario.getEmail().toString());
        tvSenha.setText(usuario.getSenha().toString());

    }
}