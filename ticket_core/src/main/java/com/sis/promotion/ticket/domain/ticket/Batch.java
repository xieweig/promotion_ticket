package com.sis.promotion.ticket.domain.ticket;

import com.sis.promotion.ticket.domain.BaseBill;

import java.util.Date;
import java.util.List;

/**
 * Batch
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
public class Batch extends BaseBill{
    /**
      * note:聚合内部唯一批次号
      */
    private String batchCode;
    private String batchName;
    /**
      * note:批次数量
      */
    private Integer amount;
    /**
      * note:有效期限 单位应该是 天
      */
    private Integer expiryDate;
    /**
      * note:只维护一个活动编号，活动和活动规则另算？其实活动规则是否可以单独为一个聚合 而外界访问活动只能通过具体券？
      */
    private String promotionCode;
    /**
      * note:用券说明
      */
    private String memo;

    private Date pushTime;


    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Integer expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
