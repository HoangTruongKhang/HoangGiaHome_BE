package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Contract;
import com.utc.HoangGiaHome.entity.Vehicle;
import com.utc.HoangGiaHome.form.ContractFilterForm;
import com.utc.HoangGiaHome.form.VehicleFilterForm;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class VehicleSpecification {
    private static final String VEHICLE_NAME  = "vehicleName";
    private static final String OWNER_NAME = "owner_name";
    private static final String CUSTOMER_NAME = "customerFull_name";

    public static Specification<Vehicle> buildWhere(VehicleFilterForm form){
        if (form == null){
            return null;
        }
        Specification<Vehicle> whereVehicleName = new VehicleSpecification.SpecificationImpl(VEHICLE_NAME, form.getSearch());
        Specification<Vehicle> whereOwner_name = new VehicleSpecification.SpecificationImpl(OWNER_NAME, form.getSearch());
        Specification<Vehicle> whereCustomerFull_name = new VehicleSpecification.SpecificationImpl(CUSTOMER_NAME, form.getSearch());
        return Specification.where(whereVehicleName).or(whereOwner_name.or(whereCustomerFull_name));
    }
    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Vehicle>{
        private String key;
        private Object value;


        @Override
        public Predicate toPredicate(Root<Vehicle> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case VEHICLE_NAME:
                    return criteriaBuilder.like(root.get("vehicleName"), "%" + value + "%");
                case OWNER_NAME:
                    return criteriaBuilder.like(root.get("owner_name"), "%" + value + "%");
                case CUSTOMER_NAME:
                    Join join = root.join("customer", JoinType.LEFT);
                    return criteriaBuilder.like(join.get("full_name"), "%" + value + "%");
            }
            return null;
        }
    }
}
