package bll;

import java.util.regex.Pattern;

import dal.Student;

public class NameValidator implements Validator<Student>{

	private static final String NAME_PATTERN = "[a-zA-Z][a-zA-Z ]*" ;

	public void validate(Student s) {
		Pattern pattern = Pattern.compile(NAME_PATTERN);
		if (!pattern.matcher(s.getName()).matches()) {
			throw new IllegalArgumentException("Student name is not a valid name!");
		}
	}
}
