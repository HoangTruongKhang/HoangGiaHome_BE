package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Customer;
import com.utc.HoangGiaHome.entity.enums.RelationWithOwner;
import com.utc.HoangGiaHome.entity.enums.VehicleName;
import com.utc.HoangGiaHome.entity.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private int vehicle_id;
    private VehicleName vehicleName;
    private String owner_name;
    private VehicleType vehicleType;
    private String license_plate;
    private RelationWithOwner relationWithOwner;
    private Date createDate;
    private String customerFull_name;
}
