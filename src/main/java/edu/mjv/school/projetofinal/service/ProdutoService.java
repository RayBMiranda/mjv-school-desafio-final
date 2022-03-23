package edu.mjv.school.projetofinal.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mjv.school.projetofinal.dto.ProdutoDTO;
import edu.mjv.school.projetofinal.model.Produto;
import edu.mjv.school.projetofinal.repository.CategoriaRepository;
import edu.mjv.school.projetofinal.repository.EmpresaRepository;
import edu.mjv.school.projetofinal.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired 
    private CategoriaRepository categoriaRepository;

    public void salvar(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto = _toConvertProdutoEntity(produtoDTO);
        repository.save(produto);
    }

    public void apagar(Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id); 
        repository.deleteById(id); 
    }

    public List<Produto> listarTodos() {
        System.out.println("Listando dados");
        return repository.findAll();
    }

    public Produto _toConvertProdutoEntity(ProdutoDTO produtoDTO){
        Produto entity = new Produto();
        entity = new ModelMapper().map(produtoDTO, Produto.class);   
        entity.setCategoria(categoriaRepository.findById(produtoDTO.getIdCategoria()).orElse(null));
        entity.setEmpresa(empresaRepository.findById(produtoDTO.getIdEmpresa()).orElse(null));
        return entity ;
    }

}
