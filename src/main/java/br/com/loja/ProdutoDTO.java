package br.com.loja;

import java.math.BigDecimal;

public record ProdutoDTO(
        String nome,
        BigDecimal precoUnitario,
        String categoria,
        String descricao,
        String status) {
}
