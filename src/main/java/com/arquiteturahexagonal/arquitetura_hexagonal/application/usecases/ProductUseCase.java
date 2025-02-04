package com.arquiteturahexagonal.arquitetura_hexagonal.application.usecases;

import com.arquiteturahexagonal.arquitetura_hexagonal.domain.product.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.UUID;

public interface ProductUseCase {

    Page<ProductDTO> findAllPaged(Pageable pageable);
    ProductDTO findById(UUID id);
    ProductDTO createProduct(ProductDTO dto);
    ProductDTO updateProduct(UUID id, ProductDTO dto);
    void deleteProduct(UUID id);

}
