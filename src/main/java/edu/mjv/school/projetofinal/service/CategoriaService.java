package edu.mjv.school.projetofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mjv.school.projetofinal.model.Categoria;
import edu.mjv.school.projetofinal.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository repository;

    public void salvar(Categoria categoria){
        System.out.println("Alterando dados");
        System.out.println(categoria); 
        repository.save(categoria);
    }

    public void apagarPorId(Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id); 
        repository.deleteById(id); 
    }

    public List<Categoria> listarTodos() {
        System.out.println("Listando dados");
        return repository.findAll();
    }


}
