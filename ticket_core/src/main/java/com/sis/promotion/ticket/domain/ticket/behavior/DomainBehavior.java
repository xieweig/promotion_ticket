package com.sis.promotion.ticket.domain.ticket.behavior;

import com.sis.promotion.ticket.domain.ticket.TicketBill;

/**
 * DomainBehavior
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
public interface DomainBehavior {

    TicketBill reachNextStateSet(TicketBill ticketBill);
}
