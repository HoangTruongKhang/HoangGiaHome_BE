package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.Invoice;
import com.utc.HoangGiaHome.entity.Vehicle;
import com.utc.HoangGiaHome.form.VehicleFilterForm;

import java.util.List;

public interface IVehicleService {
    List<Vehicle> getAllVehicles(VehicleFilterForm form);
    Vehicle getVehicleById(int vehicle_id);
}
