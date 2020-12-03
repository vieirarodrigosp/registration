package br.com.vieirabarbosa.registration.config;

import java.util.ArrayList;
import java.util.List;

import br.com.vieirabarbosa.registration.DTO.GradeDTO;
import br.com.vieirabarbosa.registration.DTO.RegistrationDTO;
import br.com.vieirabarbosa.registration.DTO.StudentDTO;

public class VariablesMocked {
	public static RegistrationDTO getRegistrationDTO() {
		return RegistrationDTO.builder().id(1).idStudent(0).idGrade(0).build();
	}
	public static GradeDTO getGradeDTO() {
		return GradeDTO.builder().term("MANHA").grade("QUINTA_SERIE").ciclo("ENSINO_FUNDAMENTAL").year("6").build();
	}
	public static StudentDTO getStudentDTO() {
		return StudentDTO.builder().name("Rodrigo Vieira").matricula("1").build();
	}
	public static Object[] getRegistrationDTOListObject(String scenario) {
		List<RegistrationDTO> registrationListDTO = new ArrayList<RegistrationDTO>();
		switch (scenario) {
		case "withList":
			registrationListDTO.add(getRegistrationDTO());	
			break;
		default:
			break;
		}
		return registrationListDTO.toArray();
	}
	public static Object[] getGradeDTOListObject(String scenario) {
		List<GradeDTO> gradeListDTO = new ArrayList<GradeDTO>();
		switch (scenario) {
		case "withList":
			gradeListDTO.add(getGradeDTO());	
			break;
		default:
			break;
		}
		return gradeListDTO.toArray();
	}
}