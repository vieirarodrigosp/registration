package br.com.vieirabarbosa.registration.business.object;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.vieirabarbosa.registration.DTO.RegistrationDTO;
import br.com.vieirabarbosa.registration.business.service.GradeBS;
import br.com.vieirabarbosa.registration.business.service.StudentBS;
import br.com.vieirabarbosa.registration.config.VariablesMocked;

@RunWith(SpringRunner.class)
public class RecordRegistrationBOTest {
	@InjectMocks
	private RecordRegistrationBO recordRegistrationBO;
	@Mock
	private StudentBS studentBS;
	@Mock
	private GradeBS gradeBS;
	@Before
	public void init() {
		ReflectionTestUtils.setField(recordRegistrationBO, "registrationList", new ArrayList<RegistrationDTO>());
		recordRegistrationBO.registrationList.add(VariablesMocked.getRegistrationDTO());
	}
	@Test
	public void createRegistrationSucess() {
		recordRegistrationBO.createRegistrationDTO(VariablesMocked.getRegistrationDTO());
		assertEquals(2, recordRegistrationBO.getRegistrationDTO().length);
	}
	@Test
	public void getRegistrationDTOSucess() {
		when(gradeBS.getgradeDTObyId(Mockito.anyInt())).thenReturn(VariablesMocked.getGradeDTO());
		when(studentBS.getStudentDTObyId(Mockito.anyInt())).thenReturn(VariablesMocked.getStudentDTO());
		assertEquals(1, recordRegistrationBO.getRegistrationDTO().length);
	}
	@Test
	public void getRegistrationDTOByIdSucess() {
		assertEquals(1, recordRegistrationBO.getRegistrationDTOById(0).getId());
	}
	@Test
	public void  updateRegistrationDTOSucess() {
		RegistrationDTO newRecord = RegistrationDTO.builder().id(125).idStudent(32).idGrade(54).build();
		recordRegistrationBO.updateRegistrationDTO(0, newRecord);
		assertEquals(125, recordRegistrationBO.getRegistrationDTOById(0).getId());
		assertEquals(32, recordRegistrationBO.getRegistrationDTOById(0).getIdStudent());
		assertEquals(54, recordRegistrationBO.getRegistrationDTOById(0).getIdGrade());
	}
	@Test
	public void deleteRegistrationDTOSucess() {
		recordRegistrationBO.deleteRegistrationDTO(0);
		assertEquals(0, recordRegistrationBO.getRegistrationDTO().length);
	}
}