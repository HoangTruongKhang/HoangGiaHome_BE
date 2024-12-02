package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.ReplyDTO;
import com.utc.HoangGiaHome.entity.Reply;
import com.utc.HoangGiaHome.form.ReplyFilterForm;
import com.utc.HoangGiaHome.service.IReplyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/replys")
public class ReplyController {
    @Autowired
    private IReplyService replyService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ReplyDTO> getAllReplys(ReplyFilterForm form){
        List<Reply> replies = replyService.getAllReplys(form);
        return modelMapper.map(replies, new TypeToken<List<ReplyDTO>>(){}.getType());
    }

    @GetMapping("{reply_id}")
    public ReplyDTO getReplyById(@PathVariable int reply_id){
        Reply reply = replyService.getReplyById(reply_id);
        return modelMapper.map(reply, ReplyDTO.class);
    }
}
