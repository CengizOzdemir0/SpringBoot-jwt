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


    PersonelDto toDto(Personel personel);

    Personel toEntity(PersonelDto personelDto);


}
