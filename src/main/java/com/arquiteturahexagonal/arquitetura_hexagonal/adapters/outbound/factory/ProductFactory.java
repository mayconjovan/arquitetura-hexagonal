package com.arquiteturahexagonal.arquitetura_hexagonal.adapters.outbound.factory;

import com.arquiteturahexagonal.arquitetura_hexagonal.adapters.outbound.entities.JpaProductEntity;
import com.arquiteturahexagonal.arquitetura_hexagonal.domain.product.Product;

public class ProductFactory {

    public static Product fromJpaToDomain(JpaProductEntity jpaEntity) {
        Product product = new Product();
        product.setId(jpaEntity.getId());
        product.setDescription(jpaEntity.getDescription());
        product.setTitle(jpaEntity.getTitle());
        product.setImgUrl(jpaEntity.getImgUrl());
        return product;
    }

}
