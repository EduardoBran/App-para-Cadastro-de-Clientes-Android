package com.example.cadastrodeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLogin extends AppCompatActivity {

    private EditText et_usuario;
    private EditText et_senha;
    private Button btn_acessar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        et_usuario = findViewById(R.id.et_usuario);
        et_senha = findViewById(R.id.et_senha);
        btn_acessar = findViewById(R.id.btn_acessar);
    }

    public void abrir_tela_opcoes(View v) {
        String etUsuario = et_usuario.getText().toString();
        String etSenha = et_senha.getText().toString();

        if(et_usuario.getText().length() == 0 || et_senha.getText().length() == 0){
            Toast.makeText(this, "Os campos de login e senha são obrigatórios!",
                    Toast.LENGTH_LONG).show();
        }
        else{
            if(etUsuario.equals("edu") && etSenha.equals("123")) {
                Intent it_telaCadastro = new Intent(this, TelaOpcoes.class);
                it_telaCadastro.putExtra("p_nome", et_usuario.getText().toString());
                startActivity(it_telaCadastro);
            }
            else{
                Toast.makeText(this, "LOGIN OU SENHA INVÁLIDOS!",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}