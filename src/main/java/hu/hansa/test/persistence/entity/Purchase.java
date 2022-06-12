package hu.hansa.test.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = (Purchase.TABLE_NAME))
@Getter
@Setter
@NoArgsConstructor
public class Purchase {

    public static final String TABLE_NAME = "purchase";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(columnDefinition= "TIMESTAMP")
    private LocalDateTime createdAt;

    private Integer price;

    private Integer cashRegisterId;

    private Long partnerId;

    @ManyToOne
    private Shop shop; //where this buyed from

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = TABLE_NAME)
    private List<PurchaseProduct> purchaseProducts;

    public Purchase map(Purchase other) {
        return this;
    }

}
