package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.Booking;
import com.utc.HoangGiaHome.form.BookingFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookingService {
    Page<Booking> getAllBookings(Pageable pageable, BookingFilterForm form);
    Booking getBookingById(int booking_id);
}
