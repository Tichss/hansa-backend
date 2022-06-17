package hu.hansa.test.service;

import hu.hansa.test.common.key.NotFoundMessageKey;
import hu.hansa.test.common.service.AService;
import hu.hansa.test.persistence.entity.PurchaseProduct;
import hu.hansa.test.persistence.repository.PurchaseProductRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseProductService extends AService<PurchaseProductRepository, PurchaseProduct> {

    public PurchaseProductService(final PurchaseProductRepository repository) {
        super(repository, NotFoundMessageKey.USER);
    }

    @Override
    protected PurchaseProduct updateInternal(PurchaseProduct existingEntity, PurchaseProduct modifiedEntity) {
        return null;
    }
}
