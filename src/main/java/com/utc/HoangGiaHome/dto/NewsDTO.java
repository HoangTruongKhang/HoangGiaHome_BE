package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {
    private int new_id;
    private String title;
    private String description;
    private String image;
    private Date createDate;
    private String accountUsername;
}
