package cengiz.data.mapper;

import cengiz.data.dto.UnvanDto;
import cengiz.data.entity.Unvan;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-20T15:25:48+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class UnvanMapperImpl implements UnvanMapper {

    @Override
    public UnvanDto toDto(Unvan unvan) {
        if ( unvan == null ) {
            return null;
        }

        UnvanDto unvanDto = new UnvanDto();

        unvanDto.setId( unvan.getId() );
        unvanDto.setUnvanKodu( unvan.getUnvanKodu() );
        unvanDto.setUnvanAdi( unvan.getUnvanAdi() );
        unvanDto.setUnvanVerilisTarihi( unvan.getUnvanVerilisTarihi() );
        unvanDto.setUnvanGuncellenmeTarihi( unvan.getUnvanGuncellenmeTarihi() );
        unvanDto.setUnvanGuncelleyenPersonelId( unvan.getUnvanGuncelleyenPersonelId() );

        return unvanDto;
    }

    @Override
    public Unvan toEntity(UnvanDto unvanDto) {
        if ( unvanDto == null ) {
            return null;
        }

        Unvan unvan = new Unvan();

        unvan.setId( unvanDto.getId() );
        unvan.setUnvanKodu( unvanDto.getUnvanKodu() );
        unvan.setUnvanAdi( unvanDto.getUnvanAdi() );
        unvan.setUnvanVerilisTarihi( unvanDto.getUnvanVerilisTarihi() );
        unvan.setUnvanGuncellenmeTarihi( unvanDto.getUnvanGuncellenmeTarihi() );
        unvan.setUnvanGuncelleyenPersonelId( unvanDto.getUnvanGuncelleyenPersonelId() );

        return unvan;
    }
}
