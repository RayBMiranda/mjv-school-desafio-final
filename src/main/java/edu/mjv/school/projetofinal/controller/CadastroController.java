package edu.mjv.school.projetofinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mjv.school.projetofinal.model.Cadastro;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @PostMapping()
    public void gravar(@RequestBody Cadastro cadastro){
        System.out.println("Gravando dados");
        System.out.println(cadastro);  
    }

    @PutMapping()
    public void alterar(@RequestBody Cadastro cadastro){
        System.out.println("Alterando dados");
        System.out.println(cadastro);  
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id);  
    }

    @GetMapping("/filtro")
    public List<Cadastro> filtrar(@RequestParam("nm") String nome){
        System.out.println("Listando cadastros pelo nome: " + nome);      
        return null;
    }

    @GetMapping()
    public List<Cadastro> listar(){
        System.out.println("Listando dados");
        return null;
    }
}
