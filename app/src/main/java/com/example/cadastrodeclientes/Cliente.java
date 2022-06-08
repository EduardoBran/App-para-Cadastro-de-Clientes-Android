package com.example.cadastrodeclientes;

import java.io.Serializable;

public class Cliente implements Serializable {

    private Integer id;
    private Integer matricula;
    private String nome;
    private String endereco;
    private Integer numero;
    private String complemento;
    private String cidade;

    public Cliente() {
    }

    public Cliente(Integer id, Integer matricula, String nome, String endereco, Integer numero, String complemento, String cidade) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {

        return "Matrícula - " + matricula +
                "\nNome - " + nome +
                "\nEndereço: " + endereco +
                ". Nº: " + numero +
                "\nComplemento: " + complemento +
                "\nCidade: " + cidade;

//        return "Cliente{" +
//                "id=" + id +
//                ", matricula=" + matricula +
//                ", nome='" + nome + '\'' +
//                ", endereco='" + endereco + '\'' +
//                ", numero=" + numero +
//                ", complemento='" + complemento + '\'' +
//                ", cidade='" + cidade + '\'' +
//                '}';
    }
}
