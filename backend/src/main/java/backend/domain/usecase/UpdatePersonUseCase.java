package backend.domain.usecase;

import java.util.Objects;

import org.springframework.stereotype.Component;

import backend.domain.PersonData;
import backend.domain.entity.Person;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdatePersonUseCase {

	private final PersonData data;

	public Person update(String id, Person v) {
		if (Objects.isNull(id)) {
			throw new IllegalArgumentException("person id cannot be null");
		}
		if (Objects.isNull(v)) {
			throw new IllegalArgumentException("person to update cannot be null");
		}
		return data.update(id, v);
	}

}
