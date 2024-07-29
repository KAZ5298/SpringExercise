package katachi.spring.exercise.form;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProfileForm {
	
	@NotBlank
	private String name;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	@NotNull
	private Integer gender;
	
	private Integer bloodtype;
	
//	@AssertTrue
	private String[] study;
	
	@NotBlank
//	@Max(100)
	private String remarks;
	
}