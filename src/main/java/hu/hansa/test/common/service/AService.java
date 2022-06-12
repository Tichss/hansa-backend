package hu.hansa.test.common.service;

import java.util.List;
import java.util.Optional;

import hu.hansa.test.common.key.MessageKey;
import hu.hansa.test.common.repository.ARepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Getter
@Service
@Slf4j
public abstract class AService<S extends ARepository<T>, T> extends AIdService<S, T, Long> {

    public AService(final S repository, final MessageKey type) {
        super(repository, type);
    }

    public List<T> getByIds(final List<Long> ids) {
        return this.getRepository().findAllByIdIn(ids);
    }

    public Optional<T> getFirst() {
        return this.getRepository().findFirstByIdNotNullOrderById();
    }
}
