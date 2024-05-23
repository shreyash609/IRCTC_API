package in.ashokit.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Passenger;
import in.ashokit.binding.Ticket;

@Service
public class TicketServiceImpl implements TicketService{

    Map<Integer, Ticket> map = new HashMap<>();

	@Override
	public Ticket bookTicket(Passenger p) {

		Ticket t=new Ticket();

		Random random = new Random();
		int id = random.nextInt(1000);
	
		t.setTickNum(id);
		t.setStatus("CONFIRMED");
		
		BeanUtils.copyProperties(p,t);
		
		map.put(id,t);
		
		return t;
	}

	@Override
	public Collection<Ticket> getAllTickets() {
		return map.values();
	}
}










