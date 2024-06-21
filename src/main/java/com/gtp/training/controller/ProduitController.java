package com.gtp.training.controller;

import com.gtp.training.dto.ProduitDTO;
import com.gtp.training.service.CategorieService;
import com.gtp.training.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    private  final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public List<ProduitDTO> getAllProducts() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public ProduitDTO getProductById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    @PostMapping
    public ProduitDTO createProduct(@RequestBody ProduitDTO productDTO) {
        return produitService.createProduit(productDTO);
    }

    @PutMapping("/{id}")
    public ProduitDTO updateProduct(@PathVariable Long id, @RequestBody ProduitDTO productDTO) {
        return produitService.updateProduit(id, productDTO);
    }



}
