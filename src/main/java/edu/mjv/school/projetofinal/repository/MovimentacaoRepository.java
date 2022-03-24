package edu.mjv.school.projetofinal.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mjv.school.projetofinal.model.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{
	@Query("SELECT m FROM Movimentacao m WHERE m.id = :id")
	Optional<Movimentacao> findMovimentacaoById(@Param("id") Integer id);
	
	@Query("SELECT m FROM Movimentacao m WHERE m.log.criadoEm <= :criado_em")
    Optional<List<Movimentacao>> findAllWithCreationDate(@Param("criado_em") LocalDateTime criado_em);
	
	@Query("SELECT m FROM Movimentacao m WHERE m.empresa.id = :id_empresa")
    Optional<Movimentacao> findMovimentacaoByIdEmpresa(@Param("id_empresa") Integer id_empresa);
}
