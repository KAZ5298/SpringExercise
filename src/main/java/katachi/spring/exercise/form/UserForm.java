package katachi.spring.exercise.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import lombok.Data;

@Data
public class UserForm {
	
	private Integer id;
	
	@Positive
	private Integer teamId;
	
	@NotBlank
	private String name;
	
}