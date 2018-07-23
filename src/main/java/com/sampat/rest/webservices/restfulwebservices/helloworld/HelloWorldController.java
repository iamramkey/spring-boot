package com.sampat.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//tell to spring that this class is a controller
@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/")
	public String boot() {
		return "Please enter any sub url";
	}

	// GET
	// URI - /hello-world
	// method - helloWorld
	@RequestMapping(method = RequestMethod.GET, path = "hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	// GET
	// URI - /json
	// method - jsonObject
	@GetMapping(path = "/json")
	public JsonObject jsonObject() {
		return new JsonObject("Hello World!");
	}

	// GET
	// URI - /path-variable/dummy text message
	// method - pathVariable
	@GetMapping(path = "/path-variable/{message}")
	public JsonObject pathVariable(@PathVariable String message) {
		return new JsonObject(String.format("User entered path variable is : %s", message));
	}

	@GetMapping(path = "hello-world-internationalized-old")
	public String hellowWorldInternationalizedOld(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		// writing request header for every path is a painful task so making it a
		// standard & recieving value from Accept Header & return back proper message
		return messageSource.getMessage("good.morning.message", null, locale);
	}

	@GetMapping(path = "hello-world-internationalized")
	public String hellowWorldInternationalized() {
		// this method uses locale context and send the appropriate messages in the
		// response
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

}
