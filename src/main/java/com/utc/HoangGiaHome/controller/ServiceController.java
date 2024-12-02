package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.ServiceDTO;
import com.utc.HoangGiaHome.entity.Service;
import com.utc.HoangGiaHome.form.ServiceFilterForm;
import com.utc.HoangGiaHome.service.IServiceService;
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
@RequestMapping("/api/v1/services")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<ServiceDTO> getAllServices(Pageable pageable, ServiceFilterForm form){
        Page<Service> servicePage = serviceService.getAllServices(pageable, form);
        List<Service> services = servicePage.getContent();
        List<ServiceDTO> serviceDTOS = services.stream().map(
                service -> modelMapper.map(service, ServiceDTO.class)
        ).collect(Collectors.toList());
        return new PageImpl<>(serviceDTOS, pageable, servicePage.getTotalElements());
    }

    @GetMapping("{service_id}")
    public ServiceDTO getServiceById(@PathVariable int service_id){
        Service service = serviceService.getServiceById(service_id);
        return modelMapper.map(service, ServiceDTO.class);
    }
}
