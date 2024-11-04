package cengiz.service;


import cengiz.data.dto.RolYetkiDto;
import cengiz.data.entity.RolYetki;
import cengiz.data.mapper.RolYetkiMapper;
import cengiz.repository.RolYetkiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolYetkiService {

    private final RolYetkiRepository rolYetkiRepository;
    private final RolYetkiMapper rolYetkiMapper;

    public RolYetkiDto save(RolYetkiDto rolYetkiDto) {
        return rolYetkiMapper.toDto(rolYetkiRepository.save(rolYetkiMapper.toEntity(rolYetkiDto)));
    }

    public List<RolYetki> findByFkRolId(Integer rolId) {
        return rolYetkiRepository.findByFkRolId(rolId);
    }



}
