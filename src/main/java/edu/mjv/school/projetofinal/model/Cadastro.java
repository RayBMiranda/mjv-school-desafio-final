package edu.mjv.school.projetofinal.model;

public class Cadastro {
    private Integer id;
    private String nome;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "id = " + this.id + "nome = " + this.nome;
    }

    
}
