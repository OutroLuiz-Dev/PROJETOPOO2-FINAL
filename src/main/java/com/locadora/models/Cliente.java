package com.locadora.models;

public class Cliente {
    private String id;
    private String nome;
    private String tipo; // Pessoa física ou jurídica

    public Cliente (){}
    public Cliente(String id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
