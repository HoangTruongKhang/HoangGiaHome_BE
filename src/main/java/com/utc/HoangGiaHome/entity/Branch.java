package com.utc.HoangGiaHome.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branch_id;

    @Column(name = "branch_name", length = 255, nullable = false)
    private String branch_name;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date create_at;

    @OneToMany(mappedBy = "branch")
    private List<Account> accounts;


    @OneToMany(mappedBy = "branch")
    private List<Room> rooms;


    @OneToMany(mappedBy = "branch")
    private List<CustomerBranch> customerBranches;

//    @OneToMany(mappedBy = "branch")
//    private List<Room> rooms;
//
//    @OneToMany(mappedBy = "branch")
//    private List<Customer> customers;

    @OneToMany(mappedBy = "branch")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "branch")
    private List<Booking> bookings;
}
