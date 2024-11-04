package cengiz.service;


import cengiz.data.dto.RolYetkiDto;
import cengiz.data.mapper.RolYetkiMapper;
import cengiz.repository.RolYetkiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolYetkiService {

    private final RolYetkiRepository rolYetkiRepository;
    private final RolYetkiMapper rolYetkiMapper;

    public RolYetkiDto save(RolYetkiDto rolYetkiDto) {
        return rolYetkiMapper.toDto(rolYetkiRepository.save(rolYetkiMapper.toEntity(rolYetkiDto)));
    }



}
