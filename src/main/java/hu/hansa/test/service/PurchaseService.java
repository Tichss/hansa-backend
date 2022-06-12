package hu.hansa.test.service;

import hu.hansa.test.common.key.NotFoundMessageKey;
import hu.hansa.test.common.service.AService;
import hu.hansa.test.persistence.entity.Purchase;
import hu.hansa.test.persistence.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService extends AService<PurchaseRepository, Purchase> {

    public PurchaseService(final PurchaseRepository repository) {
        super(repository, NotFoundMessageKey.USER);
    }

    protected Purchase updateInternal(final Purchase existingEntity, final Purchase modifiedEntity) {
        return existingEntity.map(modifiedEntity);
    }


}
