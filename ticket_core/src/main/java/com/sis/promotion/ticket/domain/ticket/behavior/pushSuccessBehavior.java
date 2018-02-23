package com.sis.promotion.ticket.domain.ticket.behavior;

import com.sis.promotion.ticket.domain.enums.ConsumeEnum;
import com.sis.promotion.ticket.domain.enums.PushEnum;
import com.sis.promotion.ticket.domain.enums.SubmitEnum;
import com.sis.promotion.ticket.domain.ticket.TicketBill;

/**
 * pushSuccessBehavior
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
public class pushSuccessBehavior implements DomainBehavior {
    @Override
    public TicketBill reachNextStateSet(TicketBill ticketBill) {
        if (ticketBill.getConsumeEnum() == ConsumeEnum.CONSUMED_SUCCESS || ticketBill.getSubmitEnum() != SubmitEnum.SUBMITED_SUCCESS)
            throw new RuntimeException("流程错误:"+this.getClass().getSimpleName());
        ticketBill.setPushEnum(PushEnum.PUSHED_SUCCESS);
        return ticketBill;
    }
}
