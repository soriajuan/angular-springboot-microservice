package backend.data;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("persons")
class PersonMongo {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;

}
