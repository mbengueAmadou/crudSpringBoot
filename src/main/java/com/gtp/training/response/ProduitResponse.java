package com.gtp.training.response;

import com.gtp.training.entity.Produit;

import java.util.List;

public class ProduitResponse {


    public static ResponseMessage getMessageSaveProduct(Produit produit) {

        if (produit == null)
            return new ResponseMessage("chao", "échoué ", null);
        else
            return new ResponseMessage("ok", "produit enregistré avec succès", produit);
    }

    public static ResponseMessage getMessageUpdateProduct(Produit produit) {

        if (produit == null)
            return new ResponseMessage("chao", "Le produit n'a pas été mis à jour !", null);
        else
            return new ResponseMessage("ok", "produit modifier avec succès !", produit);
    }

    public static ResponseMessage getMessageListProducts(List<Produit> produits) {

        if (produits.isEmpty())
            return new ResponseMessage("chao", "list product is empty", null);
        else
            return new ResponseMessage("ok", "products list", produits);
    }

    public static ResponseMessage getMessageFindProductById(Produit produit) {

        if (produit == null)
            return new ResponseMessage("chao", "produit non trouvé", null);
        else
            return new ResponseMessage("ok", "produit", produit);
    }

    public static ResponseMessage getMessageDeleteProductById() {
        return new ResponseMessage("ok", "produit supprimer avec succès !", null);
    }

}
