package hu.hansa.test.common.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AIdRepository<T, I> extends CrudRepository<T, I> {
    /**
     * Find all.
     *
     * @return List of all entities.
     */
    List<T> findAll();

    /**
     * Find all T by page.
     *
     * @param pageable the given Pageable object
     * @return Page with T items
     */
    Page<T> findAll(Pageable pageable);

    /**
     * Find all T's by specification.
     *
     * @param specification filter specification
     * @return list of T's
     */
    List<T> findAll(Specification<T> specification);

    /**
     * Find all T by page by specification.
     *
     * @param specification the given specification object
     * @param pageable      the given Pageable object
     * @return Page with T items
     */
    Page<T> findAll(Specification<T> specification, Pageable pageable);

    /**
     * {@inheritDoc}
     */
    @Override
    void deleteAll();
}
