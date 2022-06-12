package hu.hansa.test.service;

import hu.hansa.test.common.key.NotFoundMessageKey;
import hu.hansa.test.common.service.AService;
import hu.hansa.test.persistence.entity.Product;
import hu.hansa.test.persistence.entity.Purchase;
import hu.hansa.test.persistence.repository.ProductRepository;
import hu.hansa.test.persistence.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AService<ProductRepository, Product> {
    public ProductService(final ProductRepository repository) {
        super(repository, NotFoundMessageKey.USER);
    }

    @Override
    protected Product updateInternal(Product existingEntity, Product modifiedEntity) {
        return null;
    }
}
