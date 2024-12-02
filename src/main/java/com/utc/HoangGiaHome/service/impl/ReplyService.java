package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Reply;
import com.utc.HoangGiaHome.entity.Vehicle;
import com.utc.HoangGiaHome.form.ReplyFilterForm;
import com.utc.HoangGiaHome.repository.IReplyRepository;
import com.utc.HoangGiaHome.service.IReplyService;
import com.utc.HoangGiaHome.specification.ReplySpecification;
import com.utc.HoangGiaHome.specification.VehicleSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReplyService implements IReplyService {
    @Autowired
    private IReplyRepository replyRepository;
    @Override
    public List<Reply> getAllReplys(ReplyFilterForm form) {
        Specification<Reply> where = ReplySpecification.buildWhere(form);
        return replyRepository.findAll(where);
    }

    @Override
    public Reply getReplyById(int reply_id) {
        return replyRepository.findById(reply_id);
    }
}
