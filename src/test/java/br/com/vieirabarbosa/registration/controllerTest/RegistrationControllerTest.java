package br.com.vieirabarbosa.registration.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vieirabarbosa.registration.DTO.RegistrationDTO;
import br.com.vieirabarbosa.registration.business.object.RecordRegistrationBO;
import br.com.vieirabarbosa.registration.config.VariablesMocked;
import br.com.vieirabarbosa.registration.controller.RegistrationController;

@RunWith(SpringRunner.class)
public class RegistrationControllerTest {
	@InjectMocks
	private RegistrationController registrationController;
	@Mock
	private RecordRegistrationBO recordRegistrationBO;
	@Before
	public void init() {
		recordRegistrationBO.createRegistrationDTO(VariablesMocked.getRegistrationDTO());
	}
	@Test
	public void createRegistrationSucess() {
		when(registrationController.createRegistration(Mockito.any())).thenReturn(true);
		assertEquals(true, recordRegistrationBO.createRegistrationDTO(VariablesMocked.getRegistrationDTO()));
	}
	@Test
	public void createStudentFalse() {
		when(registrationController.createRegistration(Mockito.any())).thenReturn(false);
		assertEquals(false, registrationController.createRegistration(null));
	}
	@Test
	public void getStudentListWithList() {
		when(registrationController.getRegistrationDTO()).thenReturn(VariablesMocked.getRegistrationDTOListObject("withList"));
		assertEquals(1, registrationController.getRegistrationDTO().length);
	}
	@Test
	public void getStudentListNoList() {
		when(registrationController.getRegistrationDTO()).thenReturn(VariablesMocked.getRegistrationDTOListObject("withList"));
		assertNotEquals(3, registrationController.getRegistrationDTO().length);
	}
	@Test
	public void getStudentDTObyIdSucess() {
		when(registrationController.getRegistrationDTOById(Mockito.anyInt())).thenReturn(VariablesMocked.getRegistrationDTO());
		assertEquals(1, registrationController.getRegistrationDTOById(0).getId());
	}
	@Test
	public void getStudentDTObyIdFalse() {
		when(registrationController.getRegistrationDTOById(Mockito.anyInt())).thenReturn(VariablesMocked.getRegistrationDTO());
		assertNotEquals(2, registrationController.getRegistrationDTOById(0).getIdGrade());
	}
	@Test
	public void updateStudentDTObyIdSucess() {
		when(registrationController.updateRegistrationDTO(Mockito.anyInt(), Mockito.any()))
			.thenReturn(RegistrationDTO.builder().id(435).idStudent(98).idGrade(23).build());
		assertEquals(435, registrationController.updateRegistrationDTO(0, VariablesMocked.getRegistrationDTO()).getId());
		assertEquals(98, registrationController.updateRegistrationDTO(0, VariablesMocked.getRegistrationDTO()).getIdStudent());
		assertEquals(23, registrationController.updateRegistrationDTO(0, VariablesMocked.getRegistrationDTO()).getIdGrade());
	}
	@Test
	public void deleteStudentDTObyIdSucess() {
		registrationController.deleteRegistrationDTO(0);
		assertNull(registrationController.getRegistrationDTO());
	}
}