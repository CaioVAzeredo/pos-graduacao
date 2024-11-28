package com.example.financasPessoais;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financasPessoais.R;
import com.example.financasPessoais.adapters.AdapterDespesa;
import com.example.financasPessoais.adapters.AdapterReceita;
import com.example.financasPessoais.model.Despesa;
import com.example.financasPessoais.model.Receita;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tvTotalDespesa, tvTotalReceita, tvTotalLiquido;
    TabLayout tabLayout;
    RecyclerView recyclerDesepesas, recyclerReceitas;
    Button btnNovaDespesa, btnNovaReceita;
    private AdapterReceita receitaAdapter;
    private AdapterDespesa despesaAdapter;

    private Despesa despesaSelecionada;
    private Receita receitaSelecionada;
    private List<Despesa> listaDespesas = new ArrayList<>();
    private List<Receita> listaReceitas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //TextView
        tvTotalDespesa = (TextView) findViewById(R.id.lblTotalDespesa);
        tvTotalReceita = (TextView) findViewById(R.id.lblTotalReceita);
        tvTotalLiquido = (TextView) findViewById(R.id.lblValorLiquido);
        //TabLayout
        tabLayout = findViewById(R.id.tab_layout);

        //RecyclerView
        recyclerReceitas = (RecyclerView) findViewById(R.id.rvListaReceitas);
        recyclerDesepesas = (RecyclerView) findViewById(R.id.rvListaDespesas);
        //Buttons
        btnNovaDespesa = (Button) findViewById(R.id.cmdNovaDespesa);
        btnNovaReceita = (Button) findViewById(R.id.cmdNovaReceita);
        //Configuração do RecyclerView
        recyclerReceitas.setLayoutManager(new LinearLayoutManager(this));
        List<Receita> receitaList= new ArrayList<>();
        receitaList.add(new Receita(1,"ESCOLA",2000.00,new Date()));
        receitaList.add(new Receita(2,"MERCADO",5000.00,new Date()));
        receitaList.add(new Receita(3,"ACADEMIA",1000.00,new Date()));
        receitaList.add(new Receita(4,"PADARIA",500.00,new Date()));
        receitaList.add(new Receita(5,"RESTAURANTE",300.00,new Date()));
        receitaList.add(new Receita(6,"DOAÇÃO",2000.00,new Date()));

        receitaAdapter = new AdapterReceita(receitaList);

        recyclerReceitas.setAdapter(receitaAdapter);
        //fim da configuração do RecyclerView
        //Configurar o TabLayout
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){ //Despesa Visível
                    recyclerDesepesas.setVisibility(View.VISIBLE);
                    recyclerReceitas.setVisibility(View.GONE);
                    btnNovaDespesa.setVisibility(View.VISIBLE);
                    btnNovaReceita.setVisibility(View.GONE);
                }else{ //Receita Visível
                    recyclerDesepesas.setVisibility(View.GONE);
                    recyclerReceitas.setVisibility(View.VISIBLE);
                    btnNovaDespesa.setVisibility(View.GONE);
                    btnNovaReceita.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.addTab(tabLayout.newTab().setText("Despesa"));
        tabLayout.addTab(tabLayout.newTab().setText("Receita"));
    }
}