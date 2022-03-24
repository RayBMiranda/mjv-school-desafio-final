package edu.mjv.school.projetofinal.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mjv.school.projetofinal.dto.MovimentacaoDTO;
import edu.mjv.school.projetofinal.dto.MovimentacaoItemDTO;
import edu.mjv.school.projetofinal.exceptionhandler.movimentacaoControllerAdvice.MovimentacaoBadRequestException;
import edu.mjv.school.projetofinal.exceptionhandler.movimentacaoControllerAdvice.MovimentacaoInternalServerErrorException;
import edu.mjv.school.projetofinal.exceptionhandler.movimentacaoControllerAdvice.MovimentacaoNotFoundException;
import edu.mjv.school.projetofinal.model.Movimentacao;
import edu.mjv.school.projetofinal.model.MovimentacaoItem;
import edu.mjv.school.projetofinal.model.Produto;
import edu.mjv.school.projetofinal.repository.EmpresaRepository;
import edu.mjv.school.projetofinal.repository.MovimentacaoRepository;
import edu.mjv.school.projetofinal.repository.ProdutoRepository;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void salvar(MovimentacaoDTO movimentacaoDTO){
        Movimentacao movimentacao = _toConvertMovimentacaoEntity(movimentacaoDTO);
        repository.save(movimentacao);
    }

    public void apagarPorId(Integer id){
        System.out.println("Apagando dados");
        System.out.println("Id:" + id); 
        repository.deleteById(id); 
    }
    
    public Movimentacao buscarPorId(Integer id){
        Optional<Movimentacao> movimentacao = repository.findMovimentacaoById(id);
        return movimentacao.orElseThrow(() -> new MovimentacaoNotFoundException());
    }
    
    public List<Movimentacao> buscarPorData(String data){
    	if(data.length() > 10) throw new MovimentacaoInternalServerErrorException();
    	
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate ld = LocalDate.parse(data, DATEFORMATTER);
        LocalDateTime dt = LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());
        Optional<List<Movimentacao>> movimentacao = repository.findAllWithCreationDate(dt);
        
        if(!movimentacao.get().isEmpty()) return movimentacao.get();
        else throw new MovimentacaoNotFoundException();
    }
    
    public Movimentacao buscarPorIdEmpresa(Integer id){
    	if(!(id instanceof Integer)) throw new MovimentacaoBadRequestException();
    	
        Optional<Movimentacao> movimentacao = repository.findMovimentacaoById(id);
        return movimentacao.orElseThrow(() -> new MovimentacaoNotFoundException());
    }

    public Movimentacao _toConvertMovimentacaoEntity(MovimentacaoDTO movimentacaoDTO){
        Movimentacao entity = new Movimentacao();
        entity = new ModelMapper().map(movimentacaoDTO, Movimentacao.class);
        entity.setEmpresa(empresaRepository.findById(movimentacaoDTO.getIdEmpresa()).orElse(null));
        entity.setItens(new ArrayList<MovimentacaoItem>());
        for (MovimentacaoItemDTO movimentacaoItemDTO : movimentacaoDTO.getItens()) {
            MovimentacaoItem movimentacaoItem = new MovimentacaoItem();
            movimentacaoItem = new ModelMapper().map(movimentacaoItemDTO, MovimentacaoItem.class);
            Produto p = produtoRepository.findById(movimentacaoItemDTO.getIdProduto()).orElse(null);
            if(p != null)
                p.setEmpresa(entity.getEmpresa());
            movimentacaoItem.setProduto(p);
            entity.addItem(movimentacaoItem);
        }
    
        return entity ;
     }
}
