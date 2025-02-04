package com.arquiteturahexagonal.arquitetura_hexagonal.application.services;

import com.arquiteturahexagonal.arquitetura_hexagonal.adapters.outbound.factory.ProductFactory;
import com.arquiteturahexagonal.arquitetura_hexagonal.application.usecases.ProductUseCase;
import com.arquiteturahexagonal.arquitetura_hexagonal.domain.product.Product;
import com.arquiteturahexagonal.arquitetura_hexagonal.domain.product.ProductDTO;
import com.arquiteturahexagonal.arquitetura_hexagonal.domain.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductUseCase {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(Pageable pageable) {
        Page<Product> list = repository.findAllPaged(pageable);
        return list.map(ProductDTO::fromEntityToDto);
    }


    @Transactional(readOnly = true)
    public ProductDTO findById(UUID id) {
        Product obj = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductDTO.fromEntityToDto(obj);
    }

    @Transactional
    public ProductDTO createProduct(ProductDTO dto) {
        var entity = repository.save(ProductFactory.fromDtoToDomain(dto));
        return ProductDTO.fromEntityToDto(entity);
    }

    @Transactional
    public ProductDTO updateProduct(UUID id, ProductDTO dto) {
        try {
            Product entity = repository.getReferenceById(id);
            //Set attributes that you need
            entity = repository.save(entity);
            return ProductDTO.fromEntityToDto(entity);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("Id not found " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteProduct(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Falha de integridade referencial");
        }
    }

}