package uma.assignment.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import uma.assignment.common.domain.Booking;
import uma.assignment.consumer.service.BookingService;

@RestController
public class BookingController implements WebMvcConfigurer {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/bookings")
	public List<Booking> bookings()
	{
		return bookingService.findAll();
		
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("*");
	}

}
