package katachi.spring.exercise.service;

import java.util.List;

import katachi.spring.exercise.model.User;

public interface UserService {
	
	/** ユーザー一覧取得 */
	public List<User> getUsers();
}