package com.utc.HoangGiaHome.entity;

import com.utc.HoangGiaHome.entity.enums.FeedbackStatus;
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
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedback_id;

    @Column(name = "phone_number", length = 10, nullable = false)
    private String phone_number;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "content", length = 255)
    private String content;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "feedbackStatus", nullable = false)
    private FeedbackStatus feedbackStatus = FeedbackStatus.CHUA_PHAN_HOI;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToOne(mappedBy = "feedback")
    private Reply reply;
}

