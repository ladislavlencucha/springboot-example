package sk.lacike.example.springboot.domain1;

import java.util.Set;

public interface CrmEntityBO {

	Set<CrmEntityTranslationBO> getTranslations();

	Integer getId();
	String getName();
	String getDescription();

	void setId(Integer id);
	void setName(String name);
	void setDescription(String description);

	interface CrmEntityTranslationBO {

		String getInstructions();
		String getLanguageCode();

		void setInstructions(String instructions);
		void setLanguageCode(String languageCode);

	}
}
