package edu.mjv.school.projetofinal.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mjv.school.projetofinal.dto.UFDTO;
import edu.mjv.school.projetofinal.model.UF;
import edu.mjv.school.projetofinal.repository.UFRepository;

@Service
public class UFService {
    @Autowired
    private UFRepository repository;

    @Autowired
    private PaisService paisService;

    public void salvar(UFDTO ufDTO){
        repository.save(_toConvertUFEntity(ufDTO));
    }

    public void apagarPorId(Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id); 
        repository.deleteById(id); 
    }

    public List<UF> listarTodos() {
        System.out.println("Listando dados");
        return repository.findAll();
    }
    
    public UF _toConvertUFEntity(UFDTO ufDTO){
        UF entity = new UF();
        entity = new ModelMapper().map(ufDTO, UF.class);   
        entity.setPais(paisService.exibirPorId(ufDTO.getIdPais()));
        return entity ;
    }
}
