package br.com.loja.produto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class ProdutoModel {
        private BigDecimal id;
        private String nome;
        private BigDecimal precoUnitario;
        private String categoria;
        private String status;
        private String descricao;
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataCadastro;
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataAtualizacao;

    public ProdutoModel(ProdutoEntity produtoEntity) {
        this.id = produtoEntity.getId();
        this.nome = produtoEntity.getNome();
        this.precoUnitario = produtoEntity.getPrecoUnitario();
        this.categoria = produtoEntity.getCategoria();
        this.status = produtoEntity.getStatus();
        this.descricao = produtoEntity.getDescricao();
        this.dataCadastro = produtoEntity.getDataCadastro();
        this.dataAtualizacao = produtoEntity.getDataAtualizacao();
    }
}
