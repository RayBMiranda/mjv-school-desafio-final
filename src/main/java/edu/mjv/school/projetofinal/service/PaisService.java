package edu.mjv.school.projetofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mjv.school.projetofinal.exceptionhandler.PaisNotFoundException;
import edu.mjv.school.projetofinal.model.Pais;
import edu.mjv.school.projetofinal.repository.PaisRepository;

@Service
public class PaisService {
    @Autowired
    PaisRepository repository;

    public void salvar(Pais pais){
        System.out.println("Alterando dados");
        System.out.println(pais); 
        repository.save(pais);
    }

    public void apagarPorId(Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id); 
        repository.deleteById(id); 
    }

    public List<Pais> listarTodos() {
        System.out.println("Listando dados");
        return repository.findAll();
    }

    public Pais exibirPorId(Integer idPais) {
        return repository.findById(idPais).orElseThrow(() -> new PaisNotFoundException());
    }


}
