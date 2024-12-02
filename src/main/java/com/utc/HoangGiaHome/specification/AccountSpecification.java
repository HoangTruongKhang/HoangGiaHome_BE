package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Account;
import com.utc.HoangGiaHome.form.AccountFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class AccountSpecification {

    private static final String USERNAME = "username";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String BRANCH_NAME = "branchBranch_name";


    public static Specification<Account> buildWhere(AccountFilterForm form){
        if (form == null){
            return null;
        }
        Specification<Account> whereUsername = new SpecificationImpl(USERNAME, form.getSearch());
        Specification<Account> whereFirst_name = new SpecificationImpl(FIRST_NAME, form.getSearch());
        Specification<Account> whereLast_name = new SpecificationImpl(LAST_NAME, form.getSearch());
        Specification<Account> whereBranchBranch_name = new SpecificationImpl(BRANCH_NAME, form.getSearch());
        return Specification.where(whereUsername.or(whereFirst_name).or(whereLast_name).or(whereBranchBranch_name));
    }
    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Account>{
        private String key;
        private Object value;
        @Override
        public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case USERNAME:
                    return criteriaBuilder.like(root.get("username"), "%" + value + "%");
                case FIRST_NAME:
                    return criteriaBuilder.like(root.get("first_name"), "%" + value + "%");
                case LAST_NAME:
                    return criteriaBuilder.like(root.get("last_name"), "%" + value + "%");
                case BRANCH_NAME:
                    return criteriaBuilder.like(root.get("branch").get("branch_name"), "%" + value + "%");
            }
            return null;
        }
    }
}
