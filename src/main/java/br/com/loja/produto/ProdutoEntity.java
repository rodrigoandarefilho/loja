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

    public ProdutoEntity(CadastrarProdutoDTO cadastrarProdutoDTO) {
        this.nome = cadastrarProdutoDTO.nome();
        this.precoUnitario = cadastrarProdutoDTO.precoUnitario();
        this.categoria = cadastrarProdutoDTO.categoria();
        this.status = Status.ATIVO.getDescricao();
        this.descricao = cadastrarProdutoDTO.descricao();
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }

    public void alterar(AlterarProdutoDTO alterarProdutoDTO) {
        if (alterarProdutoDTO.nome() != null) {
            this.nome = alterarProdutoDTO.nome();
        }
        if (alterarProdutoDTO.precoUnitario() != null) {
            this.precoUnitario = alterarProdutoDTO.precoUnitario();
        }
        if (alterarProdutoDTO.categoria() != null) {
            this.categoria = alterarProdutoDTO.categoria();
        }
        if (alterarProdutoDTO.descricao() != null) {
            this.descricao = alterarProdutoDTO.descricao();
        }
    }

    public void deletar() {
        this.status = Status.INATIVO.getDescricao();
    }
}
