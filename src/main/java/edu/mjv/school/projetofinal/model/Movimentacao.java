package edu.mjv.school.projetofinal.model;

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

    @OneToMany(mappedBy = "movimentacao", cascade = CascadeType.ALL)
    private List<MovimentacaoItem> itens = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoMovimentacao tipoMovimentacao;

    @ManyToOne
    private Empresa empresa;

    private Log log;

    @PrePersist
    public void prePersist() {
        if(log == null)
            log = new Log();
        log.setCriadoEm(LocalDateTime.now());
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
        movimentacaoItem.setMovimentacao(this);
        this.itens.add(movimentacaoItem);
    }
}
