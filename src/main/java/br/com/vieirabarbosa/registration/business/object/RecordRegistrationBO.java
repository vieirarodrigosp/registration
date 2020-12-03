package br.com.vieirabarbosa.registration.business.object;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vieirabarbosa.registration.DTO.RegistrationDTO;
import br.com.vieirabarbosa.registration.business.service.GradeBS;
import br.com.vieirabarbosa.registration.business.service.StudentBS;

@Component
public class RecordRegistrationBO {
	List<RegistrationDTO> registrationList = new ArrayList<RegistrationDTO>();
	@Autowired
	private StudentBS studentBS;
	@Autowired
	private GradeBS gradeBS;
	public boolean createRegistrationDTO(RegistrationDTO registration) {
		registration.setId(UUID.randomUUID().hashCode());
		return registrationList.add(registration);
	}
	public Object[] getRegistrationDTO() {
		registrationList.stream()
			.map((RegistrationDTO registration) -> {
				registration.setGrade(gradeBS.getgradeDTObyId(registration.getIdGrade()));
				registration.setStudent(studentBS.getStudentDTObyId(registration.getIdStudent()));
				return registration; })
			.collect(Collectors.toList());
		return registrationList.toArray();
	}
	public RegistrationDTO getRegistrationDTOById(int id) {
		registrationList.get(id).setGrade(
				gradeBS.getgradeDTObyId(registrationList.get(id).getIdGrade()));
		registrationList.get(id).setStudent(
				studentBS.getStudentDTObyId(registrationList.get(id).getIdStudent()));
		return registrationList.get(id);
	}
	public RegistrationDTO updateRegistrationDTO(int id, RegistrationDTO registration) {
		return registrationList.set(id, registration);
	}
	public RegistrationDTO deleteRegistrationDTO(int id) {
		return registrationList.remove(id);
	}
}