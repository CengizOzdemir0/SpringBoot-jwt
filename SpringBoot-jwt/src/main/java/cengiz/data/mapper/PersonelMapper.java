package cengiz.data.mapper;

import org.mapstruct.Mapper;

import cengiz.data.dto.PersonelDto;
import cengiz.data.entity.Personel;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Mapper(componentModel = "spring")
public interface PersonelMapper {

    //@Mapping(source = "id", target = "personelId")
    PersonelDto toDto(Personel personel);

    //@Mapping(source = "personelId", target = "id")
    Personel toEntity(PersonelDto personelDto);


}
