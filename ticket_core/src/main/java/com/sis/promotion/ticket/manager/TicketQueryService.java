package com.sis.promotion.ticket.manager;

import com.sis.promotion.ticket.infrastructure.ticket.TicketSpecific;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TicketQueryService
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
@Service
public class TicketQueryService {

    @Resource
    private TicketSpecific ticketSpecific;


}
