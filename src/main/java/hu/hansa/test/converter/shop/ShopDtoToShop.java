package hu.hansa.test.converter.shop;

import hu.hansa.test.dto.ShopDto;
import hu.hansa.test.persistence.entity.Shop;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ShopDtoToShop implements Converter<ShopDto, Shop> {

    @Override
    public Shop convert(ShopDto source) {
        final Shop target = new Shop();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPartnerId(source.getPartnerId());
        return target;
    }
}
