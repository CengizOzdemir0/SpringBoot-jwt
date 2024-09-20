package cengiz.data.mapper;

import cengiz.data.dto.PersonelDto;
import cengiz.data.entity.Personel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-20T15:25:49+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class PersonelMapperImpl implements PersonelMapper {

    @Override
    public PersonelDto toDto(Personel personel) {
        if ( personel == null ) {
            return null;
        }

        PersonelDto personelDto = new PersonelDto();

        personelDto.setId( personel.getId() );
        personelDto.setAd( personel.getAd() );
        personelDto.setSoyad( personel.getSoyad() );
        personelDto.setYas( personel.getYas() );

        return personelDto;
    }

    @Override
    public Personel toEntity(PersonelDto personelDto) {
        if ( personelDto == null ) {
            return null;
        }

        Personel personel = new Personel();

        personel.setId( personelDto.getId() );
        personel.setAd( personelDto.getAd() );
        personel.setSoyad( personelDto.getSoyad() );
        personel.setYas( personelDto.getYas() );

        return personel;
    }
}
