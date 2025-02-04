package com.arquiteturahexagonal.arquitetura_hexagonal.adapters.outbound.repositories;

import com.arquiteturahexagonal.arquitetura_hexagonal.adapters.outbound.entities.JpaProductEntity;
import com.arquiteturahexagonal.arquitetura_hexagonal.adapters.outbound.factory.ProductFactory;
import com.arquiteturahexagonal.arquitetura_hexagonal.domain.product.Product;
import com.arquiteturahexagonal.arquitetura_hexagonal.domain.product.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository productRepository;

    public ProductRepositoryImpl(JpaProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        JpaProductEntity productEntity = new JpaProductEntity(product);
        return ProductFactory.fromJpaToDomain(this.productRepository.save(productEntity));
    }


    @Override
    public Page<Product> findAllPaged(Pageable pageable) {
        var x = productRepository.findAll(pageable);
        return this.productRepository.findAll(pageable)
                .map(ProductFactory::fromJpaToDomain);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        Optional<JpaProductEntity> productEntity = this.productRepository.findById(id);
        return productEntity.map(ProductFactory::fromJpaToDomain);

    }

    @Override
    public void deleteById(UUID id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return false;
    }

    @Override
    public Product getReferenceById(UUID id) {
        return null;
    }
}
