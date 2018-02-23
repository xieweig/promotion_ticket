package com.sis.promotion.ticket.domain.ticket.behavior;

import com.sis.promotion.ticket.domain.enums.ConsumeEnum;
import com.sis.promotion.ticket.domain.enums.PushEnum;
import com.sis.promotion.ticket.domain.enums.SubmitEnum;
import com.sis.promotion.ticket.domain.ticket.TicketBill;

/**
 * consumeSuccessBehavior
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
public class consumeSuccessBehavior implements DomainBehavior {
    @Override
    public TicketBill reachNextStateSet(TicketBill ticketBill) {
        if (ticketBill.getSubmitEnum()!= SubmitEnum.SUBMITED_SUCCESS || ticketBill.getPushEnum()!= PushEnum.PUSHED_SUCCESS)
            throw new RuntimeException("流程错误:"+this.getClass().getSimpleName());
       ticketBill.setConsumeEnum(ConsumeEnum.CONSUMED_SUCCESS);
       return ticketBill;
    }
}
