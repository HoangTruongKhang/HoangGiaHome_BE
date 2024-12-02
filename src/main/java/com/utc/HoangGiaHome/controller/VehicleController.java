package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.VehicleDTO;
import com.utc.HoangGiaHome.entity.Vehicle;
import com.utc.HoangGiaHome.form.VehicleFilterForm;
import com.utc.HoangGiaHome.service.IVehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    @Autowired
    private IVehicleService vehicleService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<VehicleDTO> getAllVehicles(VehicleFilterForm form){
        List<Vehicle> vehicles = vehicleService.getAllVehicles(form);
        return modelMapper.map(vehicles, new TypeToken<List<VehicleDTO>>(){}.getType());
    }

    @GetMapping("{vehicle_id}")
    public VehicleDTO getVehicleById(@PathVariable int vehicle_id){
        Vehicle vehicle = vehicleService.getVehicleById(vehicle_id);
        return modelMapper.map(vehicle,VehicleDTO.class);
    }
}
