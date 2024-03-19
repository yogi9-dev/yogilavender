package com.ti.lav.lavender.db.domain;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlInlineBinaryData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EST_EMPLOYEES")
public class EstEmployees extends BaseTransactionDomain{

    @Column(name = "Employee_ID")
    private Long employeeId;

    @Column(name = "Employee_Title")
    private String employeeTitle;

    @Column(name = "Employee_Image")
    private String employeeImage;
}
