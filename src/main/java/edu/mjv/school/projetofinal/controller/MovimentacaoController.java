package edu.mjv.school.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.mjv.school.projetofinal.dto.MovimentacaoDTO;
import edu.mjv.school.projetofinal.model.Movimentacao;
import edu.mjv.school.projetofinal.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

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
}
