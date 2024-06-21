package com.gtp.training.mapper;

import com.gtp.training.dto.ProduitDTO;
import com.gtp.training.entity.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduitMapper {

    @Mapping(source = "categorie.id", target = "categorieId")
    ProduitDTO toDTO(Produit produit);

    @Mapping(source = "categorieId", target = "categorie.id")
    Produit toEntity(ProduitDTO productDTO);

    List<ProduitDTO> toDTOList(List<Produit> produits);

    //List<Produit> toEntityList(List<ProduitDTO> produitDTOs);
}
