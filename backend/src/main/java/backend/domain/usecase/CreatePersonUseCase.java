package backend.domain.usecase;

import java.util.Objects;

import org.springframework.stereotype.Component;

import backend.domain.PersonData;
import backend.domain.entity.Person;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreatePersonUseCase {

	private final PersonData data;

	public Person create(Person v) {
		if (Objects.isNull(v)) {
			throw new IllegalArgumentException("person to create cannot be null");
		}
		return data.insert(v);
	}

}
