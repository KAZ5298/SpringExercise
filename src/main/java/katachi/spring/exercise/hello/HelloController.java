package katachi.spring.exercise.hello;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import katachi.spring.exercise.application.service.UserApplicationService;
import katachi.spring.exercise.form.ProfileForm;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
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
//	@GetMapping("/input")
//	public String getInput(@RequestParam(name = "name", required = false) String str, Model model) {
//		
//		model.addAttribute("name", str);
//		
//		return "/input";
//	}
	
	// EX4.
	@PostMapping("/input")
	public String postProfile(@RequestParam("name") String str, Model model) {
		
		model.addAttribute("name", str);
		
		return "/profile";
	}
	
	// EX5.
	@Autowired
	private UserApplicationService userApplicationService;
	
	@GetMapping("/input")
	public String getInput(@RequestParam(name = "name", required = false) String str, Model model) {
		
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		
		Map<String, Integer> bloodtypeMap = userApplicationService.getBloodtypeMap();
		model.addAttribute("bloodtypeMap", bloodtypeMap);
		
		Map<String, Integer> studyMap = userApplicationService.getStudyMap();
		model.addAttribute("studyMap", studyMap);
		
		model.addAttribute("name", str);
		
		return "/input";
	}
	
	@PostMapping("/profile")
	public String requestProfile(@ModelAttribute ProfileForm form) {
		
		log.info(form.toString());
		
		return "/profile";
	}
}