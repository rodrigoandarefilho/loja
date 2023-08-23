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
        var produto = new ProdutoEntity(produtoDTO);
        produtoRepository.save(produto);
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoModel(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarProdutoPorId(@PathVariable BigDecimal id) {
        var produto = produtoRepository.getReferenceById(id);
        return ResponseEntity.ok(new ProdutoModel(produto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> buscarTodosProdutos() {
        var listaDeProdutos = produtoRepository.findAll().stream().map(ProdutoModel::new).toList();
        return ResponseEntity.ok(listaDeProdutos);

    }
}
