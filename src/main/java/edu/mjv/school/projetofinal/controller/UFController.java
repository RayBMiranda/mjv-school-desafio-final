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

import edu.mjv.school.projetofinal.dto.UFDTO;
import edu.mjv.school.projetofinal.model.UF;
import edu.mjv.school.projetofinal.service.UFService;

@RestController
@RequestMapping("/ufs")
public class UFController {
    @Autowired
    private UFService service;

    @PostMapping()
    public void gravar(@RequestBody UFDTO ufDTO){
        service.salvar(ufDTO);
    }

    @PutMapping()
    public void alterar(@RequestBody UFDTO ufDTO){
        service.salvar(ufDTO); 
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        service.apagarPorId(id); 
    }

    @GetMapping()
    public List<UF> listar(){
        return service.listarTodos();
    }
}
