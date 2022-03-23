package edu.mjv.school.projetofinal.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

public class CategoriaDTO {
    private Integer id;
    @Size(max = 60)
    private String descricao;
    private BigDecimal margemLucroMedia;
    private Integer idEmpresa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getMargemLucroMedia() {
        return margemLucroMedia;
    }

    public void setMargemLucroMedia(BigDecimal margemLucroMedia) {
        this.margemLucroMedia = margemLucroMedia;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
