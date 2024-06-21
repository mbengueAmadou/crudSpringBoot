package com.gtp.training.service;

import com.gtp.training.dto.ProduitDTO;

import java.util.List;

public interface ProduitService {
    List<ProduitDTO> getAllProduits();
    ProduitDTO getProduitById(Long id);
    ProduitDTO createProduit(ProduitDTO productDTO);
    ProduitDTO updateProduit(Long id, ProduitDTO productDTO);
    void deleteProduit(Long id);
    List<ProduitDTO> getProductByCategories(Long id);
}
