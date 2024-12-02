package com.utc.HoangGiaHome.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class IncomeStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int incomeStatistics_id;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "total_room_income", nullable = false)
    private int total_room_income;

    @Column(name = "total_service_income", nullable = false)
    private int total_service_income;

    @Formula("total_income")
    private Integer total_income;
}
