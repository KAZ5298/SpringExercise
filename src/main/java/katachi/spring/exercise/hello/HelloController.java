package katachi.spring.exercise.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/index")
	public String getHello() {
		return "/";
	}
}