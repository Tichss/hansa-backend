package hu.hansa.test.controller;

import hu.hansa.test.dto.PurchaseDto;
import hu.hansa.test.dto.ShopDto;
import hu.hansa.test.service.PurchaseService;
import hu.hansa.test.service.ShopService;
import hu.hansa.test.util.ConversionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shops")
@RequiredArgsConstructor
public class ShopController {

    private final ConversionService conversionService;
    private final ShopService shopService;

    @GetMapping
    List<ShopDto> getAll() {
        return ConversionUtil.getListResponse(shopService.getAll(), ShopDto.class, conversionService);
    }

    @GetMapping("/{id}")
    ShopDto get(@PathVariable Long id) {
        return conversionService.convert(shopService.getByIdOrThrow(id), ShopDto.class);
    }
}
