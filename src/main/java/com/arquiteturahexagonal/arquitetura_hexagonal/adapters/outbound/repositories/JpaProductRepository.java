package com.arquiteturahexagonal.arquitetura_hexagonal.adapters.outbound.repositories;

import com.arquiteturahexagonal.arquitetura_hexagonal.adapters.outbound.entities.JpaProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface JpaProductRepository extends JpaRepository<JpaProductEntity, UUID> {

}