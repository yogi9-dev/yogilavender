package com.ti.lav.lavender.service;

import com.ti.lav.lavender.common.BusinessException;
import com.ti.lav.lavender.db.dao.GenericDAO;
import com.ti.lav.lavender.db.domain.BaseTransactionDomain;
import com.ti.lav.lavender.model.BaseTransactionDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BaseService {

    @Autowired
    protected GenericDAO genericDAO;

    @Autowired
    protected ModelMapper modelMapper;

    private <S> S getDBObject(Class S, long id) throws BusinessException {
        S dbObj = (S) genericDAO.findOne(S, id);
        if(dbObj==null){
            throw new BusinessException("Record not found");
        }
        return dbObj;
    }

    protected <S,T> T getOne(Class S,Class T, long id) throws BusinessException {
        Object dbObj = getDBObject(S, id);
        return (T) modelMapper.map(dbObj,T);
    }

    @Transactional
    protected <T> T saveOrUpdate(T dto, Class<? extends BaseTransactionDomain> domainClass) throws BusinessException {
        try {
            BaseTransactionDomain dbObj = null;
            BaseTransactionDTO bdto = (BaseTransactionDTO) dto;
            log.info("Saving domain object saved for "+ domainClass +" ID: "+ bdto.getId() );
            if (bdto.getId() > 0) {
                dbObj = getDBObject(domainClass, bdto.getId());
                modelMapper.map(dto,dbObj);
            } else {
                dbObj = (BaseTransactionDomain) modelMapper.map(dto,domainClass);
            }
            genericDAO.save(dbObj);
            bdto.setId(dbObj.getId());
            log.info("Saved object saved for "+ domainClass +" ID: "+ bdto.getId() );
            return (T) bdto;
        }
        catch (BusinessException e){
            throw e;
        }
        catch (Exception e){
            log.error("Error in saving object", e);
            throw new BusinessException("Error in saving object");
        }
    }

    protected void saveList(List<? extends BaseTransactionDTO> dtoList, List<? extends BaseTransactionDomain> domainList, Class domainClass) throws BusinessException{

        Map<Long,BaseTransactionDomain> domainMap = domainList.stream().map(o -> (BaseTransactionDomain) o)
                .collect(Collectors.toMap(BaseTransactionDomain::getId, Function.identity()));

        List<BaseTransactionDomain> domainsToDelete = domainList.stream().map(o -> (BaseTransactionDomain) o)
                .filter(domain -> dtoList.stream().noneMatch(dto -> dto.getId() == domain.getId()))
                .collect(Collectors.toList());

        log.info("Savelist for class: "+ domainClass);

        dtoList.forEach(dto -> {
            if(domainMap.containsKey(dto.getId())){
                log.info("Domain object exists ID: "+ dto.getId());
                modelMapper.map(dto,domainMap.get(dto.getId()));
                genericDAO.save(domainMap.get(dto.getId()));
                log.info("Update successful "+ domainClass+ " for ID:"+ dto.getId());
            }else{
                BaseTransactionDomain dbObj = (BaseTransactionDomain) modelMapper.map(dto,domainClass);
                genericDAO.save(dbObj);
                log.info("Insert successful "+ domainClass+ " for ID:"+ dbObj.getId());
            }
        });

        domainsToDelete.forEach(dbObj -> {
            genericDAO.delete(dbObj);
            log.info("Delete successful "+ domainClass+ " for ID:"+ dbObj.getId());
        });

    }




}
