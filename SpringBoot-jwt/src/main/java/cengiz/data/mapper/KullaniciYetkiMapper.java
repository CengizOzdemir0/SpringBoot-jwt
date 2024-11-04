package cengiz.data.mapper;

import cengiz.data.dto.KullaniciYetkiDto;
import cengiz.data.entity.KullaniciYetki;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KullaniciYetkiMapper {

    KullaniciYetkiDto toDto(KullaniciYetki kullaniciYetki);

    KullaniciYetki toEntity(KullaniciYetkiDto kullaniciYetkiDto);

}
