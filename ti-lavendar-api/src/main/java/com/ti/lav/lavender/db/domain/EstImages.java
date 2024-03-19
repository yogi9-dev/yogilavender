package com.ti.lav.lavender.db.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EST_IMAGES")
public class EstImages extends BaseTransactionDomain{

    @Column(name = "Image_ID")
    private Long imageId;

    @Column(name = "Image_Category")
    private String imageCategory;

    @Column(name = "Image_Data")
    private String imageData;
}
