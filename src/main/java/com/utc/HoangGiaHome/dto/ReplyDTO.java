package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Account;
import com.utc.HoangGiaHome.entity.Feedback;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    private int reply_id;
    private String content;
    private Date createDate;
    private Integer feedbackFeedback_id;
    private String accountUsername;
}
