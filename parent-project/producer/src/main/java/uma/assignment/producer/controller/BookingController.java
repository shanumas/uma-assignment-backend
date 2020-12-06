package uma.assignment.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uma.assignment.core.domain.Booking;
import uma.assignment.core.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@ResponseBody
	@RequestMapping("/book")
	public Booking book(@RequestBody Booking booking)
	{
		Booking bookingCreated = bookingService.createBooking(booking);
		return bookingCreated;
		
	}

}
