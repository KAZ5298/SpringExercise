package katachi.spring.exercise.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import katachi.spring.exercise.application.service.UserApplicationService;
import katachi.spring.exercise.form.UserForm;

@Controller
//@Slf4j
public class UserAddController {
	
	// EX9. ユーザ登録
	@Autowired
	private UserApplicationService userApplicationService;
	
	@GetMapping("/user/add")
	public String addUser(Model model, @ModelAttribute UserForm userForm) {
		
		Map<String, Integer> teamMap = userApplicationService.getTeamMap();
		model.addAttribute("teamMap", teamMap);
		
		return "/user/add";
	}
//	public String getUserList(Model model) {
//		List<User> userList = userService.getUsers();
//		
//		model.addAttribute("userList", userList);
//		
//		log.info(userList.toString());
//		
//		return "/user/add";
//	}
	
}