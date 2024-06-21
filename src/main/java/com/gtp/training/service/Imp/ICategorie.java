package com.gtp.training.service.Imp;

import com.gtp.training.dto.CategorieDTO;
import com.gtp.training.entity.Categorie;
import com.gtp.training.entity.Produit;
import com.gtp.training.mapper.CategorieMapper;
import com.gtp.training.repository.CategorieRepository;
import com.gtp.training.service.CategorieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ICategorie implements CategorieService {

    private final CategorieRepository categorieRepository;
    private final CategorieMapper categorieMapper;

    // Injection par constructeur
    public ICategorie(CategorieRepository categorieRepository, CategorieMapper categorieMapper) {
        this.categorieRepository = categorieRepository;
        this.categorieMapper = categorieMapper;
    }

    @Override
    public List<CategorieDTO> getAllCategorys() {
        return categorieRepository.findAll().stream()
                .map(categorieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategorieDTO getCategoryById(Long id) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return categorieMapper.toDTO(categorie);
    }

    @Override
    public CategorieDTO createCategory(CategorieDTO categoryDTO) {
        Categorie category = categorieMapper.toEntity(categoryDTO);
        category = categorieRepository.save(category);
        return categorieMapper.toDTO(category);
    }

    @Override
    public CategorieDTO updateCategory(Long id, CategorieDTO categorieDTO) {
        if (!categorieRepository.existsById(id)) {
            throw new RuntimeException("Categorie non trouvée");
        }

        // Convertir le DTO en entité
        Categorie categorie = categorieMapper.toEntity(categorieDTO);
        categorie.setId(id);

        // Sauvegarder la catégorie mise à jour
        categorie = categorieRepository.save(categorie);

        // Convertir l'entité mise à jour en DTO
        return categorieMapper.toDTO(categorie);
    }

    @Override
    public void deleteCategory(Long id) {
        categorieRepository.deleteById(id);
    }
}
