package cengiz.service;


import cengiz.data.dto.RolDto;
import cengiz.data.entity.Rol;
import cengiz.data.mapper.RolMapper;
import cengiz.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolDto save(RolDto rolDto) {
        return rolMapper.toDto(rolRepository.save(rolMapper.toEntity(rolDto)));
    }

    public Optional<Rol> findById(Integer id) {
        return rolRepository.findById(id);
    }



}
