package cengiz.controller;


import cengiz.data.dto.YetkiDto;
import cengiz.exceptions.CustomResponse;
import cengiz.service.YetkiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/yetki")
@RequiredArgsConstructor
public class YetkiController {

    private final YetkiService yetkiService;

    @PostMapping
    //TODO yetki tanimlanacak
    public CustomResponse<YetkiDto> save(@RequestBody YetkiDto yetkiDto) {
        return new CustomResponse("Yetki tanimlandi","YTK1",yetkiService.save(yetkiDto));
    }

    @PostMapping("/find/{id}")
    public CustomResponse<YetkiDto> findById(@PathVariable Integer id) {
        return new CustomResponse("Sorgu basarili","OK",yetkiService.findById(id));
    }


}
