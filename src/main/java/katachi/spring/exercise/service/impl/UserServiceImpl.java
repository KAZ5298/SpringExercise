package katachi.spring.exercise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.model.User;
import katachi.spring.exercise.repository.UserMapper;
import katachi.spring.exercise.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<User> getUsers() {
		return mapper.findMany();
	}
	
	// EX9. ユーザ登録
	@Override
	public void signup(User user) {
		mapper.insertOne(user);
	}
}