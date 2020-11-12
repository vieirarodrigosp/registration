package vieirabarbosa.com.br.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vieirabarbosa.com.br.registration.DTO.RegistrationDTO;
import vieirabarbosa.com.br.registration.business.object.RecordRegistrationBO;

@RestController
@RequestMapping("/school")
public class RegistrationController {
	@Autowired
	private RecordRegistrationBO recordRegistrationBO;
	@PostMapping(path = "/v1/registrations")
	public @ResponseBody Boolean createRegistration(@RequestBody RegistrationDTO registration) {
		return recordRegistrationBO.createRegistrationDTO(registration);
	}
	@GetMapping(path = "/v1/registrations")
	public @ResponseBody Object[] getRegistrationDTO() {
		return recordRegistrationBO.getRegistrationDTO();
	}
	@GetMapping(path = "/v1/registrations/{id}")
	public @ResponseBody RegistrationDTO getRegistrationDTOById(@PathVariable("id") int id) {
		return recordRegistrationBO.getRegistrationDTOById(id);
	}
	@PutMapping(path = "/v1/registrations/{id}")
	public @ResponseBody RegistrationDTO updateRegistrationDTO(
			@PathVariable("id") int id
			, @RequestBody RegistrationDTO registration) {
		return recordRegistrationBO.updateRegistrationDTO(id, registration);
	}
	@DeleteMapping(path = "/v1/registrations/{id}")
	public @ResponseBody RegistrationDTO deleteRegistrationDTO(@PathVariable("id") int id) {
		return recordRegistrationBO.deleteRegistrationDTO(id);
	}
}