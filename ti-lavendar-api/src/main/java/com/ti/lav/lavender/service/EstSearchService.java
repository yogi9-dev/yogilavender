package com.ti.lav.lavender.service;

import com.ti.lav.lavender.db.dao.EstSearchDAO;
import com.ti.lav.lavender.model.EstSearchCriteriaDTO;
import com.ti.lav.lavender.model.EstablishmentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstSearchService extends BaseService{

    @Autowired
    private EstSearchDAO estSearchDAO;

    public List<EstablishmentsDTO> searchEstServices(EstSearchCriteriaDTO searchCriteria) {
        return estSearchDAO.searchEstablishments(searchCriteria);
    }

}
