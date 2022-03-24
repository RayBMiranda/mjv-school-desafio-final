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

import edu.mjv.school.projetofinal.dto.CategoriaDTO;
import edu.mjv.school.projetofinal.model.Categoria;
import edu.mjv.school.projetofinal.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @PostMapping()
    public void gravar(@RequestBody CategoriaDTO categoriaDTO){
        service.salvar(categoriaDTO);
    }

    @PutMapping()
    public void alterar(@RequestBody CategoriaDTO categoriaDTO){
        service.salvar(categoriaDTO); 
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        service.apagarPorId(id);
    }

    @GetMapping(value = "/{id}")
    public Categoria buscarPorId(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }
    
    @GetMapping(value = "/id-empresa/{id}")
    public List<Categoria> buscarPorIdEmpresa(@PathVariable("id") Integer id){
   		return service.buscarPorIdEmpresa(id);    	
    }
}
