package hu.hansa.test.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = (Shop.TABLE_NAME))
@Getter
@Setter
@NoArgsConstructor
public class Shop {

    public static final String TABLE_NAME = "shop";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long partnerId;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = TABLE_NAME)
    private List<Purchase> purchase;
}
