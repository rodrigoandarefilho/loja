package br.com.loja;

import lombok.Getter;

@Getter
public enum Status {
    Ativo("A"),
    Inativo("I");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }
}
