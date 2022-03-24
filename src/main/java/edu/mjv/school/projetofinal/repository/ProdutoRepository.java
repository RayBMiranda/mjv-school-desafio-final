package edu.mjv.school.projetofinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mjv.school.projetofinal.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	@Query("SELECT p FROM Produto p WHERE p.empresa.id = :id_empresa")
    Optional<List<Produto>> findProdutoByIdEmpresa(@Param("id_empresa") Integer id_empresa);
}
