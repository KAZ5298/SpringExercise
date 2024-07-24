package katachi.spring.exercise.form;

import lombok.Data;

@Data
public class ProfileForm {
	
	private String name;

//	@DateTimeFormat(pattern = "yyyy/MM/dd")
//	private Date birthday;
	
	private Integer gender;
	
	private Integer bloodtype;
	
	private String[] study;
	
	private String remarks;
	
}