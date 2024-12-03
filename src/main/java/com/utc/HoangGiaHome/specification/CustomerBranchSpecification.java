package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.CustomerBranch;
import com.utc.HoangGiaHome.form.CustomerBranchFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class CustomerBranchSpecification {

    private static final String CUSTOMER_NAME = "customerFull_name";
    private static final String BRANCH_NAME = "branchBranch_name";
    public static Specification<CustomerBranch> buildWhere(CustomerBranchFilterForm form){
        if (form == null){
            return null;
        }
        Specification<CustomerBranch> whereCustomerFull_name = new CustomerBranchSpecification.SpecificationImpl(CUSTOMER_NAME, form.getSearch());
        Specification<CustomerBranch> whereBranchBranch_name = new CustomerBranchSpecification.SpecificationImpl(BRANCH_NAME, form.getSearch());
        return Specification.where(whereCustomerFull_name).or(whereBranchBranch_name);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<CustomerBranch>{
        private String key;
        private Object value;


        @Override
        public Predicate toPredicate(Root<CustomerBranch> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return  null;
            }
            switch (key){
                case CUSTOMER_NAME:
                    return criteriaBuilder.like(root.get("customer").get("full_name"), "%" + value + "%");

                case BRANCH_NAME:
                    return criteriaBuilder.like(root.get("branch").get("branch_name"), "%" + value + "%");
            }
            return null;
        }
    }
}
