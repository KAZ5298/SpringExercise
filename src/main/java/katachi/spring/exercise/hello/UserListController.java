package katachi.spring.exercise.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import katachi.spring.exercise.model.User;
import katachi.spring.exercise.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserListController {
	
	// EX8. WEB プロジェクトからのデータベースの利用
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public String getUserList(Model model) {
		List<User> userList = userService.getUsers();
		
		model.addAttribute("userList", userList);
		
		log.info(userList.toString());
		
		return "/user";
	}
	
}