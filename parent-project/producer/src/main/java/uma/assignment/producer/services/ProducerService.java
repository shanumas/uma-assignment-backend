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


	private RabbitTemplate rabbitTemplate;
	private TopicExchange eventExchange;
	
	@Autowired
	public ProducerService(RabbitTemplate rabbitTemplate, TopicExchange eventExchange) {
		this.rabbitTemplate = rabbitTemplate;
		this.eventExchange = eventExchange;
		rabbitTemplate.convertAndSend(eventExchange.getName(), "EMPTY_KEY", "");
	}

	public Booking add(Booking booking) {
		LOGGER.debug("Sending booking with fllowing id to queue:", booking.getId());
		rabbitTemplate.convertAndSend(eventExchange.getName(), MessageKeys.ROUTINGKEY_ADD, booking);
		return booking;
	}

	public Booking edit(Booking booking) {
		LOGGER.debug("Sending booking with fllowing id to queue:", booking.getId());
		rabbitTemplate.convertAndSend(eventExchange.getName(), MessageKeys.ROUTINGKEY_EDIT, booking);
		return booking;
	}

	public long delete(long id) {
		LOGGER.debug("Sending booking with fllowing id to queue:", id);
		rabbitTemplate.convertAndSend(eventExchange.getName(), MessageKeys.ROUTINGKEY_DELETE, id);
		return id;
	}

}
