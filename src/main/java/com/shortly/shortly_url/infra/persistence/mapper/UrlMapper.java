package com.shortly.shortly_url.infra.persistence.mapper;

import com.shortly.shortly_url.domain.model.Url;
import com.shortly.shortly_url.infra.persistence.entity.UrlEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UrlMapper {
    UrlEntity toEntity(Url url);
    Url toModel(UrlEntity entity);
}
