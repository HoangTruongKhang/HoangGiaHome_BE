package com.utc.HoangGiaHome.repository;

import com.utc.HoangGiaHome.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IServiceRepository extends JpaRepository<Service, Integer>, JpaSpecificationExecutor<Service> {
    Service findById(int service_id);
}
