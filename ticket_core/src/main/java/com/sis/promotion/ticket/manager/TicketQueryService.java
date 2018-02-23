package com.sis.promotion.ticket.manager;

import com.sis.promotion.ticket.domain.ticket.TicketBill;
import com.sis.promotion.ticket.infrastructure.ticket.TicketBillDTO;
import com.sis.promotion.ticket.infrastructure.ticket.TicketConditions;
import com.sis.promotion.ticket.infrastructure.ticket.TicketSpecific;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * TicketQueryService
 *
 * @author xie_weiguang
 * @date 2018/2/23
 */
@Service
public class TicketQueryService {

    @Resource
    private TicketSpecific ticketSpecific;

    public TicketBillDTO findByTicketCode(String ticketCode){
       TicketBill ticketBill = ticketSpecific.findByTicketCode(ticketCode);
       TicketBillDTO ticketBillDTO = new TicketBillDTO();
       BeanUtils.copyProperties(ticketBill, ticketBillDTO);
       return ticketBillDTO;
    }

    public List<TicketBillDTO> findAll(TicketConditions ticketConditions){
        List<TicketBill> result = this.ticketSpecific.findAll(ticketConditions.transform());
        List<TicketBillDTO> resultDto = new ArrayList<>(10);
        for (TicketBill ticketBill :
                result) {
            TicketBillDTO ticketBillDTO = new TicketBillDTO();
            BeanUtils.copyProperties(ticketBill,ticketBillDTO);

            resultDto.add(ticketBillDTO);
        }
        return resultDto;
    }
    public Page<TicketBillDTO> findAll(TicketConditions ticketConditions,int pageNumber, int size){
        Sort sort = new Sort(Sort.Direction.DESC,"updateTime");
        Pageable pageable = new PageRequest( pageNumber, size, sort);
        List<TicketBillDTO> list = this.findAll(ticketConditions);
        Page<TicketBillDTO> page = new PageImpl<>(this.findAll(ticketConditions),pageable,list.size());

        return page;
    }
}
