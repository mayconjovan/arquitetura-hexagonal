package com.arquiteturahexagonal.arquitetura_hexagonal.adapters.outbound.entities;

import com.arquiteturahexagonal.arquitetura_hexagonal.domain.product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Setter
@Getter
@Entity
@Builder
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class JpaProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String description;
    private String title;
    private String imgUrl;

    public JpaProductEntity(Product product) {
        this.id = product.getId();
        this.description = product.getDescription();
        this.imgUrl = product.getImgUrl();
        this.title = product.getTitle();
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }
}

