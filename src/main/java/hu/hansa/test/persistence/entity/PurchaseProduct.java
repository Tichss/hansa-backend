package hu.hansa.test.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = (PurchaseProduct.TABLE_NAME))
@Getter
@Setter
@NoArgsConstructor
public class PurchaseProduct {
    public static final String TABLE_NAME = "purchase_product";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Purchase purchase;

    @ManyToOne
    private Product product;

    private Double amount;

    private Double priceBrutto;

    private Long partnerId;


}
