package hu.hansa.test.controller;
import hu.hansa.test.dto.PageableResponse;
import hu.hansa.test.dto.ProductDto;
import hu.hansa.test.dto.PurchaseDto;
import hu.hansa.test.persistence.entity.Purchase;
import hu.hansa.test.service.PurchaseProductService;
import hu.hansa.test.service.PurchaseService;
import hu.hansa.test.util.ConversionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final ConversionService conversionService;
    private final PurchaseService purchaseService;
    private final PurchaseProductService purchaseProductService;

    @GetMapping
    PageableResponse<PurchaseDto> getAll(final @RequestParam int page, final @RequestParam int orderMode) {
        if (orderMode == 1) {
            return ConversionUtil.getPageableResponse(
                    purchaseService.getAll(PageRequest.of(page - 1, 20, Sort.by("createdAt").descending())),
                    PurchaseDto.class,
                    conversionService);
        } else if (orderMode == 2) {
            return ConversionUtil.getPageableResponse(
                purchaseService.getAll(PageRequest.of(page - 1, 20, Sort.by("createdAt").ascending())),
                PurchaseDto.class,
                conversionService);
        } else if (orderMode == 3) {
            return ConversionUtil.getPageableResponse(
                purchaseService.getAll(PageRequest.of(page - 1, 20, Sort.by("price").descending())),
                PurchaseDto.class,
                conversionService);
        } else if (orderMode == 4) {
            return ConversionUtil.getPageableResponse(
                purchaseService.getAll(PageRequest.of(page - 1, 20, Sort.by("price").ascending())),
                PurchaseDto.class,
                conversionService);
        } else if (orderMode == 5) {
            return ConversionUtil.getPageableResponse(
                purchaseService.getAll(PageRequest.of(page - 1, 20, Sort.by("shop.name").ascending())),
                PurchaseDto.class,
                conversionService);
        } else {
            return ConversionUtil.getPageableResponse(
                purchaseService.getAll(PageRequest.of(page - 1, 20, Sort.by("shop.name").descending())),
                PurchaseDto.class,
                conversionService);
        }
    }

    @GetMapping("/{id}")
    PurchaseDto get(final @PathVariable Long id) {
        return conversionService.convert(purchaseService.getByIdOrThrow(id), PurchaseDto.class);
    }

    @DeleteMapping("/{id}")
    void delete(final @PathVariable Long id) {
        final Purchase purchase = purchaseService.getByIdOrThrow(id);
        purchaseService.delete(purchase.getId());
    }

    @PostMapping
    PurchaseDto add(final @Valid @RequestBody PurchaseDto purchaseDto) {
        final Purchase purchase = conversionService.convert(purchaseDto, Purchase.class);
        purchase.getPurchaseProducts().stream().forEach(purchaseProduct -> purchaseProduct.setPurchase(purchase));
        purchaseService.save(purchase);
        return conversionService.convert(purchase, PurchaseDto.class);
    }

    @PutMapping
    PurchaseDto update(final @Valid @RequestBody PurchaseDto purchaseDto) {
        final Purchase purchase = conversionService.convert(purchaseDto, Purchase.class);
        purchase.setId(purchaseDto.getId());
        purchase.getPurchaseProducts().stream().forEach(purchaseProduct -> purchaseProduct.setPurchase(purchase));
        purchase.getPurchaseProducts().stream().forEach(purchaseProduct -> purchaseProductService.save(purchaseProduct));
        purchase.setCreatedAt(LocalDateTime.now());
        purchaseService.save(purchase);
        return conversionService.convert(purchase, PurchaseDto.class);
    }
}
