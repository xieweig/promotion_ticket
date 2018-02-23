package com.sis.promotion.ticket.listener;

import com.sis.promotion.ticket.domain.ticket.TicketBill;
import com.sis.promotion.ticket.domain.ticket.TicketEvent;
import com.sis.promotion.ticket.infrastructure.CommonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Column;

/**
 * TicketListener
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
@Service
public class TicketListener {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
      * note:可以在此持久化bill或者持久化事件
      */
    @Resource
    private CommonRepo<TicketBill> commonRepo;
    /**
      * note:可以不断发送事件形成事件流，本质上就是将过程代码分段在各个监听函数中，异步执行？
      */
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;


    @EventListener(condition = "#ticketEvent.ticketBill.submitEnum.toString() == 'SUBMITED_SUCCESS'")
    public void submit(TicketEvent ticketEvent){

        logger.info(ticketEvent.getId()+ticketEvent.getTicketBill().getSubmitEnum().toString());
    }
}
