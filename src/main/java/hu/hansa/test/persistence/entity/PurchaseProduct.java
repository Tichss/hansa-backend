package hu.hansa.test.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = (PurchaseProduct.TABLE_NAME))
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PurchaseProduct {
    public static final String TABLE_NAME = "purchase_product";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@Id
    @Column(name = "purchase_id")
    private Long purchaseId;

    @Id
    @Column(name = "product_id")
    private Long productId;*/

    @ManyToOne
    /*@MapsId("purchaseId")
    @JoinColumn(name = "purchase_id")*/
    private Purchase purchase;

    @ManyToOne
    /*@MapsId("productId")
    @JoinColumn(name = "product_id")*/
    private Product product;

    private Double amount;

    private Double priceBrutto;

    private Long partnerId;


}
