package backend.api.payload;

import lombok.Data;

@Data
public class PersonPatchRequestPayload {

	private String firstName;
	private String lastName;

}
