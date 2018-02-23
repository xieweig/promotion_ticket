package com.sis.promotion.ticket.domain.ticket;

import cn.sisyphe.framework.ddd.annotations.DomainEvent;
import com.sis.promotion.ticket.domain.BaseBill;
import com.sis.promotion.ticket.domain.enums.ConsumeEnum;
import com.sis.promotion.ticket.domain.enums.PushEnum;
import com.sis.promotion.ticket.domain.enums.SubmitEnum;
import com.sis.promotion.ticket.domain.ticket.behavior.DomainBehavior;
import com.sis.promotion.ticket.infrastructure.CommonRepo;
import org.springframework.context.ApplicationEventPublisher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;

/**
 * TicketBill root聚合根
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
@Entity
public class TicketBill extends BaseBill {
    /**
      * note:维护一个批次信息 oneToMany
      */
    public Batch batch;
    /**
      * note:全服务唯一标识符
      */
    public String TicketCode;
    /**
        * note:三个核心业务状态组成 behavior的内容
        */
    public SubmitEnum submitEnum;
    public PushEnum pushEnum;
    public ConsumeEnum consumeEnum;

    /**
      * note:领域驱动的几个核心方法
      */
    public TicketBill drive(DomainBehavior domainBehavior){
        return domainBehavior.reachNextStateSet(this);
    }

    public TicketBill sendSelfAsEvent(ApplicationEventPublisher applicationEventPublisher){
        applicationEventPublisher.publishEvent(new TicketEvent(this));
        return this;
    }
    public TicketBill persistSelf(CommonRepo<TicketBill> commonRepo){
        return commonRepo.save(this);
    }


    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getTicketCode() {
        return TicketCode;
    }

    public void setTicketCode(String ticketCode) {
        TicketCode = ticketCode;
    }

    public SubmitEnum getSubmitEnum() {
        return submitEnum;
    }

    public void setSubmitEnum(SubmitEnum submitEnum) {
        this.submitEnum = submitEnum;
    }

    public PushEnum getPushEnum() {
        return pushEnum;
    }

    public void setPushEnum(PushEnum pushEnum) {
        this.pushEnum = pushEnum;
    }

    public ConsumeEnum getConsumeEnum() {
        return consumeEnum;
    }

    public void setConsumeEnum(ConsumeEnum consumeEnum) {
        this.consumeEnum = consumeEnum;
    }

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
