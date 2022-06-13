package hu.hansa.test.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = (Shop.TABLE_NAME))
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Shop {

    public static final String TABLE_NAME = "shop";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long partnerId;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = TABLE_NAME)
    private Set<Purchase> purchase;
}
