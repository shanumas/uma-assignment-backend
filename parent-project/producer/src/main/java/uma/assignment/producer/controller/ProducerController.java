package uma.assignment.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import uma.assignment.common.domain.Booking;
import uma.assignment.producer.services.ProducerService;

@RestController
public class ProducerController implements WebMvcConfigurer {

	@Autowired
	private ProducerService producerService;

	@ResponseBody
	@RequestMapping("/add")
	public Booking add(@RequestBody Booking booking) {
		Booking bookingCreated = producerService.add(booking);
		return bookingCreated;
	}
	
	@ResponseBody
	@RequestMapping("/edit")
	public Booking book(@RequestBody Booking booking) {
		Booking bookingCreated = producerService.edit(booking);
		return bookingCreated;
	}
	
	@DeleteMapping("/delete/{bookingid}")
	private void delete(@PathVariable("bookingid") long bookid) {
		producerService.delete(bookid);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("*");
	}

}
