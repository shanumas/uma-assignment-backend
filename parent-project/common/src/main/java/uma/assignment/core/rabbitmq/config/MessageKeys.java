package uma.assignment.core.rabbitmq.config;

public class MessageKeys {
	
	//Exchanges
	public static final String MESSAGE_EXCHANGE_NAME = "uma.assignment.message.exchange";
	public static final String BOOKING_EXCHANGE_NAME = "uma.assignment.booking.exchange";
	
	//Queues
	public static final String MESSAGE_AUDIT_QUEUE = "uma.assignment.queue.messageaudit";
	
	public static final String BOOKING_ADD_QUEUE = "uma.assignment.queue.booking.add";
	public static final String BOOKING_EDIT_QUEUE = "uma.assignment.queue.booking.edit";
	public static final String BOOKING_DELETE_QUEUE = "uma.assignment.queue.booking.delete";	

}
