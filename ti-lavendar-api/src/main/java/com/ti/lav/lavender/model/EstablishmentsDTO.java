package com.ti.lav.lavender.model;

import com.ti.lav.lavender.db.domain.EstOpeningHours;
import lombok.*;

import java.util.List;

@Data
public class EstablishmentsDTO extends BaseTransactionDTO{

    private String name;
    private String about;
    private String addressLine1;
    private String addressLine2;
    private String area;
    private String state;
    private String country;
    private String pincode;
    private String geoLocation;

    private List<EstServicesDTO> services; // Reference to parent service
    private List<EstEmployeesDTO> employees; //Reference to parent service
    private List<EstImagesDTO> images;
    private List<EstOpeningHoursDTO> openingHours;
    private List<EstServiceAddOnnMapDTO> serviceAddOnnMap;

    // Getters and setters
}
