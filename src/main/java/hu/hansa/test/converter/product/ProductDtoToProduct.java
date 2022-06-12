package hu.hansa.test.converter.product;

import hu.hansa.test.dto.ProductDto;
import hu.hansa.test.persistence.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoToProduct implements Converter<ProductDto, Product> {

    @Override
    public Product convert(ProductDto source) {
        final Product target = new Product();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPrice(source.getPrice());
        target.setAmountUnit(source.getAmountUnit());
        target.setArticleNumber(source.getArticleNumber());
        target.setBarCode(source.getBarCode());
        target.setVersion(source.getVersion());
        target.setPartnerId(source.getPartnerId());
        return target;
    }
}
