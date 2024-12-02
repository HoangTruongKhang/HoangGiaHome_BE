package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.IncomeStatistics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IIncomeStatisticsService {
    Page<IncomeStatistics> getAllIncomeStatistics(Pageable pageable);
    IncomeStatistics getIncomeStatisticsById(int incomeStatistics_id);
}
