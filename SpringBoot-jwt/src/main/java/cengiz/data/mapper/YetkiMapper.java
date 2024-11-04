package cengiz.data.mapper;

import cengiz.data.dto.YetkiDto;
import cengiz.data.entity.Yetki;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface YetkiMapper {


    YetkiDto toDto(Yetki yetki);

    Yetki toEntity(YetkiDto yetkiDto);
}
