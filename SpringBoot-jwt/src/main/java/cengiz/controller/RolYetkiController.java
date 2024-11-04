package cengiz.controller;


import cengiz.data.dto.RolYetkiDto;
import cengiz.exceptions.CustomResponse;
import cengiz.service.RolYetkiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("rol-yetki")
public class RolYetkiController {

    private final RolYetkiService rolYetkiService;

    @PostMapping
    public CustomResponse<RolYetkiDto> save(@RequestBody RolYetkiDto rolYetkiDto) {
        return new CustomResponse("Kayit basarili","Ok",rolYetkiService.save(rolYetkiDto));
    }

}


