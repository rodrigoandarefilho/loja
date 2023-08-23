package br.com.loja.produto;

import br.com.loja.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Produto")
@Table(name = "produtos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;
    private String nome;
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    private String categoria;
    private String status;
    private String descricao;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;
    @Column(name = "data_atualizacao")
    private LocalDate dataAtualizacao;

    public ProdutoEntity(ProdutoDTO produtoDTO) {
        this.nome = produtoDTO.nome();
        this.precoUnitario = produtoDTO.precoUnitario();
        this.categoria = produtoDTO.categoria();
        this.status = Status.Ativo.getDescricao();
        this.descricao = produtoDTO.descricao();
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }
}
