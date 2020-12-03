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
import br.com.vieirabarbosa.registration.gateway.GradeGTW;

@RunWith(SpringRunner.class)
public class GradeBSTest {
	@InjectMocks
	private GradeBS gradeBS;
	@Mock
	private GradeGTW gradeGTW;
	@Test
	public void getgradeListSucess() {
		when(gradeBS.getgradeList()).thenReturn(VariablesMocked.getGradeDTOListObject("withList"));
		assertEquals(1, gradeBS.getgradeList().length);
	}
	@Test
	public void getgradeDTObyIdSucess() {
		when(gradeBS.getgradeDTObyId(Mockito.anyInt())).thenReturn(VariablesMocked.getGradeDTO());
		assertEquals("ENSINO_FUNDAMENTAL", gradeBS.getgradeDTObyId(0).getCiclo());
	}
}