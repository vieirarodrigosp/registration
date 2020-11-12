package vieirabarbosa.com.br.registration.business.service;

import org.springframework.stereotype.Service;

import vieirabarbosa.com.br.registration.DTO.StudentDTO;
import vieirabarbosa.com.br.registration.gateway.StudentGTW;

@Service
public class StudentBS implements StudentGTW {
	private final StudentGTW studentGTW;
	StudentBS(StudentGTW studentGTW){
		this.studentGTW = studentGTW;
	}
	@Override
	public Object[] getStudentList() {
		return this.studentGTW.getStudentList();
	}
	@Override
	public StudentDTO getStudentDTObyId(int id) {
		return this.studentGTW.getStudentDTObyId(id);
	}
}