package hu.hansa.test.converter.purchase;

import hu.hansa.test.dto.PurchaseDto;
import hu.hansa.test.dto.PurchaseProductDto;
import hu.hansa.test.persistence.entity.Purchase;
import hu.hansa.test.persistence.entity.PurchaseProduct;
import hu.hansa.test.persistence.entity.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PurchaseDtoToPurchase implements Converter<PurchaseDto, Purchase> {

    private final ConversionService conversionService;
    /**
     * {@inheritDoc}
     */
    @Override
    public Purchase convert(final PurchaseDto source) {
        final Purchase target = new Purchase();
        target.setPrice(source.getPrice());
        target.setCashRegisterId(source.getCashRegisterId());
        target.setPartnerId(source.getPartnerId());
        target.setShop(conversionService.convert(source.getShop(), Shop.class));
        target.setPurchaseProducts(source.getPurchaseProducts().stream().map(purchaseProductDto ->
                conversionService.convert(purchaseProductDto, PurchaseProduct.class)).collect(Collectors.toSet()));
        return target;
    }
}
