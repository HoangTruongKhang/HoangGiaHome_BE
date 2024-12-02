package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.IncomeStatisticsDTO;
import com.utc.HoangGiaHome.entity.IncomeStatistics;
import com.utc.HoangGiaHome.service.impl.IncomeStatisticsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/incomestatistics")
public class IncomeStatisticsController {
    @Autowired
    private IncomeStatisticsService incomeStatisticsService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<IncomeStatisticsDTO> getAllIncomeStatistics(Pageable pageable){
        Page<IncomeStatistics> incomeStatisticsPage = incomeStatisticsService.getAllIncomeStatistics(pageable);
        List<IncomeStatistics> incomeStatistics = incomeStatisticsPage.getContent();
        List<IncomeStatisticsDTO> incomeStatisticsDTOS = incomeStatistics.stream().map(incomeStatistics1 -> modelMapper.map(incomeStatistics1, IncomeStatisticsDTO.class)).collect(Collectors.toList());
        return new PageImpl<>(incomeStatisticsDTOS, pageable, incomeStatisticsPage.getTotalElements());
    }

    @GetMapping("{incomeStatistics_id}")
    public IncomeStatisticsDTO getIncomeStatisticsById(@PathVariable int incomeStatistics_id){
        IncomeStatistics incomeStatistics = incomeStatisticsService.getIncomeStatisticsById(incomeStatistics_id);
        return modelMapper.map(incomeStatistics, IncomeStatisticsDTO.class);
    }
}
