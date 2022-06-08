package com.example.cadastrodeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;

public class TelaCadastro extends AppCompatActivity {

    private EditText etMatricula;
    private EditText etNome;
    private EditText etEndereco;
    private EditText etNumero;
    private EditText etComplemento;
    private EditText etCidade;
    private Button btnGravar;
    private Button btnVoltar;
    private ClienteDAO dao;
    private Cliente cliente = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        etMatricula = findViewById(R.id.et_matricula);
        etNome = findViewById(R.id.et_nome);
        etEndereco = findViewById(R.id.et_endereco);
        etNumero = findViewById(R.id.et_numero);
        etComplemento = findViewById(R.id.et_complemento);
        etCidade = findViewById(R.id.et_cidade);
        btnGravar = findViewById(R.id.btn_gravar);
        btnVoltar = findViewById(R.id.btn_voltar);
        dao = new ClienteDAO(this);

        Intent it = getIntent();
        if (it.hasExtra("cliente")) {
            cliente = (Cliente) it.getSerializableExtra("cliente");
            etNome.setText(cliente.getNome());
        }
    }
    public void gravar(View v) {
        if (cliente == null) {
            Cliente c = new Cliente();
            c.setMatricula(Integer.valueOf(etMatricula.getText().toString()));
            c.setNome(etNome.getText().toString());
            c.setEndereco(etEndereco.getText().toString());
            c.setNumero(Integer.valueOf(etNumero.getText().toString()));
            c.setComplemento(etComplemento.getText().toString());
            c.setCidade(etCidade.getText().toString());

            long id = dao.inserir(c);
            Toast.makeText(this, "Cliente cadastrado com id: " + id, Toast.LENGTH_SHORT).show();
        }else{
            cliente.setNome(etNome.getText().toString());
            dao.atualizar(cliente);
            Toast.makeText(this, "Cliente ATUALIZADO com suceso.", Toast.LENGTH_SHORT).show();
        }
    }
    public void voltarTelaOpcoes(View v) {
        Intent it_listarTodos = new Intent(this, TelaOpcoes.class);
        startActivity(it_listarTodos);
    }
}