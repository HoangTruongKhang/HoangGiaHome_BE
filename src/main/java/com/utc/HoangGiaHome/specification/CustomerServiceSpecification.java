package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.CustomerService;
import com.utc.HoangGiaHome.form.CustomerServiceFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class CustomerServiceSpecification {

    private static final String CUSTOMER_NAME = "customerFull_name";
    private static final String SERVICE_NAME = "serviceServiceName";
    public static Specification<CustomerService> buildWhere(CustomerServiceFilterForm form){
        if (form == null){
            return null;
        }
        Specification<CustomerService> whereCustomerFull_name = new SpecificationImpl(CUSTOMER_NAME, form.getSearch());
        Specification<CustomerService> whereServiceServiceName = new SpecificationImpl(SERVICE_NAME, form.getSearch());
        return Specification.where(whereCustomerFull_name).or(whereServiceServiceName);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<CustomerService>{
        private String key;
        private Object value;


        @Override
        public Predicate toPredicate(Root<CustomerService> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return  null;
            }
            switch (key){
                case CUSTOMER_NAME:
                    return criteriaBuilder.like(root.get("customer").get("full_name"), "%" + value + "%");

                case SERVICE_NAME:
                    return criteriaBuilder.like(root.get("service").get("serviceName"), "%" + value + "%");
            }
            return null;
        }
    }
}
