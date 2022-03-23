package edu.mjv.school.projetofinal.dto;

import java.util.List;

import edu.mjv.school.projetofinal.model.TipoMovimentacao;

public class MovimentacaoDTO {
    private Integer id;

    private List<MovimentacaoItemDTO> itens;

    private TipoMovimentacao tipoMovimentacao;

    private Integer idEmpresa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public List<MovimentacaoItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<MovimentacaoItemDTO> itens) {
        this.itens = itens;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

}
