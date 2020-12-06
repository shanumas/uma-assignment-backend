package uma.assignment.core.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import uma.assignment.core.domain.Booking;

public interface BookingRepository extends Repository<Booking, Long> {
	
	List<Booking> findAll();

}
