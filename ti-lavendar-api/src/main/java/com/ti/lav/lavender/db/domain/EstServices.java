package com.ti.lav.lavender.db.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EST_SERVICES")
public class EstServices extends BaseTransactionDomain{

    @Column(name = "EST_ID")
    private Long estId;

    @Column(name = "ES_NAME")
    private String name;

    @Column(name = "ES_CATEGORY_TYPE")
    private String categoryType;

    @Column(name = "ES_PARENT_ID")
    private String parentId;

    @Column(name = "ES_SALE_PRICE")
    private Double salePrice;

    @Column(name = "ES_MAX_PRICE")
    private Double maxPrice;

    @Column(name = "ES_DISCOUNT_PRICE")
    private Double discountPrice;

    @Column(name = "ES_DISCOUNT_PERCENTAGE")
    private Double discountPercentage;

    @Column(name = "ES_DURATION")
    private Integer duration;

    // Getters and setters
}

