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
import org.springframework.web.bind.annotation.RestController;

import edu.mjv.school.projetofinal.model.Pais;
import edu.mjv.school.projetofinal.service.PaisService;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    private PaisService service;

    @PostMapping()
    public void gravar(@RequestBody Pais pais){
        service.salvar(pais);
    }

    @PutMapping()
    public void alterar(@RequestBody Pais pais){
        service.salvar(pais); 
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        service.apagarPorId(id); 
    }

    @GetMapping()
    public List<Pais> listar(){
        return service.listarTodos();
    }
}
