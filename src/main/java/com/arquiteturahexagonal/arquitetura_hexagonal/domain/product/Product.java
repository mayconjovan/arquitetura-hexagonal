package com.arquiteturahexagonal.arquitetura_hexagonal.domain.product;

import java.util.UUID;

public class Product {

    private UUID id;
    private String description;
    private String title;
    private String imgUrl;

    public Product() {
    }

    public Product(String description, UUID id, String imgUrl, String title) {
        this.description = description;
        this.id = id;
        this.imgUrl = imgUrl;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}