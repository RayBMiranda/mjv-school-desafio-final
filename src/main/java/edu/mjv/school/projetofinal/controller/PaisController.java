package edu.mjv.school.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mjv.school.projetofinal.model.Pais;
import edu.mjv.school.projetofinal.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    private PaisRepository repository;

    @PostMapping()
    public Pais gravar(@RequestBody Pais pais){
        return repository.save(pais);
    }

    @PutMapping()
    public Pais alterar(@RequestBody Pais pais){
         return repository.save(pais); 
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id); 
        repository.deleteById(id); 
    }

    @GetMapping("/filtro")
    public List<Pais> filtrar(@RequestParam("nm") String nome){
        System.out.println("Listando categoria pelo nome: " + nome);      
        return null;
    }

    @GetMapping()
    public List<Pais> listar(){
        System.out.println("Listando dados");
        return repository.findAll();
    }
}
