package hu.hansa.test.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = (Product.TABLE_NAME))
@Getter
@Setter
@NoArgsConstructor
public class Product {
    public static final String TABLE_NAME = "product";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long articleNumber;

    private String BarCode;

    private String name;

    private String amountUnit;

    private Double price;

    private Integer version;

    private Long partnerId;

}
