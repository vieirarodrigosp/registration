package br.com.vieirabarbosa.registration.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.vieirabarbosa.registration.DTO.GradeDTO;

@FeignClient(value = "school-grade", url = "${url.school.grade}")
public interface GradeGTW {
	@GetMapping("/school/v1/grades")
	public @ResponseBody Object[] getgradeList();
	@GetMapping("/school/v1/grades/{id}")
	public @ResponseBody GradeDTO getgradeDTObyId(@PathVariable("id") int id);
}
