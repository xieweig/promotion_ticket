package com.sis.promotion.ticket.manager;

import com.sis.promotion.ticket.domain.ticket.TicketBill;
import com.sis.promotion.ticket.infrastructure.CommonRepo;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TicketCommandService
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
@Service
public class TicketCommandService {

    @Resource
    private CommonRepo<TicketBill> commonRepo;

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;


}
