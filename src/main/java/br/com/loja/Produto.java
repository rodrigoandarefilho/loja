package br.com.loja;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Produto {

        private BigDecimal id;
        private String nome;
        private BigDecimal precoUnitario;
        private String categoria;
        private String status;
        private String descricao;
        private LocalDate dataCadastro;
        private LocalDate dataAtualizacao;

    public Produto(ProdutoEntity produtoEntity) {
        this.nome = produtoEntity.getNome();
        this.precoUnitario = produtoEntity.getPrecoUnitario();
        this.categoria = produtoEntity.getCategoria();
        this.status = produtoEntity.getStatus().equalsIgnoreCase("A") ? String.valueOf(Status.Ativo) : String.valueOf(Status.Inativo);
        this.descricao = produtoEntity.getDescricao();
        this.dataCadastro = produtoEntity.getDataCadastro();
        this.dataAtualizacao = produtoEntity.getDataAtualizacao();
    }
}
