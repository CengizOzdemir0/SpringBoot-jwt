package cengiz.data.mapper;

import cengiz.data.dto.KullaniciDto;
import cengiz.data.entity.Kullanici;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-20T15:25:49+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class KullaniciMapperImpl implements KullaniciMapper {

    @Override
    public KullaniciDto toDto(Kullanici kullanici) {
        if ( kullanici == null ) {
            return null;
        }

        KullaniciDto kullaniciDto = new KullaniciDto();

        kullaniciDto.setId( kullanici.getId() );
        kullaniciDto.setAd( kullanici.getAd() );
        kullaniciDto.setSoyad( kullanici.getSoyad() );
        kullaniciDto.setEmail( kullanici.getEmail() );
        kullaniciDto.setPassword( kullanici.getPassword() );
        kullaniciDto.setUuid( kullanici.getUuid() );

        return kullaniciDto;
    }

    @Override
    public Kullanici toEntity(KullaniciDto kullaniciDto) {
        if ( kullaniciDto == null ) {
            return null;
        }

        Kullanici kullanici = new Kullanici();

        kullanici.setId( kullaniciDto.getId() );
        kullanici.setAd( kullaniciDto.getAd() );
        kullanici.setSoyad( kullaniciDto.getSoyad() );
        kullanici.setEmail( kullaniciDto.getEmail() );
        kullanici.setPassword( kullaniciDto.getPassword() );
        kullanici.setUuid( kullaniciDto.getUuid() );

        return kullanici;
    }
}
