package katachi.spring.exercise.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	// EX1.
	@GetMapping("/index")
	public String getHello() {
		return "/";
	}
	
	// EX2.
//	@GetMapping("/input")
//	public String getInput() {
//		return "/input";
//	}
	
	// EX3.
	@GetMapping("/input")
	public String getInput(@RequestParam(name = "name", required = false) String str, Model model) {
		
		model.addAttribute("name", str);
		
		return "/input";
	}
	
	// EX4.
	@PostMapping("/input")
	public String postProfile(@RequestParam("name") String str, Model model) {
		
		model.addAttribute("name", str);
		
		return "/profile";
	}

}