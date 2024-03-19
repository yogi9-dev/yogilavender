package com.ti.lav.lavender.model;

import lombok.*;

@Data
public class EstOpeningHoursDTO extends BaseTransactionDTO{


    private Long estId;

    private String dayofweekisopen;


    private String starthour;


    private String endhour;
}