package com.ti.lav.lavender.db.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EST_OPENINGHOURS")
public class EstOpeningHours extends BaseTransactionDomain{

    @Column(name = "Est_Id")
    private Long estId;

    @Column(name = "Day_Of_Week_Is_Open")
    private String dayofweekisopen;

    @Column(name = "Start_Hour")
    private String starthour;

    @Column(name = "End_Hour")
    private String endhour;
}
