package uma.assignment.producer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.assignment.common.domain.Booking;
import uma.assignment.common.messages.keys.MessageKeys;

@Service
public class ProducerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private TopicExchange eventExchange;

	public Booking createBooking(Booking booking) {

		booking.setId(System.currentTimeMillis());

		LOGGER.debug("Sending order with floowing id to queue:", booking.getId());

		rabbitTemplate.convertAndSend(eventExchange.getName(), MessageKeys.ROUTINGKEY_ADD, booking);

		return booking;
	}

}
