package com.sis.promotion.ticket.listener;

import com.sis.promotion.ticket.domain.ticket.TicketEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.Column;

/**
 * TicketListener
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
@Service
public class TicketListener {

    @EventListener(condition = "#ticketEvent.ticketBill.submitEnum == ")
    public void submit(TicketEvent ticketEvent){

    }
}
