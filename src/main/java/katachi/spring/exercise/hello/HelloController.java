package katachi.spring.exercise.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
	
	@GetMapping("/index")
	public String getHello() {
		return "/";
	}
	
	// EX2.
	@GetMapping("/input")
	public String getInput() {
		return "/input";
	}
	
	@PostMapping("/index")
	public String postRequest() {
		return "/input";
	}
}