package com.gtp.training.mapper;

import com.gtp.training.dto.CategorieDTO;
import com.gtp.training.entity.Categorie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategorieMapper {
    CategorieDTO toDTO(Categorie category);

    Categorie toEntity(CategorieDTO categoryDTO);
}
