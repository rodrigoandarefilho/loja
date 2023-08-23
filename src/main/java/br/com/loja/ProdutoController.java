package br.com.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarProduto(@RequestBody ProdutoDTO produtoDTO, UriComponentsBuilder uriBuilder) {
        var produtoEntity = new ProdutoEntity(produtoDTO);
        produtoRepository.save(produtoEntity);
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produtoEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoModel(produtoEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarProdutoPorId(@PathVariable BigDecimal id) {
        var produtoEntity = produtoRepository.getReferenceById(id);
        return ResponseEntity.ok(new ProdutoModel(produtoEntity));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> buscarTodosProdutos() {
        var listaDeProdutos = produtoRepository.findAll().stream().map(ProdutoModel::new).toList();
        return ResponseEntity.ok(listaDeProdutos);

    }
}
