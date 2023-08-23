package br.com.loja;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, BigDecimal> {
}
