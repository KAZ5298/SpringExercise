package katachi.spring.exercise.service;

import java.util.List;

import katachi.spring.exercise.model.User;

public interface UserService {
	
	/** ユーザー一覧取得 */
	public List<User> getUsers();

	// EX9. ユーザ登録
	public void signup(User user);
	
	public Integer getUserOne(String name);
	
	// EX10. ユーザ削除
	public void deleteUserOne(Integer id);
}