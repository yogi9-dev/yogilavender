package com.ti.lav.lavender.service;


import com.ti.lav.lavender.common.BusinessException;
import com.ti.lav.lavender.db.domain.*;
import com.ti.lav.lavender.db.repository.EstablishmentRepository;
import com.ti.lav.lavender.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EstablishmentService extends BaseService {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    public EstablishmentsDTO saveEstablishemt(EstablishmentsDTO establishmentsDTO) throws BusinessException {
        EstablishmentsDTO updatedEstablishmentsDTO = saveOrUpdate(establishmentsDTO, Establishments.class);
        //Establishment Services
        updatedEstablishmentsDTO.getServices().forEach(dto->dto.setEstId(establishmentsDTO.getId()));
        List<EstServices> dbEstServices = establishmentRepository.getEstablishmentServices(updatedEstablishmentsDTO.getId());
        saveList(updatedEstablishmentsDTO.getServices(), dbEstServices, EstServices.class);

        //Establishment Employees
        updatedEstablishmentsDTO.getEmployees().forEach(dto->dto.setEmployeeId(establishmentsDTO.getId()));
        List<EstEmployees> dbEstEmployees = establishmentRepository.getEstablishmentEmployees(updatedEstablishmentsDTO.getId());
        saveList(updatedEstablishmentsDTO.getEmployees(), dbEstEmployees, EstEmployees.class);

        //Establishment Images
        updatedEstablishmentsDTO.getImages().forEach(dto->dto.setImageId(establishmentsDTO.getId()));
        List<EstImages> dbEstImages = establishmentRepository.getEstablishmentImages(updatedEstablishmentsDTO.getId());
        saveList(updatedEstablishmentsDTO.getImages(), dbEstImages, EstImages.class);

        //Establishment OpeningHours
        updatedEstablishmentsDTO.getOpeningHours().forEach(dto->dto.setEstId(establishmentsDTO.getId()));
        List<EstOpeningHours> dbEstOpeningHours = establishmentRepository.getEstablishmentOpeningHours(updatedEstablishmentsDTO.getId());
        saveList(updatedEstablishmentsDTO.getOpeningHours(), dbEstOpeningHours, EstOpeningHours.class);

        //Establishment ServiceAddOnnMap
        updatedEstablishmentsDTO.getServiceAddOnnMap().forEach(dto->dto.setMapId(establishmentsDTO.getId()));
        List<EstServiceAddOnnMap> dbEstServiceAddOnnMap = establishmentRepository.getEstablishmentServiceAddOnnMap(updatedEstablishmentsDTO.getId());
        saveList(updatedEstablishmentsDTO.getServiceAddOnnMap(), dbEstServiceAddOnnMap, EstServiceAddOnnMap.class);





        return updatedEstablishmentsDTO;
    }

    public EstablishmentsDTO getEstablishemt(long id) throws BusinessException {
        EstablishmentsDTO establishmentsDTO = getOne(Establishments.class, EstablishmentsDTO.class , id);
        List<EstServices> dbEstServices = establishmentRepository.getEstablishmentServices(establishmentsDTO.getId());
        establishmentsDTO.setServices(Arrays.asList(modelMapper.map(dbEstServices, EstServicesDTO[].class)));

        List<EstEmployees> dbEstEmployees = establishmentRepository.getEstablishmentEmployees(establishmentsDTO.getId());
        establishmentsDTO.setEmployees(Arrays.asList(modelMapper.map(dbEstEmployees, EstEmployeesDTO[].class)));

        List<EstImages> dbEstImages = establishmentRepository.getEstablishmentImages(establishmentsDTO.getId());
        establishmentsDTO.setImages(Arrays.asList(modelMapper.map(dbEstImages, EstImagesDTO[].class)));

        List<EstOpeningHours> dbEstOpeningHours = establishmentRepository.getEstablishmentOpeningHours(establishmentsDTO.getId());
        establishmentsDTO.setOpeningHours(Arrays.asList(modelMapper.map(dbEstOpeningHours, EstOpeningHoursDTO[].class)));

        List<EstServiceAddOnnMap> dbEstServiceAddOnnMap = establishmentRepository.getEstablishmentServiceAddOnnMap(establishmentsDTO.getId());
        establishmentsDTO.setServiceAddOnnMap(Arrays.asList(modelMapper.map(dbEstServiceAddOnnMap, EstServiceAddOnnMapDTO[].class)));


        return establishmentsDTO;
    }


}
