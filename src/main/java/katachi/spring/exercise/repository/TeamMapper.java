package katachi.spring.exercise.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import katachi.spring.exercise.model.Team;

@Mapper
public interface TeamMapper {
	public List<Team> findMany();
}