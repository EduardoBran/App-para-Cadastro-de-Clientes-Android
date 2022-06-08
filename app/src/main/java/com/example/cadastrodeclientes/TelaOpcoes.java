package com.example.cadastrodeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class TelaOpcoes extends AppCompatActivity {

    private Button btnCadastrar;
    private Button btnCadastrados;
    private Button btnVoltar;
    private List<Cliente> clientesFiltrados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_opcoes);

        Intent it = getIntent();
        String nome = it.getStringExtra("p_nome");
        TextView tvBemVindo = findViewById(R.id.tv_bemVindo);
        tvBemVindo.setText("Administrador " + nome + " seja bem vindo !!!");

        btnCadastrar = findViewById(R.id.btn_cadastrar);
        btnCadastrados = findViewById(R.id.btn_cadastrados);
        btnVoltar = findViewById(R.id.btn_voltar);
    }

    public void telaCadastro(View v) {
        Intent it_telaCadastro = new Intent(this, TelaCadastro.class);
        startActivity(it_telaCadastro);
    }
    public void telaCadastrados(View v) {
        Intent it_telaCadastrados = new Intent(this, TelaListaCadastrados.class);
        startActivity(it_telaCadastrados);
    }
    public void telaListaExcluir(View v) {
        Intent it_telaListaExcluir = new Intent(this, TelaListaExcluir.class);
        startActivity(it_telaListaExcluir);
    }
    public void voltarTelaLogin(View v) {
        Intent it_voltarTelaLogin = new Intent(this, TelaLogin.class);
        startActivity(it_voltarTelaLogin);
    }
}