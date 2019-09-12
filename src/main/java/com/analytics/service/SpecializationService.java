package com.analytics.service;

import com.analytics.common.Constants;
import com.analytics.dao.SpecializationDAO;
import com.analytics.entity.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecializationService {

    @Autowired
    SpecializationDAO specializationDAO;

    public void addSpecialization(Specialization specialization) {
        specializationDAO.insert(specialization);
    }

    public void updateSpecialization(Specialization specialization) {
        specializationDAO.update(specialization);
    }

    public String getTopSpecializationName() {
        Specialization specialization = specializationDAO.getTopSpecialization();
        return specialization != null ?  specialization.getName() : Constants.Service.DEFAULT_SPECIALIZATION;
    }
}
