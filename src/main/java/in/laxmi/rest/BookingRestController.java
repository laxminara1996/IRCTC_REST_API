package in.laxmi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.laxmi.binding.Passenger;
import in.laxmi.response.Ticket;
import in.laxmi.service.BookingService;
@RestController
public class BookingRestController {
	@Autowired
	private BookingService service;
	@PostMapping(value="/ticket",
			      consumes="application/json",
			      produces="application/json")
      public ResponseEntity<Ticket> ticketBooking(@RequestBody Passenger passenger){
		System.out.println(passenger);
    	  Ticket tckt = service.bookTicket(passenger);
    	  return new ResponseEntity<>(tckt,HttpStatus.CREATED);
      }
	@GetMapping(value = "/ticket/{ticketNumber}",
			    produces="application/json")
	public Ticket getTicket(@PathVariable Integer ticketNumber) {
		System.out.println(ticketNumber);
          return service.getTicket(ticketNumber);
	}
}
