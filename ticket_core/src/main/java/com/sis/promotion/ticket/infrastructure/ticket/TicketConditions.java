package com.sis.promotion.ticket.infrastructure.ticket;

import com.sis.promotion.ticket.domain.enums.ConsumeEnum;
import com.sis.promotion.ticket.domain.enums.PushEnum;
import com.sis.promotion.ticket.domain.ticket.TicketBill;
import com.sis.promotion.ticket.infrastructure.batch.BatchDTO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * TicketConditions 多条件查询
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
public class TicketConditions {

    private BatchDTO batchDTO;

    private PushEnum pushEnum;
    private ConsumeEnum consumeEnum;

    private String ticketCode;

    public Specification<TicketBill> transform(){
        Specification<TicketBill> specification = new Specification<TicketBill>() {
            @Override
            public Predicate toPredicate(Root<TicketBill> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.distinct(true);
                Predicate predicate  = criteriaBuilder.conjunction();
                List<Expression<Boolean>> expressions = predicate.getExpressions();
                    //todo:if add

                return predicate;
            }
        };
        return specification;
    }

}
