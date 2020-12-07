package uma.assignment.consumer.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uma.assignment.common.messages.keys.MessageKeys;
import uma.assignment.consumer.service.BookingService;

@Configuration
public class ConsumerConfig {
	
	@Autowired
    private ConnectionFactory connectionFactory;
	
	@Autowired
	BookingService bookingService;

	@Bean
	public SimpleMessageListenerContainer container() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(
				this.connectionFactory);
		Object listener = new Object() {
			@SuppressWarnings("unused")
			public void handleMessage(byte[] booking) {
				System.out.println(booking+"--------------------------");
				//bookingService.saveOrUpdate(booking);			
			}
		};
		MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
		container.setMessageListener(adapter);
		container.setQueueNames(MessageKeys.BOOKING_ADD_QUEUE);
		return container;
	}

}
