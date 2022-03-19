package edu.mjv.school.projetofinal.dto;

import javax.validation.constraints.Size;

public class EnderecoDTO {
    private Integer id;

    @Size(max = 255)
    private String logradouro;

    @Size(max = 60)
    private String numero;

    @Size(max = 60)
    private String bairro;

    @Size(max = 60)
    private String cidade;
    
    @Size(max = 8)
    private String cep;

    private Integer idUF;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getIdUf() {
        return idUF;
    }

    public void setIdUf(Integer idUF) {
        this.idUF = idUF;
    }
}
