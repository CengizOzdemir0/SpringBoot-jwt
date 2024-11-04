package cengiz.data.mapper;


import cengiz.data.dto.RolDto;
import cengiz.data.entity.Rol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolMapper {


    RolDto toDto(Rol rol);

    Rol toEntity(RolDto rolDto);


}
