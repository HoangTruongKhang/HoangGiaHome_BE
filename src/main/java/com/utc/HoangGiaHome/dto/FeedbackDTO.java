package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Customer;
import com.utc.HoangGiaHome.entity.enums.FeedbackStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {
    private int feedback_id;
    private String phone_number;
    private String email;
    private String content;
    private Date createDate;
    private FeedbackStatus feedbackStatus = FeedbackStatus.CHUA_PHAN_HOI;
    private String customerFull_name;
}
