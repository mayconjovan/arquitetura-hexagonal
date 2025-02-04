package com.arquiteturahexagonal.arquitetura_hexagonal.domain.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    Product save(Product p);
    Page<Product> findAllPaged(Pageable pageable);
    Optional<Product> findById(UUID id);
    void deleteById(UUID id);
    boolean existsById(UUID id);
    Product getReferenceById(UUID id);

}
