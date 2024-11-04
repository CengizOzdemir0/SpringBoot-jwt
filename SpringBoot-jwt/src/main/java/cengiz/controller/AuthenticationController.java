package cengiz.controller;

import cengiz.data.entity.Yetki;
import cengiz.service.KullaniciService;
import cengiz.service.YetkiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import cengiz.configuration.redis.RedisService;
import cengiz.data.dto.KullaniciDto;
import cengiz.data.dto.KullaniciYetkiG;
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
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    private final RedisService redisService;

    private final YetkiService yetkiService;
    private final KullaniciService kullaniciService;


    @PostMapping("/signup")
    public CustomResponse<KullaniciDto> register(@RequestBody KullaniciDto kullaniciDto) {
        KullaniciDto registeredKullanici = authenticationService.signup(kullaniciDto);
        return new CustomResponse<>("Kullanıcı başarıyla oluşturuldu.", "SCSS_200", registeredKullanici);
    }

    @PostMapping("/login")
    public CustomResponse<LoginResponse> authenticate(@RequestBody LoginKullaniciDto loginKullaniciDto) {
        KullaniciDto kullaniciByEmail = kullaniciService.getKullaniciByEmail(loginKullaniciDto.getEmail());
        List<Yetki> allkullaniciYetkiList = yetkiService.findAllkullaniciYetkiList(kullaniciByEmail.getId());;
        if(allkullaniciYetkiList.isEmpty()) {
            throw new RuntimeException("Kullaninin Yetki tanimlamasi yoktur !");
        }

        KullaniciDto authenticatedUser = authenticationService.authenticate(loginKullaniciDto);
        TokenDto tokenDto = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(tokenDto.getToken());
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        RedisKullaniciDto redisKullaniciDto =  new RedisKullaniciDto();
        redisKullaniciDto.setKullaniciDto(authenticatedUser);
        redisKullaniciDto.setSubUuid(tokenDto.getSubUuid());


        List<KullaniciYetkiG> list = new ArrayList<>();
        allkullaniciYetkiList.forEach(yetki -> list.add(new KullaniciYetkiG(yetki.getAdi())));
        //list.add(new KullaniciYetkiG("USER"));
        //list.add(new KullaniciYetkiG("ADMIN"));

        redisKullaniciDto.setYetkiList(list);

        redisService.saveValue(tokenDto.getUuid(), redisKullaniciDto);
        return new CustomResponse<>("Kullanıcı login işlemi başarıyla yapıldı.","LGN_200",loginResponse);
    }

}

