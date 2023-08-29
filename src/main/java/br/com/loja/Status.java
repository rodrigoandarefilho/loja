package br.com.loja;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    ATIVO("A"),
    INATIVO("I");

    private String descricao;
}
