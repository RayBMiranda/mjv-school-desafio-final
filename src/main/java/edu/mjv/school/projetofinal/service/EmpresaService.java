package edu.mjv.school.projetofinal.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mjv.school.projetofinal.dto.EmpresaDTO;
import edu.mjv.school.projetofinal.model.Empresa;
import edu.mjv.school.projetofinal.model.Endereco;
import edu.mjv.school.projetofinal.repository.EmpresaRepository;
import edu.mjv.school.projetofinal.repository.UFRepository;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private UFRepository ufRepository;

    public void salvar(EmpresaDTO empresaDTO){
        repository.save(_toConvertEmpresaEntity(empresaDTO));
    }

    public void apagarPorId(Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id); 
        repository.deleteById(id); 
    }

    public List<Empresa> listarTodos(){
        System.out.println("Listando dados");
        return repository.findAll();
    }

    public Empresa _toConvertEmpresaEntity(EmpresaDTO empresaDTO){
        Empresa entity = new Empresa();
        entity = new ModelMapper().map(empresaDTO, Empresa.class);
        Endereco endereco = new Endereco();
        endereco.setId(empresaDTO.getEndereco().getId());
        endereco.setLogradouro(empresaDTO.getEndereco().getLogradouro());
        endereco.setBairro(empresaDTO.getEndereco().getBairro());
        endereco.setCidade(empresaDTO.getEndereco().getCidade());
        endereco.setNumero(empresaDTO.getEndereco().getNumero());
        endereco.setUf(ufRepository.findById(empresaDTO.getEndereco().getIdUf()).orElse(null));
        endereco.setCep(empresaDTO.getEndereco().getCep());
        entity.setEndereco(endereco);
        return entity ;
     }
}
