package vieirabarbosa.com.br.registration.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GradeDTO {
	String year;
	String term;
	String grade;
	String ciclo;
}