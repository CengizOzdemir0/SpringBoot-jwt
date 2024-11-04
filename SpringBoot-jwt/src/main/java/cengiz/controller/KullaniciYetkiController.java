package cengiz.controller;


import cengiz.data.dto.KullaniciYetkiDto;
import cengiz.data.entity.KullaniciYetki;
import cengiz.exceptions.CustomResponse;
import cengiz.service.KullaniciYetkiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kullanici-yetki")
@RequiredArgsConstructor
public class KullaniciYetkiController {

    private final KullaniciYetkiService kullaniciYetkiService;

    @PostMapping
    public CustomResponse<KullaniciYetki> save(@RequestBody KullaniciYetkiDto kullaniciYetkiDto) {
        KullaniciYetkiDto kullaniciYetkiDto1 = kullaniciYetkiService.save(kullaniciYetkiDto);
        return new CustomResponse("Kullanici Yetki tanimlamasi yapildi.","KYS1",kullaniciYetkiDto1);
    }


}
