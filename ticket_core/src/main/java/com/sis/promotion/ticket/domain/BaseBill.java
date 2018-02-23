package com.sis.promotion.ticket.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * BaseBill
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
public class BaseBill {


    @Temporal(TemporalType.TIME)
    @JsonFormat()
    private Date creatTime;

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Temporal(TemporalType.TIME)
    @JsonFormat()
    private Date updateTime;


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
