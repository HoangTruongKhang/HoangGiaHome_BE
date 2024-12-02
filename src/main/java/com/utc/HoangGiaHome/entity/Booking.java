package com.utc.HoangGiaHome.entity;

import com.utc.HoangGiaHome.entity.enums.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "salutation")
    private Salutation salutation;

    @Column(name = "full_name",nullable = false)
    private String full_name;

    @Column(name = "phone_number",nullable = false)
    private String phone_number;

    @Enumerated(EnumType.STRING)
    @Column(name = "rentalDuration", nullable = false)
    private RentalDuration rentalDuration;

    @Column(name = "start_date",nullable = false)
    private String start_date;

    @Column(name = "end_date")
    private String end_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentMethod", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "bookingStatus")
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus = BookingStatus.DANG_XU_LY;

    @Column(name = "notes")
    private String notes;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @OneToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;
}
