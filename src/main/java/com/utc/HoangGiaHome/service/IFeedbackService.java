package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.Feedback;
import com.utc.HoangGiaHome.form.FeedbackFilterForm;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> getAllFeedbackServices(FeedbackFilterForm form);
    Feedback getFeedbackById(int feedback_id);
}
