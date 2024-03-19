package com.ti.lav.lavender.controller.manage;

import com.ti.lav.lavender.common.BusinessException;
import com.ti.lav.lavender.model.EstablishmentsDTO;
import com.ti.lav.lavender.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/manage/est/")
public class EstManageController {

    @Autowired
    private EstablishmentService establishmentService;

    @PostMapping("/getEst/{id}")
    public EstablishmentsDTO getEstablishemt(@PathVariable Long id) throws BusinessException {
        return establishmentService.getEstablishemt(id);
    }

    @PostMapping("/saveEst")
    public EstablishmentsDTO saveEstablishemt(@RequestBody EstablishmentsDTO establishmentsDTO) throws BusinessException {
        return establishmentService.saveEstablishemt(establishmentsDTO);
    }


}
