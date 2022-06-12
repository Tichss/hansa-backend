package hu.hansa.test.converter.shop;

import hu.hansa.test.dto.ShopDto;
import hu.hansa.test.persistence.entity.Shop;
import org.springframework.stereotype.Component;

import org.springframework.core.convert.converter.Converter;

@Component
public class ShopToShopDto implements Converter<Shop, ShopDto> {

    @Override
    public ShopDto convert(Shop source) {
        final ShopDto target = new ShopDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPartnerId(source.getPartnerId());
        return target;
    }
}
