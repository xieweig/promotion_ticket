package com.sis.promotion.ticket.domain.ticket.behavior;

import com.sis.promotion.ticket.domain.enums.ConsumeEnum;
import com.sis.promotion.ticket.domain.enums.PushEnum;
import com.sis.promotion.ticket.domain.enums.SubmitEnum;
import com.sis.promotion.ticket.domain.ticket.TicketBill;

/**
 * submitedSuccessBehavior
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
public class SubmitedSuccessBehavior implements DomainBehavior {
    @Override
    public TicketBill reachNextStateSet(TicketBill ticketBill) {
        if (ticketBill.getPushEnum() == PushEnum.PUSHED_SUCCESS || ticketBill.getConsumeEnum() == ConsumeEnum.CONSUMED_SUCCESS)
            throw new RuntimeException("流程错误:"+this.getClass().getSimpleName());

        ticketBill.setSubmitEnum(SubmitEnum.SUBMITED_SUCCESS);
        ticketBill.setConsumeEnum(ConsumeEnum.CONSUME_NOT_YET);
        ticketBill.setPushEnum(PushEnum.PUSH_NOT_YET);
        return ticketBill;
    }
}
