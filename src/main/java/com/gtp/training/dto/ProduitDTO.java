package com.gtp.training.dto;

import lombok.Data;

@Data
public class ProduitDTO {

    private Long id;
    private String name;
    private String description;
    private Long categorieId;
}
