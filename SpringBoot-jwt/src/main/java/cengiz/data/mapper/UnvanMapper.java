package cengiz.data.mapper;

import org.mapstruct.Mapper;

import cengiz.data.dto.UnvanDto;
import cengiz.data.entity.Unvan;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Mapper(componentModel = "spring")
public interface UnvanMapper {

    UnvanDto toDto(Unvan unvan);

    Unvan toEntity(UnvanDto unvanDto);
}
