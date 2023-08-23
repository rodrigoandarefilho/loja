package br.com.loja.repository;

import br.com.loja.produto.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, BigDecimal> {
}
