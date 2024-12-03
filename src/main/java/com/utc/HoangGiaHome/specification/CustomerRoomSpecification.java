package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.CustomerBranch;
import com.utc.HoangGiaHome.entity.CustomerRoom;
import com.utc.HoangGiaHome.form.CustomerBranchFilterForm;
import com.utc.HoangGiaHome.form.CustomerRoomFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class CustomerRoomSpecification {

    private static final String CUSTOMER_NAME = "customerFull_name";
    private static final String ROOM_NAME = "roomRoom_name";
    public static Specification<CustomerRoom> buildWhere(CustomerRoomFilterForm form){
        if (form == null){
            return null;
        }
        Specification<CustomerRoom> whereCustomerFull_name = new CustomerRoomSpecification.SpecificationImpl(CUSTOMER_NAME, form.getSearch());
        Specification<CustomerRoom> whereRoomRoom_name = new CustomerRoomSpecification.SpecificationImpl(ROOM_NAME, form.getSearch());
        return Specification.where(whereCustomerFull_name).or(whereRoomRoom_name);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<CustomerRoom>{
        private String key;
        private Object value;


        @Override
        public Predicate toPredicate(Root<CustomerRoom> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return  null;
            }
            switch (key){
                case CUSTOMER_NAME:
                    return criteriaBuilder.like(root.get("customer").get("full_name"), "%" + value + "%");

                case ROOM_NAME:
                    return criteriaBuilder.like(root.get("room").get("room_name"), "%" + value + "%");
            }
            return null;
        }
    }
}
