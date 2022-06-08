package com.example.cadastrodeclientes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public Conexao conexao;
    public SQLiteDatabase banco;

    public ClienteDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put("matricula", cliente.getMatricula());
        values.put("nome", cliente.getNome());
        values.put("endereco", cliente.getEndereco());
        values.put("numero", cliente.getNumero());
        values.put("complemento", cliente.getComplemento());
        values.put("cidade", cliente.getCidade());

        return banco.insert("cliente", null, values);
    }
    public List<Cliente> obterTodos() {
        List<Cliente> clientes = new ArrayList<>();
        Cursor cursor = banco.query("cliente", new String[] {
                        "id", "matricula", "nome", "endereco", "numero", "complemento", "cidade"},
                null,null,null,null,null);

        while(cursor.moveToNext()) {
            Cliente c = new Cliente();
            c.setId(cursor.getInt(0));
            c.setMatricula(cursor.getInt(1));
            c.setNome(cursor.getString(2));
            c.setEndereco(cursor.getString(3));
            c.setNumero(cursor.getInt(4));
            c.setComplemento(cursor.getString(5));
            c.setCidade(cursor.getString(6));
            clientes.add(c);
        }
        return clientes;
    }

    public void excluir(Cliente c) {
        banco.delete("cliente", "id = ?", new String[] {c.getId().toString()});
    }
    public void atualizar(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        banco.update("cliente", values, "id = ?", new String[] {cliente.getId().toString()});
    }

}
