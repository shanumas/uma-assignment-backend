package uma.assignment.consumer.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uma.assignment.common.domain.Booking;
import uma.assignment.common.messages.keys.MessageKeys;
import uma.assignment.consumer.service.BookingService;

@Configuration
public class ConsumerConfig {
	
	@Autowired
    private ConnectionFactory connectionFactory;
	
	@Autowired
	BookingService bookingService;
	
	@RabbitListener(queues = MessageKeys.BOOKING_ADD_QUEUE, containerFactory = "rabbitListenerContainerFactory")
    public void processAdvisory(Booking booking) {
		bookingService.saveOrUpdate(booking);	
    }
	
	@Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
	
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
	    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
	    factory.setConnectionFactory(this.connectionFactory);
	    factory.setMessageConverter(converter());
	    return factory; 
	}

}
