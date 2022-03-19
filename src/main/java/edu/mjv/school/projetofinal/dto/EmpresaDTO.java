package edu.mjv.school.projetofinal.dto;

import java.util.List;

import javax.validation.constraints.Size;

import edu.mjv.school.projetofinal.model.Telefone;

public class EmpresaDTO {
    private Integer id;

    @Size(max = 14)
    private String cnpj;

    @Size(max = 60)
    private String nomeFantasia;

    @Size(max = 60)
    private String razaoSocial;

    private EnderecoDTO endereco;
    
    private List<String> emails;

    private List<Telefone> telefones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
