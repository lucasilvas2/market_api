package com.imd.market_api.model;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductCreateDTO(
        @NotNull
        String nome,
        @NotNull
        String descricao,
        @NotNull
        BigDecimal preco,
        @NotNull
        LocalDateTime validade,
        @NotNull
        Boolean ativo,
        @NotNull
        Integer estoque,
        @NotNull
        String fornecedor
) {
}
