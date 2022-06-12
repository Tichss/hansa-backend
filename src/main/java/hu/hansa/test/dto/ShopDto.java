package hu.hansa.test.dto;

import hu.hansa.test.persistence.entity.Purchase;
import lombok.Data;

import java.util.List;

@Data
public class ShopDto {
    private Long id;

    private String name;

    private Long partnerId;

    // private List<Purchase> purchase;
}
