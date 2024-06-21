package com.gtp.training.service;

import com.gtp.training.dto.CategorieDTO;

import java.util.List;

public interface CategorieService {
    List<CategorieDTO> getAllCategorys();
    CategorieDTO getCategoryById(Long id);
    CategorieDTO createCategory(CategorieDTO categoryDTO);
    CategorieDTO updateCategory(Long id, CategorieDTO categoryDTO);
    void deleteCategory(Long id);
}
