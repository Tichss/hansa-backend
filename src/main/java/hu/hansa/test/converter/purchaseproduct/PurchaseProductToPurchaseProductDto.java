package hu.hansa.test.converter.purchaseproduct;

import hu.hansa.test.dto.ProductDto;
import hu.hansa.test.dto.PurchaseProductDto;
import hu.hansa.test.persistence.entity.PurchaseProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import org.springframework.core.convert.converter.Converter;

@Component
@RequiredArgsConstructor
public class PurchaseProductToPurchaseProductDto implements Converter<PurchaseProduct, PurchaseProductDto> {

    private final ConversionService conversionService;

    @Override
    public PurchaseProductDto convert(PurchaseProduct source) {
        PurchaseProductDto target = new PurchaseProductDto();
        target.setId(source.getId());
        target.setAmount(source.getAmount());
        target.setProduct(conversionService.convert(source.getProduct(), ProductDto.class));
        target.setPriceBrutto(source.getPriceBrutto());
        target.setPartnerId(source.getPartnerId());
        return target;
    }
}
