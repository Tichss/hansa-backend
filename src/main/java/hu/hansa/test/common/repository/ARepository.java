package hu.hansa.test.common.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ARepository<T> extends AIdRepository<T, Long> {

    /**
     * Find by list of ids.
     *
     * @param ids List of ids.
     * @return List of entities by ids.
     */
    List<T> findAllByIdIn(List<Long> ids);

    /**
     * Get first item.
     *
     * @return Item as optional.
     */
    Optional<T> findFirstByIdNotNullOrderById();
}
