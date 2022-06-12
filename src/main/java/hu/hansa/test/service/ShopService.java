package hu.hansa.test.service;

import hu.hansa.test.common.key.NotFoundMessageKey;
import hu.hansa.test.common.service.AService;
import hu.hansa.test.persistence.entity.Shop;
import hu.hansa.test.persistence.repository.ShopRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopService extends AService<ShopRepository, Shop> {
    public ShopService(final ShopRepository repository) {
        super(repository, NotFoundMessageKey.USER);
    }

    @Override
    protected Shop updateInternal(Shop existingEntity, Shop modifiedEntity) {
        return null;
    }
}
