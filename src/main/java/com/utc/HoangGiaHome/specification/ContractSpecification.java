package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Contract;
import com.utc.HoangGiaHome.form.ContractFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class ContractSpecification {
    private static final String CONTRACT_NAME  = "contract_name";
    private static final String CUSTOMER_NAME = "customerFull_name";
    private static final String ROOM_NAME = "roomRoom_name";

    public static Specification<Contract> buildWhere(ContractFilterForm form){
        if (form == null){
            return null;
        }
        Specification<Contract> whereContract_name = new SpecificationImpl(CONTRACT_NAME, form.getSearch());
        Specification<Contract> whereCustomerFull_name = new SpecificationImpl(CUSTOMER_NAME, form.getSearch());
        Specification<Contract> whereRoomRoom_name = new SpecificationImpl(ROOM_NAME, form.getSearch());
        return Specification.where(whereContract_name). or(whereCustomerFull_name.or(whereRoomRoom_name));
    }
    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Contract>{
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Contract> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case CONTRACT_NAME:
                    return criteriaBuilder.like(root.get("contract_name"), "%" + value + "%");
                case CUSTOMER_NAME:
                    return criteriaBuilder.like(root.get("customer").get("full_name"), "%" + value + "%");
                case ROOM_NAME:
                    return criteriaBuilder.like(root.get("room").get("room_name"), "%" + value + "%");
            }
            return null;
        }
    }
}
