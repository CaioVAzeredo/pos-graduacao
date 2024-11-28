package com.example.menucontexto4;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.menucontexto4.R;

public class MainActivity extends AppCompatActivity {

    ListView listViewFilmes;
    private String[] filmes = {"Forest Gump", "Star Treck", "Senhor dos Anéis", "Diário de Uma Paixão", "Esqueceram de Mim", "Exterminador do Futuro", "Duro de Matar", "Justiça", "24 Horas", "O Silo", "Breaking Bad", "Lista Terminal", "Prison Break", "Dark Marter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listViewFilmes = (ListView) findViewById(R.id.lstFilmes);
        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, filmes);
        listViewFilmes.setAdapter(arrayAdapter);
        registerForContextMenu(listViewFilmes);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("TITULO DE MENU DE CONTEXTO");
        menu.add(0,v.getId(),0, "UPLOAD");
        menu.add(1,v.getId(),1, "PESQUISAR");
        menu.add(2,v.getId(),2, "EXCLUIR");
        menu.add(3,v.getId(),3, "ALTERAR");
    }
}