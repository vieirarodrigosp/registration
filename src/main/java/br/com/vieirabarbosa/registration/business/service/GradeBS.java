package br.com.vieirabarbosa.registration.business.service;

import org.springframework.stereotype.Service;

import br.com.vieirabarbosa.registration.DTO.GradeDTO;
import br.com.vieirabarbosa.registration.gateway.GradeGTW;

@Service
public class GradeBS implements GradeGTW {
	private final GradeGTW gradeGTW;
	GradeBS(GradeGTW gradeGTW){
		this.gradeGTW = gradeGTW;
	}
	@Override
	public Object[] getgradeList() {
		return this.gradeGTW.getgradeList();
	}
	@Override
	public GradeDTO getgradeDTObyId(int id) {
		return this.gradeGTW.getgradeDTObyId(id);
	}
}