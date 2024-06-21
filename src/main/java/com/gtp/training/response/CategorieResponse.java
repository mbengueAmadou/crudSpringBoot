package com.gtp.training.response;

import com.gtp.training.dto.CategorieDTO;

import java.util.List;

public class CategorieResponse {

    public static ResponseMessage getMessageSaveCategories(CategorieDTO categorieDTO) {

        if (categorieDTO == null)
            return new ResponseMessage("chao", "echéc", null);
        else
            return new ResponseMessage("ok", "categorie enregistre avec succè", categorieDTO);
    }

    public static ResponseMessage getMessageUpdateCategories(CategorieDTO categorie) {

        if (categorie == null)
            return new ResponseMessage("chao", "échèc !", null);
        else
            return new ResponseMessage("ok", "categorie mise a jour avec succès updated !", categorie);
    }

    public static ResponseMessage getMessageListCategories(List<CategorieDTO> categoriesList) {

        if (categoriesList.isEmpty())
            return new ResponseMessage("chao", "liste des categories est vide", null);
        else
            return new ResponseMessage("ok", "categories list", categoriesList);
    }
    public static ResponseMessage getMessageDeleteCategorieById() {
        return new ResponseMessage("ok", "categorie successfully deleted !", null);
    }

    public static ResponseMessage getMessageFindCategorieById(CategorieDTO categorieDTO) {

        if (categorieDTO == null)
            return new ResponseMessage("chao", "category not found", null);
        else
            return new ResponseMessage("ok", "category found", categorieDTO);
    }



}
