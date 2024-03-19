package com.ti.lav.lavender.model;

import lombok.*;

import java.math.BigDecimal;

@Data
public class EstServicesDTO extends BaseTransactionDTO{

    private Long estId;
    private String name;
    private String categoryType;
    private Long parentId; // Reference to parent service
    private BigDecimal salePrice;
    private BigDecimal maxPrice;
    private BigDecimal discountPrice;
    private BigDecimal discountPercentage;
    private Integer duration;
    //private List<EstServicesDTO> childService; // Reference to parent service
}
