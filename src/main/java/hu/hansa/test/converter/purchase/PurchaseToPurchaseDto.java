package hu.hansa.test.converter.purchase;

import hu.hansa.test.dto.PurchaseDto;
import hu.hansa.test.dto.PurchaseProductDto;
import hu.hansa.test.dto.ShopDto;
import hu.hansa.test.persistence.entity.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PurchaseToPurchaseDto implements Converter<Purchase, PurchaseDto> {

    private final ConversionService conversionService;
    /**
     * {@inheritDoc}
     */
    @Override
    public PurchaseDto convert(final Purchase source) {
        final PurchaseDto target = new PurchaseDto();
        target.setId(source.getId());
        target.setCreatedAt(source.getCreatedAt());
        target.setPrice(source.getPrice());
        target.setCashRegisterId(source.getCashRegisterId());
        target.setPartnerId(source.getPartnerId());
        target.setShop(conversionService.convert(source.getShop(), ShopDto.class));
        target.setPurchaseProducts(source.getPurchaseProducts().stream().map(purchaseProduct ->
                conversionService.convert(purchaseProduct, PurchaseProductDto.class)).collect(Collectors.toList()));
        return target;
    }
}
