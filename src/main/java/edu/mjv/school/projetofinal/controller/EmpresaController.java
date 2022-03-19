package edu.mjv.school.projetofinal.controller;

import java.util.List;
import java.util.Optional;

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

import edu.mjv.school.projetofinal.dto.EmpresaDTO;
import edu.mjv.school.projetofinal.model.Empresa;
import edu.mjv.school.projetofinal.model.Endereco;
import edu.mjv.school.projetofinal.model.UF;
import edu.mjv.school.projetofinal.repository.EmpresaRepository;
import edu.mjv.school.projetofinal.repository.UFRepository;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private UFRepository ufRepository;

    @PostMapping()
    public Empresa gravar(@RequestBody EmpresaDTO empresaDTO){
        return repository.save(_toConvertEmpresaEntity(empresaDTO));
    }

    @PutMapping()
    public Empresa alterar(@RequestBody EmpresaDTO empresaDTO){
         return repository.save(_toConvertEmpresaEntity(empresaDTO)); 
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id); 
        repository.deleteById(id); 
    }

    @GetMapping("/filtro")
    public List<Empresa> filtrar(@RequestParam("nm") String nome){
        System.out.println("Listando categoria pelo nome: " + nome);      
        return null;
    }

    @GetMapping()
    public List<Empresa> listar(){
        System.out.println("Listando dados");
        return repository.findAll();
    }

    public Empresa _toConvertEmpresaEntity(EmpresaDTO empresaDTO){
        Empresa entity = new Empresa();
        entity.setId(empresaDTO.getId());
        entity.setCnpj(empresaDTO.getCnpj());
        entity.setEmails(empresaDTO.getEmails());
        entity.setNomeFantasia(empresaDTO.getNomeFantasia());
        entity.setRazaoSocial(empresaDTO.getRazaoSocial());
        Endereco endereco = new Endereco();
        endereco.setId(empresaDTO.getEndereco().getId());
        endereco.setLogradouro(empresaDTO.getEndereco().getLogradouro());
        endereco.setBairro(empresaDTO.getEndereco().getBairro());
        endereco.setCidade(empresaDTO.getEndereco().getCidade());
        endereco.setNumero(empresaDTO.getEndereco().getNumero());
        Optional<UF> uf = ufRepository.findById(empresaDTO.getEndereco().getIdUf());
        endereco.setUf(uf.get());
        endereco.setCep(empresaDTO.getEndereco().getCep());
        entity.setEndereco(endereco);
        entity.setTelefones(empresaDTO.getTelefones());
        return entity ;
     }
}
