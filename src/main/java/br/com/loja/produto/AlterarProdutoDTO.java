package br.com.loja.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AlterarProdutoDTO(
        @NotNull
        BigDecimal id,
        String nome,
        BigDecimal precoUnitario,
        String categoria,
        String descricao
) {
}
