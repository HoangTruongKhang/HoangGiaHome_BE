package com.utc.HoangGiaHome.repository;


import com.utc.HoangGiaHome.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IFeedbackRepository extends JpaRepository<Feedback, Integer>, JpaSpecificationExecutor<Feedback> {
    Feedback findById(int feedback_id);
}
