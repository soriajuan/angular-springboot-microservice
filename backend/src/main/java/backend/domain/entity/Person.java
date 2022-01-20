package backend.domain.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Person {

	private String id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;

}
