package hu.hansa.test.controller;
import hu.hansa.test.dto.PurchaseDto;
import hu.hansa.test.service.PurchaseService;
import hu.hansa.test.util.ConversionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final ConversionService conversionService;
    private final PurchaseService purchaseService;

    @GetMapping
    List<PurchaseDto> getAll() {
        return ConversionUtil.getListResponse(purchaseService.getAll(), PurchaseDto.class, conversionService);
    }

    @GetMapping("/{id}")
    PurchaseDto get(final @PathVariable Long id) {
        return conversionService.convert(purchaseService.getByIdOrThrow(id), PurchaseDto.class);
    }
}
