package edu.mjv.school.projetofinal.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produtos", uniqueConstraints = { @UniqueConstraint(columnNames = { "empresa_id", "codigo_interno" }),
		@UniqueConstraint(columnNames = { "empresa_id", "ean" }) })
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// 999.999.999
	@Column(length = 9, name = "codigo_interno")
	private String codigoInterno;

	@Column(length = 13, name = "ean")
	private String ean;

	@Column(length = 60)
	@NotNull
	private String descricao;

	@Column(scale = 2, precision = 10)
	@NotNull
	private BigDecimal precoVenda;

	@Column(scale = 2, precision = 10)
	private BigDecimal precoCusto;

	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoUnidade tipoUnidade;

	@ManyToOne
	private Categoria categoria;

	@Column(scale = 2, precision = 10)
	private BigDecimal estoque;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@Embedded
	private Log log;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ id=".concat(String.valueOf(id)));
		sb.append(" ean=".concat(ean));
		sb.append(" descricao=".concat(descricao));
		sb.append(" estoque=".concat(String.valueOf(estoque)));
		sb.append(" precoVenda=".concat(String.valueOf(precoVenda)).concat("]"));
		return sb.toString();
	}

	@PrePersist
	public void prePersist() {
		if (codigoInterno == null)
			codigoInterno = String.valueOf(id);
		log = new Log();
		log.setCriadoEm(LocalDateTime.now());
		if (precoCusto.compareTo(new BigDecimal(0)) > 0 && (precoVenda == BigDecimal.ZERO || precoVenda == null)) {
			BigDecimal margemLucroMulti = categoria.getMargemLucroMedia().divide(new BigDecimal(100.0));
			BigDecimal lucro = precoCusto.multiply(margemLucroMulti);
			precoVenda = precoCusto.add(lucro);
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

	public String getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public BigDecimal getEstoque() {
		return estoque;
	}

	public void setEstoque(BigDecimal estoque) {
		this.estoque = estoque;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
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

	public TipoUnidade getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(TipoUnidade tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}
}
