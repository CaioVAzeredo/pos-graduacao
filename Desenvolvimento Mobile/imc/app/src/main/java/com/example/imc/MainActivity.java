package com.example.imc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tvIMC, tvClassificacao;
    EditText edtPeso, edtAltura;
    Button btnClassificacaoIMC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvIMC = (TextView) findViewById(R.id.lblIMC);
        tvClassificacao = (TextView) findViewById(R.id.lblClassificacao);
        edtAltura = (EditText) findViewById(R.id.txtAltura);
        edtPeso = (EditText) findViewById(R.id.txtPeso);
        btnClassificacaoIMC = (Button) findViewById(R.id.button);

        btnClassificacaoIMC.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double imc, peso, altura;
                peso = Double.parseDouble(edtPeso.getText().toString());
                altura = Double.parseDouble(edtAltura.getText().toString());
                imc = peso / (altura * altura);

                tvIMC.setText(String.valueOf(imc));

                if(imc < 16.9){
                    tvClassificacao.setText("Pessoa MUITO a baixo do peso");
                } else if(imc > 17 && imc < 18.4){
                    tvClassificacao.setText("Pessoa a baixo do peso");
                }else if(imc > 18.5 && imc < 24.9){
                    tvClassificacao.setText("Peso normal");
                }else if(imc > 25 && imc < 29.9){
                    tvClassificacao.setText("Acima do peso");
                }else if(imc > 30 && imc < 34.9){
                    tvClassificacao.setText("Obesidade grau 1");
                }else if(imc > 35 && imc < 40){
                    tvClassificacao.setText("Obesidade grau 2");
                }else if(imc > 40){
                    tvClassificacao.setText("Obesidade grau 3");
                }


            }
        }));

    }
}