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

import edu.mjv.school.projetofinal.dto.ProdutoDTO;
import edu.mjv.school.projetofinal.model.Categoria;
import edu.mjv.school.projetofinal.model.Empresa;
import edu.mjv.school.projetofinal.model.Produto;
import edu.mjv.school.projetofinal.repository.CategoriaRepository;
import edu.mjv.school.projetofinal.repository.EmpresaRepository;
import edu.mjv.school.projetofinal.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired 
    private CategoriaRepository categoriaRepository;

    @PostMapping()
    public Produto gravar(@RequestBody ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto = _toConvertProdutoEntity(produtoDTO);
        return repository.save(produto);
    }

    @PutMapping()
    public Produto alterar(@RequestBody ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto = _toConvertProdutoEntity(produtoDTO);
        return repository.save(produto); 
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id); 
        repository.deleteById(id); 
    }

    @GetMapping("/filtro")
    public List<Produto> filtrar(@RequestParam("nm") String nome){
        System.out.println("Listando categoria pelo nome: " + nome);      
        return null;
    }

    @GetMapping()
    public List<Produto> listar(){
        System.out.println("Listando dados");
        return repository.findAll();
    }

    public Produto _toConvertProdutoEntity(ProdutoDTO produtoDTO){
        Produto entity = new Produto();
        entity.setId(produtoDTO.getId());
        entity.setCodigoInterno(produtoDTO.getCodigoInterno());
        entity.setEan(produtoDTO.getEan());
        entity.setDescricao(produtoDTO.getDescricao());
        Categoria categoria = new Categoria();
        Optional<Categoria> categorialOptional = categoriaRepository.findById(produtoDTO.getIdCategoria());
        categoria = categorialOptional.get();
        entity.setCategoria(categoria);
        Empresa empresa = new Empresa();
        empresa = empresaRepository.findById(produtoDTO.getIdEmpresa()).get();
        entity.setEmpresa(empresa);
        entity.setEstoque(produtoDTO.getEstoque());
        entity.setPrecoCusto(produtoDTO.getPrecoCusto());
        entity.setPrecoVenda(produtoDTO.getPrecoVenda());
        entity.setTipoUnidade(produtoDTO.getTipoUnidade());
        return entity ;
    }
}
