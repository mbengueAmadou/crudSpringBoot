package com.gtp.training.repository;

import com.gtp.training.dto.ProduitDTO;
import com.gtp.training.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query("select prod from Produit prod where prod.categorie.id =:id")
    List<Produit> findProductByCategories(@PathVariable("id") Long id);
}
