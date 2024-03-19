package com.ti.lav.lavender.model;

import lombok.*;

@Data
public class EstSearchCriteriaDTO {

    private String serviceName;
    private Double minSalePrice;
    private Double maxSalePrice;
    private Integer minDuration;
    private Integer maxDuration;

    // Constructors, getters, and setters
}
