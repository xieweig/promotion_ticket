package com.sis.promotion.ticket.domain.ticket;

import cn.sisyphe.framework.ddd.events.BaseDomainEvent;

/**
 * TicketEvent
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
public class TicketEvent extends BaseDomainEvent {

    private TicketBill ticketBill;

    public TicketEvent(TicketBill ticketBill) {
        this.ticketBill = ticketBill;
    }

    public TicketBill getTicketBill() {
        return ticketBill;
    }

    public void setTicketBill(TicketBill ticketBill) {
        this.ticketBill = ticketBill;
    }
}
