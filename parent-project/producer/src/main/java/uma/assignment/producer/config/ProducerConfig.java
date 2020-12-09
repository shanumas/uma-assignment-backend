/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uma.assignment.producer.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uma.assignment.common.messages.keys.MessageKeys;

@Configuration
public class ProducerConfig {

	@Bean
	public Queue queue1() {
		return new Queue(MessageKeys.BOOKING_ADD_QUEUE);
	}

	@Bean
	public Binding binding1(@Qualifier("queue1") Queue queue1, TopicExchange exchange) {
		return BindingBuilder.bind(queue1).to(exchange).with(MessageKeys.ROUTINGKEY_ADD);
	}

	@Bean
	public Queue queue2() {
		return new Queue(MessageKeys.BOOKING_EDIT_QUEUE);
	}

	@Bean
	public Binding binding2(@Qualifier("queue2") Queue queue2, TopicExchange exchange) {
		return BindingBuilder.bind(queue2).to(exchange).with(MessageKeys.ROUTINGKEY_EDIT);
	}

	@Bean
	public Queue queue3() {
		return new Queue(MessageKeys.BOOKING_DELETE_QUEUE);
	}

	@Bean
	public Binding binding3(@Qualifier("queue3") Queue queue3, TopicExchange exchange) {
		return BindingBuilder.bind(queue3).to(exchange).with(MessageKeys.ROUTINGKEY_DELETE);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(MessageKeys.BOOKING_EXCHANGE_NAME);
	}

	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		//rabbitTemplate.start();
		return rabbitTemplate;
	}

}
