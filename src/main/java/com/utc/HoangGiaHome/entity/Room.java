package com.utc.HoangGiaHome.entity;

import com.utc.HoangGiaHome.entity.enums.RoomStatus;
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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int room_id;

    @Column(name = "room_name", length = 100, nullable = false, unique = true)
    private String room_name;

    @Column(name = "image_media_url", length = 255)
    private String image_media_url;

    @Column(name = "price", length = 50, nullable = false)
    private int price;

    @Column(name = "area", nullable = false)
    private int area;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "roomStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @OneToMany(mappedBy = "room")
    private List<Customer> customers;

    @OneToMany(mappedBy = "room")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "room")
    private List<Contract> contract;

    @OneToOne(mappedBy = "room")
    private Booking booking;
}
