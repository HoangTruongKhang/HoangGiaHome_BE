package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.IncomeStatistics;
import com.utc.HoangGiaHome.repository.IIncomeStatisticsRepository;
import com.utc.HoangGiaHome.service.IIncomeStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncomeStatisticsService implements IIncomeStatisticsService {
    @Autowired
    private IIncomeStatisticsRepository iIncomeStatisticsRepository;
    @Override
    public Page<IncomeStatistics> getAllIncomeStatistics(Pageable pageable) {
        return iIncomeStatisticsRepository.findAll(pageable);
    }

    @Override
    public IncomeStatistics getIncomeStatisticsById(int incomeStatistics_id) {
        return iIncomeStatisticsRepository.findById(incomeStatistics_id);
    }
}
