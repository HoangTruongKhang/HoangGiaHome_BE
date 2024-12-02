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
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reply_id;

    @Column(name = "content", length = 255, nullable = false)
    private String content;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToOne
    @JoinColumn(name = "feedback_id", nullable = false)
    private Feedback feedback;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}

