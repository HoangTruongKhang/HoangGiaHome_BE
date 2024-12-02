package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.BookingDTO;
import com.utc.HoangGiaHome.entity.Booking;
import com.utc.HoangGiaHome.form.BookingFilterForm;
import com.utc.HoangGiaHome.service.IBookingService;
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
@RequestMapping("/api/v1/bookings")
public class BookingController {
    @Autowired
    private IBookingService bookingService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<BookingDTO> getAllBookings(Pageable pageable, BookingFilterForm form){
        Page<Booking> bookingPage = bookingService.getAllBookings(pageable, form);
        List<Booking> bookings = bookingPage.getContent();
        List<BookingDTO> bookingDTOS = bookings.stream().map(booking -> modelMapper.map(booking, BookingDTO.class)).collect(Collectors.toList());
        return new PageImpl<>(bookingDTOS, pageable, bookingPage.getTotalElements());
    }

    @GetMapping("{booking_id}")
    public BookingDTO getBookingById(@PathVariable int booking_id){
        Booking booking = bookingService.getBookingById(booking_id);
        return modelMapper.map(booking, BookingDTO.class);
    }
}
