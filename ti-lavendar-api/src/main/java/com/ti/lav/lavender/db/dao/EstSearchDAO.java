package com.ti.lav.lavender.db.dao;

import com.ti.lav.lavender.model.EstSearchCriteriaDTO;
import com.ti.lav.lavender.model.EstablishmentsDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class EstSearchDAO {

    Logger log = Logger.getLogger(EstSearchDAO.class.getName());

    @Autowired
    private EntityManager entityManager;

    public List<EstablishmentsDTO> searchEstablishments(EstSearchCriteriaDTO searchCriteria) {
        String query = "SELECT e.EST_ID, EST_NAME, EST_ABOUT, " +
                "EST_ADDR_LINE1, EST_ADDR_LINE2, EST_ADDR_AREA, EST_ADDR_STATE, EST_ADDR_COUNTRY, " +
                "EST_ADDR_PINCODE, EST_GEO_LOCATION, ES_ID, s.EST_ID, ES_NAME, ES_CATEGORY_TYPE, " +
                "ES_PARENT_ID, ES_SALE_PRICE, ES_MAX_PRICE, " +
                "ES_DISCOUNT_PRICE, ES_DISCOUNT_PERCENTAGE, ES_DURATION " +
                "FROM Establishments e " +
                "INNER JOIN EST_SERVICES s ON e.Est_ID = s.Est_ID ";// +
               /* "WHERE (:serviceName IS NULL OR lower(s.ES_NAME) like lower('%:serviceName%')) " +
                "AND (:minSalePrice IS NULL OR s.ES_SALE_PRICE >= :minSalePrice) " +
                "AND (:maxSalePrice IS NULL OR s.ES_SALE_PRICE <= :maxSalePrice) " +
                "AND (:minDuration IS NULL OR s.ES_DURATION >= :minDuration) " +
                "AND (:maxDuration IS NULL OR s.ES_DURATION <= :maxDuration)";*/

        List<Object[]> resultList = entityManager.createNativeQuery(query)
                /*.setParameter("serviceName", searchCriteria.getServiceName())
                .setParameter("minSalePrice", searchCriteria.getMinSalePrice())
                .setParameter("maxSalePrice", searchCriteria.getMaxSalePrice())
                .setParameter("minDuration", searchCriteria.getMinDuration())
                .setParameter("maxDuration", searchCriteria.getMaxDuration())*/
                .getResultList();

        return transformResultToDTO(resultList);
    }

    private List<EstablishmentsDTO> transformResultToDTO(List<Object[]> resultList) {
        /*Map<Long, EstablishmentsDTO> establishmentsMap = new HashMap<>();

        for (Object[] row : resultList) {
            log.info("--------------------"+ row);
            Stream.of(row).peek(s->log.info(s==null?"Null":s.toString()));
            EstablishmentsDTO establishmentDTO;
            Long establishmentId = ((Number) row[0]).longValue();
            if (!establishmentsMap.containsKey(establishmentId)) {
                //BeanUtils.copyProperties(row[0], establishmentDTO);
                establishmentDTO = new EstablishmentsDTO((Long) row[0], (String) row[1], (String) row[2], (String) row[3],
                        (String) row[4], (String) row[5], (String) row[6], (String) row[7], (String) row[8], (String) row[9], new ArrayList<EstServicesDTO>());

                establishmentsMap.put(establishmentId, establishmentDTO);
            } else {
                establishmentDTO = establishmentsMap.get(establishmentId);
            }



            EstServicesDTO serviceDTO = new EstServicesDTO((row[10]==null?0: (Long) row[10]), (row[11]==null?0: (Long) row[11]),
                    (String) row[12],(String) row[13],
                    (row[14]==null?0: (Long) row[14]), (BigDecimal) row[15], (BigDecimal) row[16], (BigDecimal) row[17],
                    (BigDecimal) row[18] , (row[19]==null?0: (Integer) row[19]));

            establishmentDTO.getServices().add(serviceDTO);
        }

        return new ArrayList<>(establishmentsMap.values());*/
        return null;
    }



   /* public List<SalonServiceSearchResponseDTO> searchSalonServices(SalonServiceSearchCriteriaDTO criteria) {
        String sql = "SELECT distinct s.* FROM lav_salon_service ss " +
                "LEFT JOIN lav_salon_service_cat ssc ON ss.category_id = ssc.category_id " +
                "LEFT JOIN lav_salon s ON ss.salon_id = s.salon_id " +
                "WHERE ss.service_name LIKE CONCAT('%', :serviceName, '%') " +
                "AND ss.service_desc LIKE CONCAT('%', :serviceDesc, '%') " +
                "AND s.salon_name LIKE CONCAT('%', :salonName, '%') " +
                "AND (:minCost IS NULL OR ss.cost >= :minCost) " +
                "AND (:maxCost IS NULL OR ss.cost <= :maxCost) " +
                "AND (:minDuration IS NULL OR ss.duration >= :minDuration) " +
                "AND (:maxDuration IS NULL OR ss.duration <= :maxDuration)";

        Query query = entityManager.createNativeQuery(sql, SalonServiceSearchResponseDTO.class);
        query.setParameter("serviceName", criteria.getServiceName());
        query.setParameter("serviceDesc", criteria.getServiceDesc());
        query.setParameter("minCost", criteria.getMinCost());
        query.setParameter("maxCost", criteria.getMaxCost());
        query.setParameter("minDuration", criteria.getMinDuration());
        query.setParameter("maxDuration", criteria.getMaxDuration());
        query.setParameter("salonName", criteria.getSalonName());

        return query.getResultList();
    }*/
}
