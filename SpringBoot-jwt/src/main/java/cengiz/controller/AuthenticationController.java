package cengiz.controller;

import org.springframework.web.bind.annotation.*;
import cengiz.configuration.redis.RedisService;
import cengiz.data.dto.KullaniciDto;
import cengiz.data.dto.KullaniciYetki;
import cengiz.data.dto.LoginKullaniciDto;
import cengiz.data.dto.LoginResponse;
import cengiz.data.dto.RedisKullaniciDto;
import cengiz.data.dto.TokenDto;
import cengiz.exceptions.CustomResponse;
import cengiz.security.AuthenticationService;
import cengiz.security.JwtService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    private final RedisService redisService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService, RedisService redisService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.redisService = redisService;
    }

    @PostMapping("/signup")
    public CustomResponse<KullaniciDto> register(@RequestBody KullaniciDto kullaniciDto) {
        KullaniciDto registeredKullanici = authenticationService.signup(kullaniciDto);
        return new CustomResponse<>("Kullanıcı başarıyla oluşturuldu.", "SCSS_200", registeredKullanici);
    }

    @PostMapping("/login")
    public CustomResponse<LoginResponse> authenticate(@RequestBody LoginKullaniciDto loginKullaniciDto) {
        KullaniciDto authenticatedUser = authenticationService.authenticate(loginKullaniciDto);

        TokenDto tokenDto = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(tokenDto.getToken());
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        RedisKullaniciDto redisKullaniciDto =  new RedisKullaniciDto();
        redisKullaniciDto.setKullaniciDto(authenticatedUser);
        redisKullaniciDto.setSubUuid(tokenDto.getSubUuid());

        List<KullaniciYetki> list = new ArrayList<>();
        list.add(new KullaniciYetki("USER"));
        list.add(new KullaniciYetki("ADMIN"));

        redisKullaniciDto.setYetkiList(list);

        redisService.saveValue(tokenDto.getUuid(), redisKullaniciDto);
        return new CustomResponse<>("Kullanıcı login işlemi başarıyla yapıldı.","LGN_200",loginResponse);
    }

}

