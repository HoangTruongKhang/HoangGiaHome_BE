package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Feedback;
import com.utc.HoangGiaHome.entity.Reply;
import com.utc.HoangGiaHome.form.FeedbackFilterForm;
import com.utc.HoangGiaHome.form.ReplyFilterForm;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class ReplySpecification {
    private static final String ACCOUNT_NAME = "accountUsername";

    public static Specification<Reply> buildWhere(ReplyFilterForm form){
        if (form == null){
            return null;
        }
        Specification<Reply> whereAccountUsername = new ReplySpecification.SpecificationImpl(ACCOUNT_NAME, form.getSearch());
        return whereAccountUsername;
    }
    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Reply> {
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Reply> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null) {
                return null;
            }
            switch (key) {
                case ACCOUNT_NAME:
                    Join join = root.join("account", JoinType.LEFT);
                    return criteriaBuilder.like(join.get("username"), "%" + value + "%");
            }

            return null;
        }
    }
}



