package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Contract;
import com.utc.HoangGiaHome.entity.News;
import com.utc.HoangGiaHome.form.ContractFilterForm;
import com.utc.HoangGiaHome.form.NewsFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class NewsSpecification {
    private static final String TITLE  = "title";
    private static final String ACCOUNT_NAME = "accountUsername";

    public static Specification<News> buildWhere(NewsFilterForm form){
        if (form == null){
            return null;
        }
        Specification<News> whereTitle = new NewsSpecification.SpecificationImpl(TITLE, form.getSearch());
        Specification<News> whereAccountUsername = new NewsSpecification.SpecificationImpl(ACCOUNT_NAME, form.getSearch());
        return Specification.where(whereTitle.or(whereAccountUsername));
    }
    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<News>{
        private String key;
        private Object value;


        @Override
        public Predicate toPredicate(Root<News> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case TITLE:
                    return criteriaBuilder.like(root.get("title"), "%" + value + "%");
                case ACCOUNT_NAME:
                    return criteriaBuilder.like(root.get("account").get("username"), "%" + value + "%");
            }
            return null;
        }
    }
}
