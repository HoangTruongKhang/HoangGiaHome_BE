package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.Invoice;
import com.utc.HoangGiaHome.form.InvoiceFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class InvoiceSpecification {
    private static final String INVOICE_NAME = "invoiceName";

    public static Specification<Invoice> buildWhere (InvoiceFilterForm form){
        if (form == null){
            return null;
        }
        Specification<Invoice> whereInvoiceName = new InvoiceSpecification.SpecificationImpl(INVOICE_NAME, form.getSearch());
        return whereInvoiceName;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<Invoice>{
        private String key;
        private Object value;


        @Override
        public Predicate toPredicate(Root<Invoice> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null){
                return null;
            }
            switch (key){
                case INVOICE_NAME:
                    return criteriaBuilder.like(root.get("invoiceName"), "%" + value + "%");
            }
            return null;
        }
    }


}
