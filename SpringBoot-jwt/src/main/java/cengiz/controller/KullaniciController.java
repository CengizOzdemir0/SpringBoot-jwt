package cengiz.controller;

import cengiz.data.dto.KullaniciDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import cengiz.data.entity.Kullanici;
import cengiz.exceptions.CustomResponse;
import cengiz.service.KullaniciService;

import java.util.List;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-09-20 15:03
 */

@RestController
@RequestMapping("/kullanici")
@RequiredArgsConstructor
public class KullaniciController {

    private final KullaniciService kullaniciService;

    @GetMapping()
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<List<Kullanici>> allUsers() {
        List<Kullanici> users = kullaniciService.allUsers();
        return new CustomResponse<>("Kullanıcı listesi başarıyla çekildi.","SPR_201",users);
    }


    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<KullaniciDto> save(@RequestBody KullaniciDto kullanici) {
        KullaniciDto user = kullaniciService.createKullanici(kullanici);
        return new CustomResponse<>("Kullanıcı listesi başarıyla kaydedildi.","SPR_202",user);
    }


}
