package sk.lacike.example.springboot.domain1;

import java.util.Set;

import lombok.Data;

/**
 * Business object for MyEntity. For simplification we don't create BO for each entity, we rather implement it directly
 * (in exchange for bleeding out some implementation details until the time arises when we need to introduce full BO).
 */
@Data
public class CrmEntityBOImpl implements CrmEntityBO {

	private Integer id;
	private String name;
	private String description;
	private Set<CrmEntityTranslationBO> translations;

	@Data
	public static class CrmEntityTranslationBOImpl implements CrmEntityTranslationBO {

		private String languageCode;
		private String instructions;

	}
}
