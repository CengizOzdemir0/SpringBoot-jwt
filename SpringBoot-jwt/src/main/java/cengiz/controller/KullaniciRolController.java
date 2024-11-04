package cengiz.controller;


import cengiz.data.dto.KullaniciRolDto;
import cengiz.data.entity.KullaniciRol;
import cengiz.exceptions.CustomResponse;
import cengiz.service.KullaniciRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kullanici-rol")
@RequiredArgsConstructor
public class KullaniciRolController {

    private final KullaniciRolService kullaniciYetkiService;

    @PostMapping
    public CustomResponse<KullaniciRol> save(@RequestBody KullaniciRolDto kullaniciYetkiDto) {
        KullaniciRolDto kullaniciYetkiDto1 = kullaniciYetkiService.save(kullaniciYetkiDto);
        return new CustomResponse("Kullanici Rol tanimlamasi yapildi....","KYS1",kullaniciYetkiDto1);
    }


}
