package com.analytics.dao;

import com.analytics.entity.Specialization;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class SpecializationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Specialization specialization) {
        entityManager.persist(specialization);
    }

    public void update(Specialization specialization) {
        entityManager.merge(specialization);
    }

    public Specialization getTopSpecialization() {
        return null;
    }
}
