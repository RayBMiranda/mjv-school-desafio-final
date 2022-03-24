package edu.mjv.school.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mjv.school.projetofinal.dto.ProdutoDTO;
import edu.mjv.school.projetofinal.model.Produto;
import edu.mjv.school.projetofinal.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService service;
    
    @PostMapping()
    public void gravar(@RequestBody ProdutoDTO produtoDTO){
        service.salvar(produtoDTO);
    }

    @PutMapping()
    public void alterar(@RequestBody ProdutoDTO produtoDTO){
        service.salvar(produtoDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        service.apagar(id);
    }

    @GetMapping(value = "/id-empresa/{id}")
    public Produto buscarPorIdEmpresa(@PathVariable("id") Integer id){
        return service.buscarPorIdEmpresa(id);
    }
}
