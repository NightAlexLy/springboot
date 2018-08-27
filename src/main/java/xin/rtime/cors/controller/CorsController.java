package xin.rtime.cors.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 *  Chapter24 cors Controller test
 *
 */
@Controller
@RequestMapping("/cors")
public class CorsController {

	@GetMapping
	public String cors() {
		return "cors";
	}
	
	@PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String query() {
		return "hello";
	}
	
}
