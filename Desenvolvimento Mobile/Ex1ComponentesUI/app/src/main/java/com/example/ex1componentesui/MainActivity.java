package com.example.ex1componentesui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex1componentesui.Model.Pessoa;

public class MainActivity extends AppCompatActivity {
    EditText edtNome;
    RadioGroup radioGroupSexo;
    Button btnEnviar;
    Switch switchNotificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    edtNome = (EditText) findViewById(R.id.txtNome);
    radioGroupSexo = (RadioGroup) findViewById(R.id.rdGroupSexo);
    btnEnviar = (Button) findViewById(R.id.cmdEnviar);
    switchNotificacao = (Switch) findViewById(R.id.swNotificacao);

btnEnviar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(edtNome.getText().toString());
        if(radioGroupSexo.getCheckedRadioButtonId() == R.id.rdFeminino){
            pessoa.setSexo("FEMININO");
        }else{
            pessoa.setSexo("MASCULINO");
        }

        if(switchNotificacao.isChecked()){
            pessoa.setNotificacao("RECEBER NOTIFICAÇÃO");
        }else{
            pessoa.setNotificacao("NÃO RECEBER NOTIFICAÇÃO");
        }

        Intent intencao = new Intent(MainActivity.this, SegundaActivity.class);
        intencao.putExtra("objeto", pessoa);
        startActivity(intencao);
    }
});
    }
}