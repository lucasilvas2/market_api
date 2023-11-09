package com.imd.market_api.model;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductUpdateDTO(
        @NotNull
        Integer id,
        String nome,
        String descricao,
        BigDecimal preco,
        LocalDateTime validade,
        Boolean ativo,
        Integer estoque,
        String fornecedor
) {
}
