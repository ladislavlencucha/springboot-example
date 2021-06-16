package sk.lacike.example.springboot.domain1;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrmEntityJson {
	private Integer id;
	private String name;
	private String description;

	private Set<CrmEntityTranslationJson> translations;
}
