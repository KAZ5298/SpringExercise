package katachi.spring.exercise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.model.Team;
import katachi.spring.exercise.repository.TeamMapper;
import katachi.spring.exercise.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamMapper mapper;
	
	@Override
	public List<Team> getTeams() {
		return mapper.findMany();
	}
}