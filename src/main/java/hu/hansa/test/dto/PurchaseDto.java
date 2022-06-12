package hu.hansa.test.dto;

import hu.hansa.test.persistence.entity.PurchaseProduct;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PurchaseDto {


    private Long id;

    private LocalDateTime createdAt;

    private Integer price;

    private Integer cashRegisterId;

    private Long partnerId;

    private ShopDto shop;

    private List<PurchaseProductDto> purchaseProducts;


}
