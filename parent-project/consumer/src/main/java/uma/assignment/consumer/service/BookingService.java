package uma.assignment.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uma.assignment.common.domain.Booking;
import uma.assignment.consumer.repository.BookingRepository;

@Component("bookingService")
public class BookingService {
	
	private BookingRepository bookingRepository;
	
	@Autowired
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}
	
	public List<Booking> findAll(){
		List<Booking> bookings = new ArrayList<Booking>();
		bookingRepository.findAll().forEach(bookings::add);
		return bookings;	
	}
	
	public Booking saveOrUpdate(Booking booking) {
		bookingRepository.save(booking);
		return booking;
	}
	
	public void delete(long id)   
	{  
		bookingRepository.deleteById(id);  
	}

}
