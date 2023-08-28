package in.laxmi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.laxmi.binding.Passenger;
import in.laxmi.response.Ticket;
@Service
public class BookingServiceImpl implements BookingService{
private Map<Integer,Ticket> ticketData= new HashMap();
	private Integer ticketNum = 1;
@Override
	public Ticket bookTicket(Passenger passenger) {
		// TODO Auto-generated method stub
		Ticket t = new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketCost(500);
		t.setStatus("Conformed");
		t.setTicketNum(ticketNum);
		ticketData.put(ticketNum, t);
		ticketNum++;
		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		// TODO Auto-generated method stub
		if(ticketData.containsKey(ticketNumber)) {
			return ticketData.get(ticketNumber);
		}
		return null;
	}

}
