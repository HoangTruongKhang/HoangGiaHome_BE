package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.Reply;
import com.utc.HoangGiaHome.form.ReplyFilterForm;

import java.util.List;

public interface IReplyService {
    List<Reply> getAllReplys(ReplyFilterForm form);
    Reply getReplyById(int reply_id);
}
