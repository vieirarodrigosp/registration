package vieirabarbosa.com.br.registration.business.object;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vieirabarbosa.com.br.registration.DTO.RegistrationDTO;

@Component
public class RecordRegistrationBO {
	List<RegistrationDTO> registrationList = new ArrayList<RegistrationDTO>();
	public boolean createRegistrationDTO(RegistrationDTO registration) {
		return registrationList.add(registration);
	}
	public Object[] getRegistrationDTO() {
		return registrationList.toArray();
	}
	public RegistrationDTO getRegistrationDTOById(int id) {
		return registrationList.get(id);
	}
	public RegistrationDTO updateRegistrationDTO(int id, RegistrationDTO registration) {
		return registrationList.set(id, registration);
	}
	public RegistrationDTO deleteRegistrationDTO(int id) {
		return registrationList.remove(id);
	}
}