package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.FeedbackDTO;
import com.utc.HoangGiaHome.entity.Feedback;
import com.utc.HoangGiaHome.form.FeedbackFilterForm;
import com.utc.HoangGiaHome.service.IFeedbackService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedbacks")
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<FeedbackDTO> getAllFeedbackServices(FeedbackFilterForm form){
        List<Feedback> feedbacks = feedbackService.getAllFeedbackServices(form);
        return  modelMapper.map(feedbacks, new TypeToken<List<FeedbackDTO>>(){}.getType());
    }

    @GetMapping("{feedback_id}")
    public FeedbackDTO getFeedbackById(@PathVariable int feedback_id){
        Feedback feedback = feedbackService.getFeedbackById(feedback_id);
        return modelMapper.map(feedback, FeedbackDTO.class);
    }
}
