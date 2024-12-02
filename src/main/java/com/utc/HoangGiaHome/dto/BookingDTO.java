package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Branch;
import com.utc.HoangGiaHome.entity.Room;
import com.utc.HoangGiaHome.entity.enums.BookingStatus;
import com.utc.HoangGiaHome.entity.enums.PaymentMethod;
import com.utc.HoangGiaHome.entity.enums.RentalDuration;
import com.utc.HoangGiaHome.entity.enums.Salutation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private int booking_id;
    private Salutation salutation;
    private String full_name;
    private String phone_number;
    private RentalDuration rentalDuration;
    private String start_date;
    private String end_date;
    private PaymentMethod paymentMethod;
    private BookingStatus bookingStatus = BookingStatus.DANG_XU_LY;
    private String roomRoom_name;
    private String  branchBranch_name;



}
