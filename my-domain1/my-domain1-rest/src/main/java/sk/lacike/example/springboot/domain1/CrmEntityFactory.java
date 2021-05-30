package sk.lacike.example.springboot.domain1;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CrmEntityFactory {

	private final CrmEntityService service;

	@ObjectFactory
	public CrmEntityBO createCrmEntityBO() {
		return service.newCrmEntityBO();
	}

	public CrmEntityBO.CrmEntityTranslationBO createCrmEntityTranslationBO() {
		return service.newCrmEntityTranslationBO();
	}

}
