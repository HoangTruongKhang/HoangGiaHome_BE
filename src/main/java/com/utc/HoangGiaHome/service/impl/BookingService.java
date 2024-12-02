package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Account;
import com.utc.HoangGiaHome.entity.Booking;
import com.utc.HoangGiaHome.form.BookingFilterForm;
import com.utc.HoangGiaHome.repository.IBookingRepository;
import com.utc.HoangGiaHome.service.IBookingService;
import com.utc.HoangGiaHome.specification.AccountSpecification;
import com.utc.HoangGiaHome.specification.BookingSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class BookingService implements IBookingService {
    @Autowired
    private IBookingRepository bookingRepository;
    @Override
    public Page<Booking> getAllBookings(Pageable pageable, BookingFilterForm form) {
        Specification<Booking> where = BookingSpecification.buildWhere(form);
        return bookingRepository.findAll(where, pageable);
    }

    @Override
    public Booking getBookingById(int booking_id) {
        return bookingRepository.findById(booking_id);
    }
}
