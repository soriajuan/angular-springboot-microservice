package backend.api;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import backend.domain.entity.Person;
import backend.domain.usecase.CreatePersonUseCase;
import backend.domain.usecase.DeletePersonUseCase;
import backend.domain.usecase.ReadPersonUseCase;
import backend.domain.usecase.UpdatePersonUseCase;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	CreatePersonUseCase createUseCase;

	@MockBean
	ReadPersonUseCase readUseCase;

	@MockBean
	UpdatePersonUseCase updateUseCase;

	@MockBean
	DeletePersonUseCase deleteUseCase;

	@MockBean
	ApiMapper mapper;

	@Test @Disabled
	public void getAllOk() throws Exception {
		List<Person> personsMock = List.of(
				Person.builder().id("1").firstName("Nikola").lastName("Tesla").dateOfBirth(LocalDate.of(1856, 7, 10))
						.build(),
				Person.builder().id("2").firstName("Albert").lastName("Einstein").dateOfBirth(LocalDate.of(1879, 3, 14))
						.build(),
				Person.builder().id("3").firstName("Carl").lastName("Sagan").dateOfBirth(LocalDate.of(1934, 11, 9))
						.build());
		when(readUseCase.readAll()).thenReturn(personsMock);
		//when(mapper.toPersonGetResponsePayload(any(Person.class))).thenReturn(any(PersonGetResponsePayload.class));

		MvcResult mvcResult = mockMvc.perform(get("/persons")).andExpect(status().isOk()).andReturn();

		Approvals.verify(mvcResult.getResponse().getContentAsString());

		verify(readUseCase).readAll();
		verifyNoMoreInteractions(readUseCase);
		// verifyNoInteractions(mapper);
	}

//	@Test
//	public void getByIdOk() throws Exception {
//		Long id = 1L;
//		String string = "string";
//		Integer ano = 2021;
//		Boolean vendido = false;
//		LocalDateTime now = LocalDateTime.of(2021, 9, 18, 0, 0);
//
////		Person veiculo = Person.builder().id(id).veiculo(string).marca(string).ano(ano).descricao(string)
////				.vendido(vendido).created(now).updated(now).build();
//		Person veiculo = null;
//		when(readUseCase.readById(anyLong())).thenReturn(veiculo);
//
//		PersonGetResponsePayload veiculoGetResponsePayload = new PersonGetResponsePayload();
//		veiculoGetResponsePayload.setId(id);
////		veiculoGetResponsePayload.setVeiculo(string);
////		veiculoGetResponsePayload.setMarca(string);
////		veiculoGetResponsePayload.setAno(ano);
////		veiculoGetResponsePayload.setDescricao(string);
////		veiculoGetResponsePayload.setVendido(vendido);
////		veiculoGetResponsePayload.setCreated(now);
////		veiculoGetResponsePayload.setUpdated(now);
////		when(mapper.toVeiculoGetResponsePayload(any(Person.class))).thenReturn(veiculoGetResponsePayload);
//
//		MvcResult mvcResult = this.mockMvc.perform(get("/veiculos/{id}", 1)).andExpect(status().isOk()).andReturn();
//
//		Approvals.verifyJson(mvcResult.getResponse().getContentAsString());
//	}
//
//	@Test
//	public void postCreated() throws Exception {
//		Long id = 1L;
//		String string = "string";
//		Integer ano = 2021;
//		Boolean vendido = false;
//
////		Person veiculo = Person.builder().veiculo(string).marca(string).ano(ano).descricao(string).vendido(vendido)
////				.build();
//		Person veiculo = null;
////		when(mapper.toVeiculo(any(PersonPostRequestPayload.class))).thenReturn(veiculo);
//
//		when(createUseCase.create(any(Person.class)))
//				.thenReturn(veiculo);
//
//		PersonPostRequestPayload veiculoPostRequestPayload = new PersonPostRequestPayload();
////		veiculoPostRequestPayload.setVeiculo(string);
////		veiculoPostRequestPayload.setMarca(string);
////		veiculoPostRequestPayload.setAno(ano);
////		veiculoPostRequestPayload.setDescricao(string);
////		veiculoPostRequestPayload.setVendido(vendido);
//
//		this.mockMvc
//				.perform(post("/veiculos").contentType(MediaType.APPLICATION_JSON)
//						.content(new ObjectMapper().writeValueAsString(veiculoPostRequestPayload)))
//				.andDo(print()).andExpect(status().isCreated())
//				.andExpect(header().string("Location", "/veiculos/" + id));
//	}
//
//	@Test
//	public void deleteNoContent() throws Exception {
//		doNothing().when(deleteUseCase).deleteById(anyLong());
//
//		this.mockMvc.perform(delete("/veiculos/{id}", 1)).andDo(print()).andExpect(status().isNoContent());
//	}

}
