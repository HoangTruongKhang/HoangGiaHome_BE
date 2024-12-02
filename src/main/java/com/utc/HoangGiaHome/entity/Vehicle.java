package com.utc.HoangGiaHome.entity;

import com.utc.HoangGiaHome.entity.enums.RelationWithOwner;
import com.utc.HoangGiaHome.entity.enums.VehicleName;
import com.utc.HoangGiaHome.entity.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicle_id;

    @Column(name = "vehicleName", nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleName vehicleName;

    @Column(name = "owner_name", length = 100, nullable = false)
    private String owner_name;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicleType", nullable = false)
    private VehicleType vehicleType;

    @Column(name = "license_plate", length = 20, unique = true)
    private String license_plate;

    @Enumerated(EnumType.STRING)
    @Column(name = "relationWithOwner", nullable = false)
    private RelationWithOwner relationWithOwner;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
