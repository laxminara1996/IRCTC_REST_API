package in.laxmi.service;

import in.laxmi.binding.Passenger;
import in.laxmi.response.Ticket;

public interface BookingService {
public Ticket bookTicket(Passenger passenger);
public Ticket getTicket(Integer ticketNumber);
}
