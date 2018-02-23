package com.sis.promotion.ticket.infrastructure.ticket;

import com.sis.promotion.ticket.domain.ticket.TicketBill;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * TicketSpecific
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
@Repository
public interface TicketSpecific extends JpaSpecificationExecutor<TicketBill>, CrudRepository<TicketBill,Long> {
    TicketBill findByTicketCode(String ticketCode);
}
