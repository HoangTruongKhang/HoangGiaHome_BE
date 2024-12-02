package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.Service;
import com.utc.HoangGiaHome.form.ServiceFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    Page<Service> getAllServices(Pageable pageable, ServiceFilterForm form);
    Service getServiceById(int service_id);
}
