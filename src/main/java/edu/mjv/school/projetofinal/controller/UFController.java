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

import edu.mjv.school.projetofinal.model.UF;
import edu.mjv.school.projetofinal.repository.UFRepository;

@RestController
@RequestMapping("/ufs")
public class UFController {
    @Autowired
    private UFRepository repository;

    @PostMapping()
    public UF gravar(@RequestBody UF uf){
        return repository.save(uf);
    }

    @PutMapping()
    public UF alterar(@RequestBody UF uf){
         return repository.save(uf); 
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id); 
        repository.deleteById(id); 
    }

    @GetMapping("/filtro")
    public List<UF> filtrar(@RequestParam("nm") String nome){
        System.out.println("Listando categoria pelo nome: " + nome);      
        return null;
    }

    @GetMapping(value = "/{id}")
    public UF exibir(@PathVariable("id") Integer id){
        System.out.println("Listando dados");
        return repository.findUFByIdUF(id);
    }

    @GetMapping()
    public List<UF> listar(){
        System.out.println("Listando dados");
        return repository.findAll();
    }
}
