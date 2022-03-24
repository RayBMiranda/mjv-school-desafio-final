package edu.mjv.school.projetofinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mjv.school.projetofinal.model.Categoria;
import edu.mjv.school.projetofinal.model.Movimentacao;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	@Query("SELECT c FROM Categoria c WHERE c.id = :id")
	Optional<Movimentacao> findCategoriaById(@Param("id") Integer id);
	
	@Query("SELECT c FROM Categoria c WHERE c.empresa.id = :id_empresa")
    Optional<List<Categoria>> findCategoriaByIdEmpresa(@Param("id_empresa") Integer id_empresa);
}
