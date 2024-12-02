package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Branch;
import com.utc.HoangGiaHome.form.BranchFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class BranchSpecification {
    private static final String BRANCH_NAME = "branch_name";
    private static final String ADDRESS = "address";
    public static Specification<Branch> buildWhere(BranchFilterForm form){
        if (form == null){
            return null;
        }
        Specification<Branch> whereBranch_name = new SpecificationImpl(BRANCH_NAME, form.getSearch());
        Specification<Branch> whereAddress = new SpecificationImpl(ADDRESS, form.getSearch());
        return Specification.where(whereBranch_name).or(whereAddress);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Branch>{

        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Branch> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case BRANCH_NAME:
                    return criteriaBuilder.like(root.get("branch_name"), "%" + value + "%");
                case ADDRESS:
                    return criteriaBuilder.like(root.get("address"), "%" + value + "%");
            }
            return null;
        }
    }
}
