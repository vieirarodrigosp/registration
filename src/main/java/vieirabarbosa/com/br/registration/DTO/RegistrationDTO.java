package vieirabarbosa.com.br.registration.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RegistrationDTO {
	public int id;
	public int idStudent;
	public int idGrade;
}