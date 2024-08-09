package katachi.spring.exercise.service;

import java.util.List;

import katachi.spring.exercise.model.Team;

public interface TeamService {
	
	/** チーム一覧取得 */
	public List<Team> getTeams();
}