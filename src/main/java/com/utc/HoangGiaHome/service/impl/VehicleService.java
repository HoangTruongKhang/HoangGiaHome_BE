package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.News;
import com.utc.HoangGiaHome.entity.Vehicle;
import com.utc.HoangGiaHome.form.VehicleFilterForm;
import com.utc.HoangGiaHome.repository.IVehicleRepository;
import com.utc.HoangGiaHome.service.IVehicleService;
import com.utc.HoangGiaHome.specification.NewsSpecification;
import com.utc.HoangGiaHome.specification.VehicleSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleService implements IVehicleService {
    @Autowired
    private IVehicleRepository vehicleRepository;
    @Override
    public List<Vehicle> getAllVehicles(VehicleFilterForm form) {
        Specification<Vehicle> where = VehicleSpecification.buildWhere(form);
        return vehicleRepository.findAll(where);
    }

    @Override
    public Vehicle getVehicleById(int vehicle_id) {
        return vehicleRepository.findById(vehicle_id);
    }
}
