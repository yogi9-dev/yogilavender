package com.ti.lav.lavender.controller;

import com.ti.lav.lavender.model.EstSearchCriteriaDTO;
import com.ti.lav.lavender.model.EstablishmentsDTO;
import com.ti.lav.lavender.service.EstSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estsearch")
public class EstSearchController {

    @Autowired
    private EstSearchService estSearchService;

    @PostMapping("/search")
    public List<EstablishmentsDTO> searchServices(@RequestBody EstSearchCriteriaDTO searchCriteria) {
        return estSearchService.searchEstServices(searchCriteria);
    }

}
