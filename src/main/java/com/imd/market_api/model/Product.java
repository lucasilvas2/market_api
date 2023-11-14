package com.imd.market_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private LocalDateTime validade;
    private Boolean ativo;
    private Integer estoque;
    private String fornecedor;

    public Product(ProductCreateDTO productCreateDTO) {
        this.nome = productCreateDTO.nome();
        this.descricao = productCreateDTO.descricao();
        this.preco = productCreateDTO.preco();
        this.validade = productCreateDTO.validade();
        this.ativo = true;
        this.estoque = productCreateDTO.estoque();
        this.fornecedor = productCreateDTO.fornecedor();
    }

    public void update(ProductUpdateDTO productUpdateDTO) {
        if(productUpdateDTO.nome() != null){
            this.setNome(productUpdateDTO.nome());
        }
        if(productUpdateDTO.descricao() != null){
            this.setDescricao(productUpdateDTO.descricao());
        }
        if(productUpdateDTO.preco() != null){
            this.setPreco(productUpdateDTO.preco());
        }
        if(productUpdateDTO.validade() != null){
            this.setValidade(productUpdateDTO.validade());
        }
        if(productUpdateDTO.ativo() != null){
            this.setAtivo(productUpdateDTO.ativo());
        }
        if(productUpdateDTO.ativo() != null){
            this.setAtivo(productUpdateDTO.ativo());
        }
        if(productUpdateDTO.estoque() != null){
            this.setEstoque(productUpdateDTO.estoque());
        }
        if(productUpdateDTO.fornecedor() != null){
            this.setFornecedor(productUpdateDTO.fornecedor());
        }
    }
}
