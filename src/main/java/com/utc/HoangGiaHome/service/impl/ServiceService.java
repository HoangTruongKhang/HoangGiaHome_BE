package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Account;
import com.utc.HoangGiaHome.entity.Service;
import com.utc.HoangGiaHome.form.ServiceFilterForm;
import com.utc.HoangGiaHome.repository.IServiceRepository;
import com.utc.HoangGiaHome.service.IServiceService;
import com.utc.HoangGiaHome.specification.AccountSpecification;
import com.utc.HoangGiaHome.specification.ServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Page<Service> getAllServices(Pageable pageable, ServiceFilterForm form) {
        Specification<Service> where = ServiceSpecification.buildWhere(form);
        return serviceRepository.findAll(where, pageable);
    }

    @Override
    public Service getServiceById(int service_id) {
        return serviceRepository.findById(service_id);
    }
}
