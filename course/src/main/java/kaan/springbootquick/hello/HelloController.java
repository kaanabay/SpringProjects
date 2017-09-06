package kaan.springbootquick.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String greet() {
		return "<h2>Hello Stranger!</h2>";
	}
	
}
