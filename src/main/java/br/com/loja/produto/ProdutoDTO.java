package br.com.loja.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoDTO(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotNull(message = "{preco_unitario.obrigatorio}")
        BigDecimal precoUnitario,
        @NotBlank(message = "{categoria.obrigatorio}")
        String categoria,
        String descricao) {
}
