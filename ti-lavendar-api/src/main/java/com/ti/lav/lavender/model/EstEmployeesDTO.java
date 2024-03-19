package com.ti.lav.lavender.model;

import lombok.*;

import java.util.List;

@Data
public class EstEmployeesDTO extends BaseTransactionDTO{

    private Long employeeId;
    private String employeeTitle;
    private String employeeImage;
}
