package edu.mjv.school.projetofinal.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import edu.mjv.school.projetofinal.dto.MovimentacaoDTO;
import edu.mjv.school.projetofinal.dto.MovimentacaoItemDTO;

@Entity
@Table(name = "movimentacoes")
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movimentacao_id")
    private List<MovimentacaoItem> itens = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoMovimentacao tipoMovimentacao;

    @ManyToOne
    private Empresa empresa;

    private Log log;

    @PrePersist
    public void prePersist() {
        log = new Log();
        log.setCriadoEm(LocalDateTime.now());
        boolean isEntrada = tipoMovimentacao == TipoMovimentacao.ENTRADA;
        BigDecimal estoqueAtual = new BigDecimal(0);
        BigDecimal estoqueMovimentado = new BigDecimal(0);
        for (int i = 0; i < itens.size(); i++) {
            estoqueAtual = itens.get(i).getProduto().getEstoque();
            estoqueMovimentado = itens.get(i).getQuantidade();
            if(isEntrada)
                itens.get(i).getProduto().setEstoque(estoqueAtual.add(estoqueMovimentado));
            else
                itens.get(i).getProduto().setEstoque(estoqueAtual.subtract(estoqueMovimentado));
        }
    }
 
    @PreUpdate
    public void preUpdate() {
        log.setAlteradoEm(LocalDateTime.now());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<MovimentacaoItem> getItens() {
        return itens;
    }

    public void setItens(List<MovimentacaoItem> itens) {
        this.itens = itens;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
    
    public MovimentacaoDTO _toConvertMovimentacaoDTO(){
        MovimentacaoDTO dto = new MovimentacaoDTO();
        dto.setId(id);
        dto.setIdEmpresa(empresa.getId());
        dto.setTipoMovimentacao(tipoMovimentacao);
        dto.setItens(new ArrayList<MovimentacaoItemDTO>());
        for (MovimentacaoItem movimentacaoItem : itens) {
            MovimentacaoItemDTO itemDTO = new MovimentacaoItemDTO();
            itemDTO = movimentacaoItem._toConvertMovimentacaoItemDTO();
            dto.getItens().add(itemDTO);
        }
        return dto;
     }

    public void addItem(MovimentacaoItem movimentacaoItem) {
        this.itens.add(movimentacaoItem);
    }
}
