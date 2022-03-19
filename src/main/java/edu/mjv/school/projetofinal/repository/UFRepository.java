package edu.mjv.school.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mjv.school.projetofinal.model.UF;

@Repository
public interface UFRepository extends JpaRepository<UF, Integer>{
    @Query("SELECT u FROM UF u WHERE u.id = ?1")
    UF findUFByIdUF(Integer id);
    
}
