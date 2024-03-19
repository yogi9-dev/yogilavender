package com.ti.lav.lavender.model;

import lombok.*;

import java.util.List;

@Data
public class EstImagesDTO extends BaseTransactionDTO{


    private Long imageId;


    private String imageCategory;


    private String imageData;
}