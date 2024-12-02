package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Feedback;
import com.utc.HoangGiaHome.entity.Vehicle;
import com.utc.HoangGiaHome.form.FeedbackFilterForm;
import com.utc.HoangGiaHome.repository.IFeedbackRepository;
import com.utc.HoangGiaHome.service.IFeedbackService;
import com.utc.HoangGiaHome.specification.FeedbackSpecification;
import com.utc.HoangGiaHome.specification.VehicleSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository feedbackRepository;
    @Override
    public List<Feedback> getAllFeedbackServices(FeedbackFilterForm form) {
        Specification<Feedback> where = FeedbackSpecification.buildWhere(form);
        return feedbackRepository.findAll(where);
    }

    @Override
    public Feedback getFeedbackById(int feedback_id) {
        return feedbackRepository.findById(feedback_id);
    }
}
