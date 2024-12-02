package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Account;
import com.utc.HoangGiaHome.entity.Service;
import com.utc.HoangGiaHome.form.ServiceFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class ServiceSpecification {

    private static final String SERVICE_NAME = "serviceName";

    public static Specification<Service> buildWhere (ServiceFilterForm form){
        if (form == null){
            return null;
        }
        Specification<Service> whereServiceName = new SpecificationImpl(SERVICE_NAME, form.getSearch());
        return whereServiceName;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Service>{
        private String key;
        private Object value;
        @Override
        public Predicate toPredicate(Root<Service> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case SERVICE_NAME:
                    return criteriaBuilder.like(root.get("serviceName"), "%" + value + "%");
            }
            return null;
        }
    }
}
