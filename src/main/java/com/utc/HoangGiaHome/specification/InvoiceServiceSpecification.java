package com.utc.HoangGiaHome.specification;

import com.utc.HoangGiaHome.entity.CustomerService;
import com.utc.HoangGiaHome.entity.InvoiceService;
import com.utc.HoangGiaHome.form.CustomerServiceFilterForm;
import com.utc.HoangGiaHome.form.InvoiceServiceFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

public class InvoiceServiceSpecification {
    private static final String INVOICE_NAME = "invoiceInvoiceName";
    private static final String SERVICE_NAME = "serviceServiceName";
    public static Specification<InvoiceService> buildWhere(InvoiceServiceFilterForm form){
        if (form == null){
            return null;
        }
        Specification<InvoiceService> whereInvoiceInvoiceName = new InvoiceServiceSpecification.SpecificationImpl(INVOICE_NAME, form.getSearch());
        Specification<InvoiceService> whereServiceServiceName = new InvoiceServiceSpecification.SpecificationImpl(SERVICE_NAME, form.getSearch());
        return Specification.where(whereInvoiceInvoiceName).or(whereServiceServiceName);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class SpecificationImpl implements Specification<InvoiceService>{
        private String key;
        private Object value;


        @Override
        public Predicate toPredicate(Root<InvoiceService> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            switch (key){
                case INVOICE_NAME:
                    return criteriaBuilder.like(root.get("invoice").get("invoiceName"), "%" + value + "%");

                case SERVICE_NAME:
                    return criteriaBuilder.like(root.get("service").get("serviceName"), "%" + value + "%");
            }
            return null;
        }
    }
}
