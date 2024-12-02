package com.utc.HoangGiaHome.entity;

import com.utc.HoangGiaHome.entity.enums.AccountRole;
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
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "`password`", length = 800, nullable = false)
    private String password;

    @Column(name = "first_name", length = 50, nullable = false)
    private String first_name;

    @Column(name = "last_name", length = 50, nullable = false)
    private String last_name;

    @Column(name = "phone_number", length = 10, nullable = false)
    private String phone_number;

    @Column(name = "accountRole", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountRole role;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date create_at;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @OneToMany(mappedBy = "account")
    private List<News> news;

    @OneToMany(mappedBy = "account")
    private List<Reply> replys;
}
