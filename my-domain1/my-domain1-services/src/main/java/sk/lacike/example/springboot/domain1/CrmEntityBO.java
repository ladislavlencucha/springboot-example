package sk.lacike.example.springboot.domain1;

import java.util.Set;

public interface CrmEntityBO {

	Set<CrmEntityBOImpl.CrmEntityTranslationBO> getTranslations();

	Integer getId();

	String getName();

	String getDescription();

	void setId(Integer id);

	void setName(String name);

	void setDescription(String description);

	interface CrmEntityTranslationBO {
		String getInstructions();

		void setInstructions(String instructions);

		Integer getParentId();

		void setParentId(Integer parentId);

		String getLanguageCode();

		void setLanguageCode(String languageCode);

	}
}
