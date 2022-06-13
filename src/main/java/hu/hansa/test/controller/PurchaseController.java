package hu.hansa.test.controller;
import hu.hansa.test.dto.PageableResponse;
import hu.hansa.test.dto.ProductDto;
import hu.hansa.test.dto.PurchaseDto;
import hu.hansa.test.persistence.entity.Purchase;
import hu.hansa.test.service.PurchaseService;
import hu.hansa.test.util.ConversionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final ConversionService conversionService;
    private final PurchaseService purchaseService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping
    PageableResponse<PurchaseDto> getAll(final @RequestParam int page) {
        return ConversionUtil.getPageableResponse(
                purchaseService.getAll(PageRequest.of(page - 1, 20, Sort.by("createdAt").descending())),
                PurchaseDto.class,
                conversionService);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/{id}")
    PurchaseDto get(final @PathVariable Long id) {
        return conversionService.convert(purchaseService.getByIdOrThrow(id), PurchaseDto.class);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("/{id}")
    void delete(final @PathVariable Long id) {
        final Purchase purchase = purchaseService.getByIdOrThrow(id);
        purchaseService.delete(purchase.getId());
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping
    void add(final @Valid @RequestBody PurchaseDto purchaseDto) {
        final Purchase purchase = conversionService.convert(purchaseDto, Purchase.class);
        System.out.println("Shop " + purchase.getShop().getName());
        System.out.println("Product " + purchase.getPurchaseProducts().stream().findFirst().get().getProduct().getName());
        purchaseService.save(purchase);
    }
}
