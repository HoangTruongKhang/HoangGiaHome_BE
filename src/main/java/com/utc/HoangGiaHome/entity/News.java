package com.utc.HoangGiaHome.entity;

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
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int new_id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @Column(name = "image", length = 50, nullable = false)
    private String image;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
