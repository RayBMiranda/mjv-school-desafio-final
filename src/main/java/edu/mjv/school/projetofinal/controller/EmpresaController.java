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

import edu.mjv.school.projetofinal.dto.EmpresaDTO;
import edu.mjv.school.projetofinal.model.Empresa;
import edu.mjv.school.projetofinal.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired 
    private EmpresaService service;

    @PostMapping()
    public void gravar(@RequestBody EmpresaDTO empresaDTO){
        service.salvar(empresaDTO);
    }

    @PutMapping()
    public void alterar(@RequestBody EmpresaDTO empresaDTO){
        service.salvar(empresaDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        service.apagarPorId(id);
    }

    @GetMapping()
    public List<Empresa> listar(){
        return service.listarTodos();
    }

}
