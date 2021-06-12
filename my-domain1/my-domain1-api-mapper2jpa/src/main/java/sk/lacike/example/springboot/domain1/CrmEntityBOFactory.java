package sk.lacike.example.springboot.domain1;

import org.mapstruct.ObjectFactory;

public interface CrmEntityBOFactory {

	@ObjectFactory
	CrmEntityBO createCrmEntityBO();

	@ObjectFactory
	CrmEntityBO.CrmEntityTranslationBO createCrmEntityTranslationBO();

}
