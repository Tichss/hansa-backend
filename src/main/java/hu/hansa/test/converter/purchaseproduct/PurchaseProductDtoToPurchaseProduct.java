package hu.hansa.test.converter.purchaseproduct;

import hu.hansa.test.dto.ProductDto;
import hu.hansa.test.dto.PurchaseProductDto;
import hu.hansa.test.persistence.entity.Product;
import hu.hansa.test.persistence.entity.PurchaseProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PurchaseProductDtoToPurchaseProduct implements Converter<PurchaseProductDto, PurchaseProduct> {

    private final ConversionService conversionService;

    @Override
    public PurchaseProduct convert(PurchaseProductDto source) {
        PurchaseProduct target = new PurchaseProduct();
        target.setId(source.getId());
        target.setAmount(source.getAmount());
        target.setProduct(conversionService.convert(source.getProduct(), Product.class));
        target.setPriceBrutto(source.getPriceBrutto());
        target.setPartnerId(source.getPartnerId());
        return target;
    }
}
