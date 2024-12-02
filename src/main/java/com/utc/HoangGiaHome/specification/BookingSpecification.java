package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Account;
import com.utc.HoangGiaHome.entity.Booking;
import com.utc.HoangGiaHome.form.AccountFilterForm;
import com.utc.HoangGiaHome.form.BookingFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class BookingSpecification {
    private static final String FULL_NAME = "full_name";
    private static final String ROOM_MANE = "roomRoom_name";
    private static final String BRANCH_NAME = "branchBranch_name";


    public static Specification<Booking> buildWhere(BookingFilterForm form){
        if (form == null){
            return null;
        }
        Specification<Booking> whereFull_name = new BookingSpecification.SpecificationImpl(FULL_NAME, form.getSearch());
        Specification<Booking> whereRoomRoom_name = new BookingSpecification.SpecificationImpl(ROOM_MANE, form.getSearch());
        Specification<Booking> whereBranchBranch_name = new BookingSpecification.SpecificationImpl(BRANCH_NAME, form.getSearch());
        return Specification.where(whereFull_name).or(whereRoomRoom_name.or(whereBranchBranch_name));
    }
    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Booking>{
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Booking> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case FULL_NAME:
                    return criteriaBuilder.like(root.get("full_name"), "%" + value + "%");
                case ROOM_MANE:
                    return criteriaBuilder.like(root.get("room").get("room_name"), "%" + value + "%");
                case BRANCH_NAME:
                    return criteriaBuilder.like(root.get("branch").get("branch_name"), "%" + value + "%");
            }
            return null;
        }
    }
}
