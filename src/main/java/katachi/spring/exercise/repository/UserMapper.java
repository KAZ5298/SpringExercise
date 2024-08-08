package katachi.spring.exercise.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import katachi.spring.exercise.model.User;

@Mapper
public interface UserMapper {
	public List<User> findMany();
	
	// EX9. ユーザ登録
	public int insertOne(User user);

	public Integer findOne(String name);
	
	// EX10. ユーザ削除
	public int deleteOne(@Param("id") Integer id);
}