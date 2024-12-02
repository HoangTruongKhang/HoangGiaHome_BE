package com.utc.HoangGiaHome.repository;

import com.utc.HoangGiaHome.entity.IncomeStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIncomeStatisticsRepository extends JpaRepository<IncomeStatistics, Integer> {
    IncomeStatistics findById(int incomeStatistics_id);
}
