package edu.mjv.school.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mjv.school.projetofinal.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    @Query("SELECT DISTINCT p FROM Produto p INNER JOIN p.empresa e")
    Produto findProdutoById(Integer id);
}
