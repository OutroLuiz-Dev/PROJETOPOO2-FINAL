package com.locadora.models;

public class Veiculo {
    private String id;
    private String tipo; // Carro, Moto, Caminhão
    private String nome;
    private boolean disponivel;

    public Veiculo(String id, String tipo, String nome, boolean disponivel) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.disponivel = disponivel;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}
