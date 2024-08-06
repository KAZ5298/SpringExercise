package katachi.spring.exercise.hello;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import katachi.spring.exercise.application.service.UserApplicationService;
import katachi.spring.exercise.form.UserForm;
import katachi.spring.exercise.model.User;
import katachi.spring.exercise.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
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
	
	// EX9. ユーザ登録
	@Autowired
	private UserApplicationService userApplicationService;
	
//	@Autowired
//	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/user/add")
	public String getAddUser(Model model, @ModelAttribute UserForm userForm) {
		
		Map<String, Integer> teamMap = userApplicationService.getTeamMap();
		model.addAttribute("teamMap", teamMap);
		
		return "/user/add";
	}
	
	@PostMapping("/user/add")
	public String postAddUser(Model model, @ModelAttribute @Validated UserForm userForm,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return getAddUser(model, userForm);
		}
		
		log.info(userForm.toString());
		
		User user = modelMapper.map(userForm, User.class);
		
		userService.signup(user);
		
		List<User> userList = userService.getUsers();
		
		model.addAttribute("userList", userList);
		
		return getUserList(model);
	}
		
}