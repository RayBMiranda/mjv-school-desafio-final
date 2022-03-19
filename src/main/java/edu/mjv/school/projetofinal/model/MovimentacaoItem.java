package edu.mjv.school.projetofinal.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.mjv.school.projetofinal.dto.MovimentacaoItemDTO;

@Entity
@Table(name = "movimentacoes_itens")
public class MovimentacaoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    private Produto produto;

    @Column(scale = 2, precision = 10)
    private BigDecimal quantidade;
    @Column(scale = 2, precision = 10)
    private BigDecimal precoCusto;
    @Column(scale = 2, precision = 10)
    private BigDecimal precoVenda;

    @ManyToOne(cascade = CascadeType.ALL)
    private Movimentacao movimentacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    /*@PrePersist
    public void prePersist() {
        if(movimentacao.getTipoMovimentacao() == TipoMovimentacao.ENTRADA)
            produto.setEstoque(produto.getEstoque().add(quantidade));
        else
            produto.setEstoque(produto.getEstoque().subtract(quantidade));
    }*/

    public MovimentacaoItemDTO _toConvertMovimentacaoItemDTO(){
        MovimentacaoItemDTO dto = new MovimentacaoItemDTO();
        dto.setId(id);
        dto.setPrecoCusto(precoCusto);
        dto.setPrecoVenda(precoVenda);
        dto.setIdProduto(produto.getId());
        dto.setQuantidade(quantidade);
        return dto;
     }
}
