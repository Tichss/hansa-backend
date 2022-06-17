package hu.hansa.test.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = (Purchase.TABLE_NAME))
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Purchase {

    public static final String TABLE_NAME = "purchase";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    private Integer price;

    private Integer cashRegisterId;

    private Long partnerId;

    @ManyToOne
    private Shop shop;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = TABLE_NAME)
    private Set<PurchaseProduct> purchaseProducts;

    public Purchase map(Purchase other) {
        return this;
    }

}
