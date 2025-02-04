package com.arquiteturahexagonal.arquitetura_hexagonal.domain.product;

import java.util.UUID;

public record ProductDTO(UUID id, String description, String title, String url) {

    public static ProductDTO fromEntityToDto(Product product) {
        return new ProductDTO(product.getId(),
                product.getDescription(),
                product.getTitle(),
                product.getImgUrl());
    }

}
