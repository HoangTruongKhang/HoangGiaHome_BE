package com.utc.HoangGiaHome.repository;


import com.utc.HoangGiaHome.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer>, JpaSpecificationExecutor<Vehicle> {
    Vehicle findById(int vehicle_id);
}
