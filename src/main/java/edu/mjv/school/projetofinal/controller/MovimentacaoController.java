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

import edu.mjv.school.projetofinal.dto.MovimentacaoDTO;
import edu.mjv.school.projetofinal.model.Movimentacao;
import edu.mjv.school.projetofinal.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController{

    @Autowired
    private MovimentacaoService service;
    
    @PostMapping()
    public void gravar(@RequestBody MovimentacaoDTO movimentacaoDTO){
        service.salvar(movimentacaoDTO);
    }

    @PutMapping()
    public void alterar(@RequestBody MovimentacaoDTO movimentacaoDTO){
        service.salvar(movimentacaoDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        service.apagarPorId(id);
    }

    @GetMapping()
    public List<Movimentacao> listar(){
        return service.listarTodos();
    }
    
    @GetMapping(value = "/{id}")
    public Movimentacao buscarPorId(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }
    

    @GetMapping(value = "/data")
    public List<Movimentacao> buscarPorData(@RequestParam String criado_em){
        return service.buscarPorData(criado_em);
    }
}
