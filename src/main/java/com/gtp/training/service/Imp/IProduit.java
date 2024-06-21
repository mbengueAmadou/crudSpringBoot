package com.gtp.training.service.Imp;

import com.gtp.training.dto.ProduitDTO;
import com.gtp.training.entity.Categorie;
import com.gtp.training.entity.Produit;
import com.gtp.training.mapper.ProduitMapper;
import com.gtp.training.repository.ProduitRepository;
import com.gtp.training.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Génère le constructeur avec toutes les dépendances finales
public class IProduit implements ProduitService {
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;

    // Injection par constructeur
    /*
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.produitRepository = productRepository;
        this.produitMapper = productMapper;
    }
     */
    @Override
    public List<ProduitDTO> getAllProduits() {
        return produitRepository.findAll().stream()
                .map(produitMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProduitDTO getProduitById(Long id) {
        Produit product = produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return produitMapper.toDTO(product);
    }

    @Override
    public ProduitDTO createProduit(ProduitDTO productDTO) {
        Produit product = produitMapper.toEntity(productDTO);
        product = produitRepository.save(product);
        return produitMapper.toDTO(product);
    }

    @Override
    public ProduitDTO updateProduit(Long id, ProduitDTO produitDTO) {

            if (!produitRepository.existsById(id)) {
                throw new RuntimeException("Produit non trouvé");
            }

            // Convertir le DTO en entité
            Produit produit = produitMapper.toEntity(produitDTO);
            produit.setId(id);

            // Définir la catégorie du produit
            Categorie categorie = new Categorie();
            categorie.setId(produitDTO.getCategorieId());
            produit.setCategorie(categorie);

            // Sauvegarder le produit mis à jour
            produit = produitRepository.save(produit);

            // Convertir l'entité mise à jour en DTO
            return produitMapper.toDTO(produit);


    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
/*
    @Override
    public List<ProduitDTO> getProductByCategories(Long id) {
        return produitRepository.findProductByCategories(id);
    }

 */

    public List<ProduitDTO> getProductByCategories(Long categoryId) {
        List<Produit> produits = produitRepository.findProductByCategories(categoryId);
        return produitMapper.toDTOList(produits);
    }
}
