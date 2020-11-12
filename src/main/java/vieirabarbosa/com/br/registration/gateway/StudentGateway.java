//package vieirabarbosa.com.br.registration.gateway;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import vieirabarbosa.com.br.registration.DTO.StudentDTO;
//
//@FeignClient(value = "school-student", url = "${url.school.student}")
//public interface StudentGateway {
//	@GetMapping("/school/v1/students")
//	public @ResponseBody Object[] getStudentList();
//	@GetMapping("/school/v1/students/{id}")
//	public @ResponseBody StudentDTO getStudentDTObyId(@PathVariable("id") int id);
//}