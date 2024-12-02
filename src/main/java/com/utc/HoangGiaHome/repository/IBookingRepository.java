package com.utc.HoangGiaHome.repository;


import com.utc.HoangGiaHome.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IBookingRepository extends JpaRepository<Booking, Integer>, JpaSpecificationExecutor<Booking> {
    Booking findById(int booking_id);
}
