package com.ti.lav.lavender.db.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EST_SERVICEADDONNMAP")
public class EstServiceAddOnnMap extends BaseTransactionDomain{

    @Column(name = "MAP_ID")
    private Long mapId;
}
