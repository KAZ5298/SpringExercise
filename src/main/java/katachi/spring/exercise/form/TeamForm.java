package katachi.spring.exercise.form;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TeamForm {
	
	private Integer id;
	
	@NotBlank
	private String name;
	
}