package com.example.ex1componentesui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex1componentesui.Model.Pessoa;

public class SegundaActivity extends AppCompatActivity {
    TextView tvNome, tvSexo, tvNotificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda);

        tvNome = (TextView) findViewById(R.id.lblNome);
        tvSexo = (TextView) findViewById(R.id.lblSexo);
        tvNotificacao = (TextView) findViewById(R.id.lblnotificacao);

        Bundle dados = getIntent().getExtras();
        Pessoa pessoa = (Pessoa) dados.getSerializable("objeto");
        setTitle("Segunda Activity");
        tvNome.setText(pessoa.getNome().toString());
        tvSexo.setText(pessoa.getSexo().toString());
        tvNotificacao.setText(pessoa.getNotificacao().toString());

    }
}