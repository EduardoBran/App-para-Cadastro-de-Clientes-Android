package com.example.cadastrodeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TelaListaCadastrados extends AppCompatActivity {

    private ListView listView;
    private ClienteDAO dao;
    private List<Cliente> clientes;
    private List<Cliente> clientesFiltrados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_cadastrados);

        listView = findViewById(R.id.lv_clientes);
        dao = new ClienteDAO(this);
        clientes = dao.obterTodos();
        clientesFiltrados.addAll(clientes);

        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(this,
                android.R.layout.simple_list_item_1, clientesFiltrados);
        listView.setAdapter(adapter);
    }
    public void procuraCliente(String nome){
        clientesFiltrados.clear();
        for(Cliente c: clientes){
            if(c.getNome().toLowerCase().contains(nome.toLowerCase())){
                clientesFiltrados.add(c);
            }
        }
        listView.invalidateViews();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);
        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                procuraCliente(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                System.out.println("Digitou " + s);
                return false;
            }
        });
        return true;
    }
    public void cadastrar(MenuItem item) {
        Intent it = new Intent(this, TelaCadastro.class);
        startActivity(it);
    }
    @Override
    public void onResume() {
        super.onResume();
        clientes = dao.obterTodos();
        clientesFiltrados.clear();
        clientesFiltrados.addAll(clientes);
        listView.invalidateViews();
    }
}