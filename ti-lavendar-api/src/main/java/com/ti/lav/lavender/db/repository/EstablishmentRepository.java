package com.ti.lav.lavender.db.repository;

import com.ti.lav.lavender.db.domain.*;
import com.ti.lav.lavender.model.EstOpeningHoursDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstablishmentRepository extends JpaRepository <Establishments, Long>{

    @Query("SELECT es FROM EstServices es where estId=:establishmentId ")
    List<EstServices> getEstablishmentServices(Long establishmentId);

    @Query("SELECT es FROM EstEmployees es where employeeId=:establishmentId ")
    List<EstEmployees> getEstablishmentEmployees(Long establishmentId);

    @Query("SELECT es FROM EstImages es where imageId=:establishmentId ")
    List<EstImages> getEstablishmentImages(Long establishmentId);

    @Query("SELECT es FROM EstOpeningHours es where Id=:establishmentId ")
    List<EstOpeningHours> getEstablishmentOpeningHours(Long establishmentId);

    @Query("SELECT es FROM EstServiceAddOnnMap es where mapId=:establishmentId ")
    List<EstServiceAddOnnMap> getEstablishmentServiceAddOnnMap(Long establishmentId);


}
