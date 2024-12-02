package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Feedback;
import com.utc.HoangGiaHome.entity.Vehicle;
import com.utc.HoangGiaHome.form.FeedbackFilterForm;
import com.utc.HoangGiaHome.form.VehicleFilterForm;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class FeedbackSpecification {
    private static final String PHONE_NUMBER  = "phone_number";
    private static final String EMAIL = "email";
    private static final String FEEDBACK_STATUS = "feedbackStatus";
    private static final String CUSTOMER_NAME = "customerFull_name";

    public static Specification<Feedback> buildWhere(FeedbackFilterForm form){
        if (form == null){
            return null;
        }
        Specification<Feedback> wherePhone_number = new FeedbackSpecification.SpecificationImpl(PHONE_NUMBER, form.getSearch());
        Specification<Feedback> whereEmail = new FeedbackSpecification.SpecificationImpl(EMAIL, form.getSearch());
        Specification<Feedback> whereFeedbackStatus = new FeedbackSpecification.SpecificationImpl(FEEDBACK_STATUS, form.getSearch());
        Specification<Feedback> whereCustomerFull_name = new FeedbackSpecification.SpecificationImpl(CUSTOMER_NAME, form.getSearch());
        return Specification.where(wherePhone_number.or(whereEmail.or(whereFeedbackStatus.or(whereCustomerFull_name))));
    }
    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Feedback>{
        private String key;
        private Object value;


        @Override
        public Predicate toPredicate(Root<Feedback> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case PHONE_NUMBER:
                    return criteriaBuilder.like(root.get("phone_number"), "%" + value + "%");
                case EMAIL:
                    return criteriaBuilder.like(root.get("email"), "%" + value + "%");
                case FEEDBACK_STATUS:
                    return criteriaBuilder.like(root.get("feedbackStatus"), "%" + value + "%");
                case CUSTOMER_NAME:
                    Join join = root.join("customer", JoinType.LEFT);
                    return criteriaBuilder.like(join.get("full_name"), "%" + value + "%");
            }
            return null;
        }
    }
}