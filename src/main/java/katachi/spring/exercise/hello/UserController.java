package katachi.spring.exercise.hello;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		
		if (userService.getUserOne(userForm.getName()) == null) {
		
			User user = modelMapper.map(userForm, User.class);
			
			userService.signup(user);
			
			List<User> userList = userService.getUsers();
			
			model.addAttribute("userList", userList);
			
		} else {
			bindingResult.rejectValue("name", "validation.user-already-registered");
			return getAddUser(model, userForm);
		}
		
		return getUserList(model);
	}
	
	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionHandler(DataAccessException e, Model model) {
		model.addAttribute("error", "");
		
		model.addAttribute("message", "ユーザ登録で例外が発生しました");
		
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		model.addAttribute("error", "");
		
		model.addAttribute("message", "ユーザ登録で例外が発生しました");
		
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		
		return "error";
	}
}