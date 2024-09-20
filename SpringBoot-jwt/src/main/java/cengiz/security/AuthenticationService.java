package cengiz.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cengiz.data.dto.KullaniciDto;
import cengiz.data.dto.LoginKullaniciDto;
import cengiz.data.entity.Kullanici;
import cengiz.data.mapper.KullaniciMapper;
import cengiz.repository.KullaniciRepository;

import java.util.UUID;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@Service
public class AuthenticationService {

    private final KullaniciRepository kullaniciRepository;

    private final PasswordEncoder passwordEncoder;

    private final KullaniciMapper kullaniciMapper;

    public AuthenticationService(
            KullaniciRepository kullaniciRepository,
            PasswordEncoder passwordEncoder,
            KullaniciMapper kullaniciMapper
    ) {
        this.kullaniciRepository = kullaniciRepository;
        this.passwordEncoder = passwordEncoder;
        this.kullaniciMapper = kullaniciMapper;
    }

    public KullaniciDto signup(KullaniciDto kullaniciDto) {
        kullaniciDto.setUuid(UUID.randomUUID());
        Kullanici kullanici = kullaniciMapper.toEntity(kullaniciDto);
        kullanici.setPassword(passwordEncoder.encode(kullaniciDto.getPassword()));
        kullaniciRepository.save(kullanici);
        return kullaniciDto;
    }

    public KullaniciDto authenticate(LoginKullaniciDto loginKullaniciDto) {
        return kullaniciMapper.toDto(kullaniciRepository.findByEmail(loginKullaniciDto.getEmail())
                .orElseThrow());
    }
}
