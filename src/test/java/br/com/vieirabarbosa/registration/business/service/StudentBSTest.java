package br.com.vieirabarbosa.registration.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vieirabarbosa.registration.config.VariablesMocked;
import br.com.vieirabarbosa.registration.gateway.StudentGTW;

@RunWith(SpringRunner.class)
public class StudentBSTest {
	@InjectMocks
	private StudentBS studentBS;
	@Mock
	private StudentGTW studentGTW;
	@Test
	public void getStudentListSucess() {
		when(studentBS.getStudentList()).thenReturn(VariablesMocked.getGradeDTOListObject("withList"));
		assertEquals(1, studentBS.getStudentList().length);
	}
	@Test
	public void getStudentDTObyIdSucess() {
		when(studentBS.getStudentDTObyId(Mockito.anyInt())).thenReturn(VariablesMocked.getStudentDTO());
		assertEquals("Rodrigo Vieira", studentBS.getStudentDTObyId(0).getName());
	}
}