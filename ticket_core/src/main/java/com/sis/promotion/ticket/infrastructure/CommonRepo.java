package com.sis.promotion.ticket.infrastructure;

import com.sis.promotion.ticket.domain.BaseBill;
import com.sis.promotion.ticket.domain.ticket.TicketBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CommonRepo 只用来做写仓库
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
@Repository
public interface CommonRepo<T extends BaseBill> extends JpaRepository<T , Long> {

}
