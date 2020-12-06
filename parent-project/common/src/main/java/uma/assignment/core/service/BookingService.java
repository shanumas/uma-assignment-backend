package uma.assignment.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uma.assignment.core.domain.Booking;
import uma.assignment.core.repository.BookingRepository;

@Component("bookingService")
public class BookingService {
	
	private final BookingRepository bookingRepository;
	
	@Autowired
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}
	
	public List<Booking> findAll(){
		return bookingRepository.findAll();		
	}
	
	public Booking createBooking(Booking booking) {
		return booking;
	}

}
