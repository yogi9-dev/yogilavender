package com.ti.lav.lavender.db.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericDAO {

    @Autowired
    protected EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Object entity){
        entityManager.persist(entity);
    }

    /*@Transactional(propagation = Propagation.REQUIRED)
    public void update(Object entity){
        entityManager.merge(entity);
    }*/

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Object entity){
        entityManager.remove(entity);
    }

    public <T> T findOne(Class<T> type, final long id) {
        return (T) entityManager.find(type, id);
    }


}
