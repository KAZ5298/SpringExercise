package katachi.spring.exercise.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import lombok.Data;

@Data
public class UserForm {
	
	@Positive
	private Integer teamId;
	
	@NotBlank
	private String name;
	
}