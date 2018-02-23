package com.sis.promotion.ticket.manager;

import com.sis.promotion.ticket.domain.ticket.TicketBill;
import com.sis.promotion.ticket.domain.ticket.behavior.ConsumeSuccessBehavior;
import com.sis.promotion.ticket.domain.ticket.behavior.PushSuccessBehavior;
import com.sis.promotion.ticket.domain.ticket.behavior.SubmitedSuccessBehavior;
import com.sis.promotion.ticket.infrastructure.CommonRepo;
import com.sis.promotion.ticket.infrastructure.ticket.TicketBillDTO;
import org.springframework.beans.BeanUtils;
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
    private ConsumeSuccessBehavior consumeSuccessBehavior;
    @Resource
    private PushSuccessBehavior pushSuccessBehavior;
    @Resource
    private SubmitedSuccessBehavior submitedSuccessBehavior;

    @Resource
    private CommonRepo<TicketBill> commonRepo;

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    public TicketBill save(TicketBillDTO dto){
        TicketBill ticketBill = new TicketBill();
        BeanUtils.copyProperties(dto, ticketBill);
        return ticketBill.drive(submitedSuccessBehavior)
                    .persistSelf(commonRepo)
                    .sendSelfAsEvent(applicationEventPublisher);

    }
    public TicketBill push(TicketBillDTO dto){
        TicketBill ticketBill = new TicketBill();
        BeanUtils.copyProperties(dto, ticketBill);
        return ticketBill.drive(pushSuccessBehavior)
                    .persistSelf(commonRepo)
                    .sendSelfAsEvent(applicationEventPublisher);
    }
    public TicketBill consume(TicketBillDTO dto){
        TicketBill ticketBill = new TicketBill();
        BeanUtils.copyProperties(dto, ticketBill);
        return ticketBill.drive(consumeSuccessBehavior)
                    .persistSelf(commonRepo)
                    .sendSelfAsEvent(applicationEventPublisher);
    }
}
