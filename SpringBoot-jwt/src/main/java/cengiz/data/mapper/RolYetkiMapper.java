package cengiz.data.mapper;


import cengiz.data.dto.RolYetkiDto;
import cengiz.data.entity.RolYetki;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolYetkiMapper {


    RolYetkiDto toDto(RolYetki rolYetki);

    RolYetki toEntity(RolYetkiDto rolYetkiDto);


}
