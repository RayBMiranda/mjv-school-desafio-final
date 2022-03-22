package edu.mjv.school.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mjv.school.projetofinal.model.MovimentacaoItem;

@Repository
public interface MovimentacaoItemRepository extends JpaRepository<MovimentacaoItem, Integer>{
    
}
