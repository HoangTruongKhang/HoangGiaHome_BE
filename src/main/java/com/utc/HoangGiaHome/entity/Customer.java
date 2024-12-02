package com.utc.HoangGiaHome.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    @Column(name = "full_name", length = 50, nullable = false)
    private String full_name;

    @Column(name = "cmnd", length = 12, nullable = false, unique = true)
    private String cmnd;

    @Column(name = "phone_number", length = 10, nullable = false, unique = true)
    private String phone_number;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "birth_date")
    private Date birth_date;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "joinDate")
    private Date joinDate;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "customer")
    private List<CustomerService> customerServices;

    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    @OneToMany(mappedBy = "customer")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "customer")
    private List<Feedback> feedbacks;
}
