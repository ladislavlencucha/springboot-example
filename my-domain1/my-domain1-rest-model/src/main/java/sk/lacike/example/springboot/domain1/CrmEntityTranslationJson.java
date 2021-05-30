package sk.lacike.example.springboot.domain1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrmEntityTranslationJson {

	private Integer id;
	private String languageCode;
	private String instructions;

}
