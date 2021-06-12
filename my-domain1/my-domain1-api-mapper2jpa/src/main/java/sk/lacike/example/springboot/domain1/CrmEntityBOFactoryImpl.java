package sk.lacike.example.springboot.domain1;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CrmEntityBOFactoryImpl implements CrmEntityBOFactory {

	@Override
	@ObjectFactory
	public CrmEntityBO createCrmEntityBO() {
		return new CrmEntityBOImpl();
	}

	@Override
	@ObjectFactory
	public CrmEntityBO.CrmEntityTranslationBO createCrmEntityTranslationBO() {
		return new CrmEntityBOImpl.CrmEntityTranslationBOImpl();
	}

}
