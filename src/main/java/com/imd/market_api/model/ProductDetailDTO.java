package com.imd.market_api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductDetailDTO(
        Integer id,
        String nome,
        String descricao,
        BigDecimal preco,
        LocalDateTime validade,
        Boolean ativo,
        Integer estoque,
        String fornecedor) {

    public ProductDetailDTO(Product product) {
        this(product.getId(), product.getNome(), product.getDescricao(), product.getPreco(), product.getValidade(),product.getAtivo(), product.getEstoque(), product.getFornecedor());
    }
}
