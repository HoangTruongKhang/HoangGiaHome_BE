package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Room;
import com.utc.HoangGiaHome.form.RoomFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class RoomSpeciification {
    private static final String ROOM_NAME = "room_name";
    private static final String MIN_PRICE = "minPrice";
    private static final String MAX_PRICE = "maxPrice";
    private static final String MIN_AREA = "minArea";
    private static final String MAX_AREA = "maxArea";
    public static Specification<Room> buildWhere(RoomFilterForm form){
        if (form == null){
            return null;
        }
        Specification<Room> whereRoom_name = new SpecificationImpl(ROOM_NAME, form.getSearch());
        Specification<Room> whereMinPrice = new SpecificationImpl(MIN_PRICE, form.getMinPrice());
        Specification<Room> whereMaxPrice = new SpecificationImpl(MAX_PRICE, form.getMaxPrice());
        Specification<Room> whereMinArea = new SpecificationImpl(MIN_AREA, form.getMinArea());
        Specification<Room> whereMaxArea = new SpecificationImpl(MAX_AREA, form.getMaxArea());
        return Specification.where(whereRoom_name).and(whereMinPrice.and(whereMaxPrice).and(whereMinArea).and(whereMaxArea));
    }
    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Room>{
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Room> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case ROOM_NAME:
                    return criteriaBuilder.like(root.get("room_name"), "%" + value + "%");
                case MIN_PRICE:
                    return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), value.toString());
                case MAX_PRICE:
                    return criteriaBuilder.lessThanOrEqualTo(root.get("price"), value.toString());
                case MIN_AREA:
                    return criteriaBuilder.greaterThanOrEqualTo(root.get("area"), value.toString());
                case MAX_AREA:
                    return criteriaBuilder.lessThanOrEqualTo(root.get("area"), value.toString());
            }
            return null;
        }
    }
}
