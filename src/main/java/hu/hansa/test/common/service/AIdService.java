package hu.hansa.test.common.service;

import java.util.List;
import java.util.Optional;

import hu.hansa.test.common.exception.NotFoundException;
import hu.hansa.test.common.key.MessageKey;
import hu.hansa.test.common.repository.AIdRepository;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Getter
@Service
@Slf4j
@RequiredArgsConstructor
public abstract class AIdService<S extends AIdRepository<T, I>, T, I> {

    private final S repository;
    private final MessageKey type;

    public List<T> getAll() {
        return repository.findAll();
    }

    public Page<T> getAll(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<T> getAll(final @NonNull Specification<T> specification) {
        return repository.findAll(specification);
    }

    public Page<T> getAll(final Pageable pageable, final Specification<T> filter) {
        return repository.findAll(filter, pageable);
    }

    public void delete(final I id) {
        final T entity = this.getByIdOrThrow(id);

        repository.delete(entity);
    }

    public T getByIdOrThrow(final I id) throws NotFoundException {
        return repository.findById(id).orElseThrow(this::getNotFoundException);
    }

    public Optional<T> getById(final I id) {
        return repository.findById(id);
    }

    public T save(final T entity) {
        return repository.save(entity);
    }

    public Iterable<T> saveAll(final List<T> entities) {
        return repository.saveAll(entities);
    }

    public T update(final I id, final T entity) {
        final T existingEntity = getByIdOrThrow(id);
        final T updatedEntity = updateInternal(existingEntity, entity);

        return save(updatedEntity);
    }

    public long count() {
        return this.repository.count();
    }

    public void deleteAll() {
        this.repository.deleteAll();
    }

    public void deleteAll(final Iterable<T> entities) {
        this.repository.deleteAll(entities);
    }

    protected NotFoundException getNotFoundException() {
        return new NotFoundException(this.type);
    }

    protected abstract T updateInternal(T existingEntity, T modifiedEntity);
}

