package hu.hansa.test.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;

    private Long articleNumber;

    private String BarCode;

    private String name;

    private String amountUnit;

    private Double price;

    private Integer version;

    private Long partnerId;
}
