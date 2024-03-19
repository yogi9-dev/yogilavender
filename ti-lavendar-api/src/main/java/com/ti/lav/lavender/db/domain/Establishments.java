package com.ti.lav.lavender.db.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ESTABLISHMENTS")
public class Establishments extends BaseTransactionDomain {

    @Column(name = "Est_Name")
    private String name;

    @Column(name = "Est_Addr_Line1")
    private String addressLine1;

    @Column(name = "Est_Addr_Line2")
    private String addressLine2;

    @Column(name = "Est_Addr_Area")
    private String area;

    @Column(name = "Est_Addr_State")
    private String state;

    @Column(name = "Est_Addr_Country")
    private String country;

    @Column(name = "Est_Addr_Pincode")
    private String pincode;

    @Column(name = "Est_Geo_Location")
    private String geoLocation;

    // Getters and setters
}
