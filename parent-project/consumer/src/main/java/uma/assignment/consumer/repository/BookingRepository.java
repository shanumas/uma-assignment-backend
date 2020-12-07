package uma.assignment.consumer.repository;

import org.springframework.data.repository.CrudRepository;

import uma.assignment.common.domain.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {

}
