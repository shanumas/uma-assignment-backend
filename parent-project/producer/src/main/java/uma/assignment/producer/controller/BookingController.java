package uma.assignment.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uma.assignment.common.domain.Booking;
import uma.assignment.producer.services.ProducerService;

@RestController
public class BookingController {
	
	@Autowired
	private ProducerService producerService;
	
	@ResponseBody
	@RequestMapping("/book")
	public Booking book(@RequestBody Booking booking)
	{
		Booking bookingCreated = producerService.createBooking(booking);
		return bookingCreated;
		
	}

}
