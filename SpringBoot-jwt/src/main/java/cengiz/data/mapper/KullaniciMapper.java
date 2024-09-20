package cengiz.data.mapper;

import org.mapstruct.Mapper;

import cengiz.data.dto.KullaniciDto;
import cengiz.data.entity.Kullanici;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Mapper(componentModel = "spring")
public interface KullaniciMapper {

    KullaniciDto toDto(Kullanici kullanici);

    Kullanici toEntity(KullaniciDto kullaniciDto);

}
