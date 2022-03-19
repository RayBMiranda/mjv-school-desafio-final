package edu.mjv.school.projetofinal.controller;

import java.util.ArrayList;
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

import edu.mjv.school.projetofinal.dto.MovimentacaoDTO;
import edu.mjv.school.projetofinal.dto.MovimentacaoItemDTO;
import edu.mjv.school.projetofinal.model.Empresa;
import edu.mjv.school.projetofinal.model.Movimentacao;
import edu.mjv.school.projetofinal.model.MovimentacaoItem;
import edu.mjv.school.projetofinal.model.Produto;
import edu.mjv.school.projetofinal.repository.EmpresaRepository;
import edu.mjv.school.projetofinal.repository.MovimentacaoRepository;
import edu.mjv.school.projetofinal.repository.ProdutoRepository;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping()
    public Movimentacao gravar(@RequestBody MovimentacaoDTO movimentacaoDTO){
        Movimentacao movimentacao = _toConvertMovimentacaoEntity(movimentacaoDTO);
        return repository.save(movimentacao);
    }

    @PutMapping()
    public Movimentacao alterar(@RequestBody MovimentacaoDTO movimentacaoDTO){
        Movimentacao movimentacao = _toConvertMovimentacaoEntity(movimentacaoDTO);
        return repository.save(movimentacao);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id); 
        repository.deleteById(id); 
    }

    @GetMapping("/filtro")
    public List<Movimentacao> filtrar(@RequestParam("nm") String nome){
        System.out.println("Listando categoria pelo nome: " + nome);      
        return null;
    }

    @GetMapping()
    public List<Movimentacao> listar(){
        System.out.println("Listando dados");
        return repository.findAll();
    }

    public Movimentacao _toConvertMovimentacaoEntity(MovimentacaoDTO movimentacaoDTO){
        Movimentacao entity = new Movimentacao();
        entity.setId(movimentacaoDTO.getId());
        Optional<Empresa> empresa = empresaRepository.findById(movimentacaoDTO.getIdEmpresa());
        entity.setEmpresa(empresa.get());
        entity.setItens(new ArrayList<MovimentacaoItem>());
        entity.setTipoMovimentacao(movimentacaoDTO.getTipoMovimentacao());  
        for (MovimentacaoItemDTO movimentacaoItemDTO : movimentacaoDTO.getItens()) {
            MovimentacaoItem movimentacaoItem = new MovimentacaoItem();
            movimentacaoItem.setId(movimentacaoItemDTO.getId());
            movimentacaoItem.setPrecoCusto(movimentacaoItemDTO.getPrecoCusto());
            movimentacaoItem.setPrecoVenda(movimentacaoItemDTO.getPrecoVenda());
            Optional<Produto> produto = produtoRepository.findById(movimentacaoItemDTO.getIdProduto());
            Produto p = produto.get();
            p.setEmpresa(empresa.get());
            movimentacaoItem.setProduto(p);
            movimentacaoItem.setQuantidade(movimentacaoItemDTO.getQuantidade());
            entity.getItens().add(movimentacaoItem);
        }
    
        return entity ;
     }
}
