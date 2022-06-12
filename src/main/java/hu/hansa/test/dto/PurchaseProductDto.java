package hu.hansa.test.dto;

import hu.hansa.test.converter.product.ProductToProductDto;
import lombok.Data;

@Data
public class PurchaseProductDto {
    private Long id;
    private ProductDto product;
    private Double amount;
    private Double priceBrutto;
    private Long partnerId;
}
