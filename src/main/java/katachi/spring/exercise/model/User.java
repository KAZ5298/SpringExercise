package katachi.spring.exercise.model;

import lombok.Data;

@Data
public class User {
	private Integer userId;
	private Integer teamId;
	private String userName;
	private Team teamName;
}