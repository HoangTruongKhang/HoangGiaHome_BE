package com.utc.HoangGiaHome.dto;

import jakarta.persistence.PostLoad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeStatisticsDTO {
    private int incomeStatistics_id;
    private int month;
    private int year;
    private int total_room_income;
    private int total_service_income;
    private Integer total_income;
}
