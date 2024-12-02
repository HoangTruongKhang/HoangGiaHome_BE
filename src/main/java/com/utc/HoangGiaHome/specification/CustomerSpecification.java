package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Customer;
import com.utc.HoangGiaHome.form.CustomerFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecification {

    private static final String FULL_NAME = "full_name";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String BRANCH_NAME = "branchBranch_name";
    private static final String ROOM_NAME = "roomRoom_name";
    public static Specification<Customer> buildWhere(CustomerFilterForm form){
        if (form == null){
            return null;
        }
        Specification<Customer> whereFull_name = new CustomerSpecification.SpecificationImpl(FULL_NAME, form.getSearch());
        Specification<Customer> wherePhone_number = new CustomerSpecification.SpecificationImpl(PHONE_NUMBER, form.getSearch());
        Specification<Customer> whereBranchBranch_name = new CustomerSpecification.SpecificationImpl(BRANCH_NAME, form.getSearch());
        Specification<Customer> whereroomRoom_name = new CustomerSpecification.SpecificationImpl(ROOM_NAME, form.getSearch());
        return Specification.where(whereFull_name.or(wherePhone_number).or(whereBranchBranch_name).or(whereroomRoom_name));
    }
    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Customer>{
        private String key;
        private Object value;
        @Override
        public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case FULL_NAME:
                    return criteriaBuilder.like(root.get("full_name"), "%" + value + "%");
                case PHONE_NUMBER:
                    return criteriaBuilder.like(root.get("phone_number"), "%" + value + "%");
                case BRANCH_NAME:
                    return criteriaBuilder.like(root.get("branch").get("branch_name"), "%" + value + "%");
                case ROOM_NAME:
                    return criteriaBuilder.like(root.get("room").get("room_name"), "%" + value + "%");
            }
            return null;
        }
    }
}
