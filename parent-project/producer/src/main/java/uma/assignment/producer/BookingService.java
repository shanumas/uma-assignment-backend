package uma.assignment.producer;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.assignment.core.domain.Booking;
import uma.assignment.core.rabbitmq.config.MessageKeys;

@Service
public class BookingService {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(BookingService.class);
	    
	 	@Autowired
	    private RabbitTemplate rabbitTemplate;
	    
	 	@Autowired
	    private TopicExchange eventExchange;
	    
	    public Booking createOrder(Booking booking) {
	        
	        booking.setId(Long.parseLong(UUID.randomUUID().toString()));
	        
	        LOGGER.debug("Sending order with floowing id to queue:", booking.getId());
	        
	        rabbitTemplate.convertAndSend(eventExchange.getName(), MessageKeys.BOOKING_ADD_QUEUE, booking);
	        
	        return booking;
	    }

}
