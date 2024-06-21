package com.gtp.training.controller;

import com.gtp.training.dto.CategorieDTO;
import com.gtp.training.dto.ProduitDTO;
import com.gtp.training.entity.Produit;
import com.gtp.training.response.CategorieResponse;
import com.gtp.training.response.ResponseMessage;
import com.gtp.training.service.CategorieService;
import com.gtp.training.service.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    private  final CategorieService categorieService;
    private final ProduitService produitService;

    public CategorieController(CategorieService categorieService, ProduitService produitService) {
        this.categorieService = categorieService;
        this.produitService = produitService;
    }
    /*
    @GetMapping
    public List<CategorieDTO> getAllCategories() {
        return categorieService.getAllCategorys();
    }



    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<>(CategorieResponse.getMessageListCategories(categorieService.getAllCategorys()), HttpStatus.OK);
    }

     */

    @GetMapping
    public ResponseEntity<ResponseMessage> getAllCategories() {
        List<CategorieDTO> categories = categorieService.getAllCategorys();
        ResponseMessage response = CategorieResponse.getMessageListCategories(categories);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseMessage> getCategorieById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(CategorieResponse.getMessageFindCategorieById(categorieService.getCategoryById(id)), HttpStatus.OK);
    }

    
/*
    @PostMapping("/add")
    public CategorieDTO createCategorie(@RequestBody CategorieDTO categorieDTO) {
        return categorieService.createCategory(categorieDTO);
    }

 */

    @PostMapping()
    public ResponseEntity<ResponseMessage> createCategories(@RequestBody CategorieDTO categorieDTO) {
        return new ResponseEntity<>(CategorieResponse.getMessageSaveCategories(categorieService.createCategory(categorieDTO)), HttpStatus.OK);
    }

/*
    @PutMapping("/{id}")
    public CategorieDTO updateProduct(@PathVariable Long id, @RequestBody CategorieDTO categorieDTO) {
        return categorieService.updateCategory(id, categorieDTO);
    }

 */
@PutMapping(value = "/{id}")
public ResponseEntity<ResponseMessage> updateCategories(@PathVariable(value = "id") Long id, @RequestBody CategorieDTO categorieDTO) {
    return new ResponseEntity<>(CategorieResponse.getMessageUpdateCategories(categorieService.updateCategory(id, categorieDTO)), HttpStatus.OK);
}


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseMessage> deleteCategories(@PathVariable(value = "id") Long id) {

        List<ProduitDTO> productListDTO = produitService.getProductByCategories(id);

        if (!productListDTO.isEmpty())
            return new ResponseEntity<>(new ResponseMessage("chao", "impossible to delete because the categories is linked to product. Please delete the product first or change its categories.", productListDTO), HttpStatus.OK);

        categorieService.deleteCategory(id);
        return new ResponseEntity<>(CategorieResponse.getMessageDeleteCategorieById(), HttpStatus.OK);

    }

}
