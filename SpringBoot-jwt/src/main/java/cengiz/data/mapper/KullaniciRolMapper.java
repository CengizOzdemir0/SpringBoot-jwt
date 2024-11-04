package cengiz.data.mapper;

import cengiz.data.dto.KullaniciRolDto;
import cengiz.data.entity.KullaniciRol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KullaniciRolMapper {

    KullaniciRolDto toDto(KullaniciRol kullaniciRol);

    KullaniciRol toEntity(KullaniciRolDto kullaniciYetkiDto);

}
