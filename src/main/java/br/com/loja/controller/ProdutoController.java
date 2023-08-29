package br.com.loja.controller;

import br.com.loja.Status;
import br.com.loja.produto.AlterarProdutoDTO;
import br.com.loja.produto.CadastrarProdutoDTO;
import br.com.loja.produto.ProdutoEntity;
import br.com.loja.produto.ProdutoModel;
import br.com.loja.repository.ProdutoRepository;
import jakarta.validation.Valid;
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
    public ResponseEntity cadastrarProduto(@RequestBody @Valid CadastrarProdutoDTO cadastrarProdutoDTO, UriComponentsBuilder uriBuilder) {
        var produtoEntity = new ProdutoEntity(cadastrarProdutoDTO);
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

    @PutMapping
    @Transactional
    public ResponseEntity alterarProduto(@RequestBody @Valid AlterarProdutoDTO alterarProdutoDTO) {
        var produtoEntity = produtoRepository.getReferenceById(alterarProdutoDTO.id());
        produtoEntity.alterar(alterarProdutoDTO);
        return ResponseEntity.ok(new ProdutoModel(produtoEntity));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarProduto(@PathVariable BigDecimal id) {
        var produtoEntity = produtoRepository.getReferenceById(id);
        produtoEntity.deletar();
        return ResponseEntity.ok(new ProdutoModel(produtoEntity));
    }
}
