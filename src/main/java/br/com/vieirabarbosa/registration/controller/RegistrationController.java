package br.com.vieirabarbosa.registration.controller;

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

import br.com.vieirabarbosa.registration.DTO.RegistrationDTO;
import br.com.vieirabarbosa.registration.business.object.RecordRegistrationBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/school")
@Api(value = "API REST Registration"
, tags = "Integration microservice registration API between students and their curriculum"
, description = "This microservice is responsible for registering, updating, deleting and registering between students and their curricula.")
public class RegistrationController {
	@Autowired
	private RecordRegistrationBO recordRegistrationBO;
	@PostMapping(path = "/v1/registrations")
	@ApiOperation(value = "This method is responsible for creating new records the integration between students and their school grade.")
	public @ResponseBody Boolean createRegistration(@RequestBody RegistrationDTO registration) {
		return recordRegistrationBO.createRegistrationDTO(registration);
	}
	@GetMapping(path = "/v1/registrations")
	@ApiOperation(value = "This method is responsible for listing all the integration records between students and their school grade.")
	public @ResponseBody Object[] getRegistrationDTO() {
		return recordRegistrationBO.getRegistrationDTO();
	}
	@GetMapping(path = "/v1/registrations/{id}")
	@ApiOperation(value = "This method is responsible for displaying a record between the integration between students and their school grade by id.")
	public @ResponseBody RegistrationDTO getRegistrationDTOById(@PathVariable("id") int id) {
		return recordRegistrationBO.getRegistrationDTOById(id);
	}
	@PutMapping(path = "/v1/registrations/{id}")
	@ApiOperation(value = "This method is responsible for updating a record between the integration between students and their school grade by id.")
	public @ResponseBody RegistrationDTO updateRegistrationDTO(
			@PathVariable("id") int id
			, @RequestBody RegistrationDTO registration) {
		return recordRegistrationBO.updateRegistrationDTO(id, registration);
	}
	@DeleteMapping(path = "/v1/registrations/{id}")
	@ApiOperation(value = "This method is responsible for erasing a record between the integration between students and their school grade by id.")
	public @ResponseBody RegistrationDTO deleteRegistrationDTO(@PathVariable("id") int id) {
		return recordRegistrationBO.deleteRegistrationDTO(id);
	}
}