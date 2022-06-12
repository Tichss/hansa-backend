package hu.hansa.test.controller;

import hu.hansa.test.dto.ProductDto;
import hu.hansa.test.dto.ShopDto;
import hu.hansa.test.persistence.entity.Product;
import hu.hansa.test.service.ProductService;
import hu.hansa.test.util.ConversionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ConversionService conversionService;
    private final ProductService productService;

    @GetMapping
    List<ProductDto> getAll() {
        return ConversionUtil.getListResponse(productService.getAll(), ProductDto.class, conversionService);
    }

    @GetMapping("/{id}")
    ProductDto get(@PathVariable Long id) {
        return conversionService.convert(productService.getByIdOrThrow(id), ProductDto.class);
    }

    @PostMapping
    ProductDto create(final @RequestBody ProductDto productDto) {
        Product product = conversionService.convert(productDto, Product.class);
        product = productService.save(product);
        return conversionService.convert(product, ProductDto.class);
    }

    @PutMapping
    ProductDto update(final @RequestBody ProductDto productDto) {
        Product product = conversionService.convert(productDto, Product.class);
        productService.getByIdOrThrow(product.getId());
        product = productService.update(product.getId(), product);
        return conversionService.convert(product, ProductDto.class);
    }
}
