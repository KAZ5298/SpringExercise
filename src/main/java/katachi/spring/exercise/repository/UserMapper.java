package katachi.spring.exercise.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import katachi.spring.exercise.model.User;

@Mapper
public interface UserMapper {
	public List<User> findMany();
}