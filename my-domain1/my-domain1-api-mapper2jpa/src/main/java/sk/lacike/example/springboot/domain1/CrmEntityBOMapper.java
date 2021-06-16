package sk.lacike.example.springboot.domain1;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.lacike.example.springboot.common.BasicEntityTranslationHolder;

@Mapper(componentModel = "spring", uses = CrmEntityBOFactory.class)
public interface CrmEntityBOMapper {

	@Mapping(source = "entity", target = ".")
	@Mapping(source = "translations", target = "translations")
	CrmEntityBO map(CrmEntity entity, Collection<CrmEntityTranslation> translations);

	@Mapping(source = "bo", target = "entity")
	@Mapping(source = "bo.translations", target = "translations")
	BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> map(CrmEntityBO bo);

	@Mapping(source = "holder.entity", target = ".")
	@Mapping(source = "holder.translations", target = "translations")
	CrmEntityBO map(BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> holder);

	CrmEntityTranslation map(CrmEntityBO.CrmEntityTranslationBO bo);

	CrmEntityBO.CrmEntityTranslationBO map(CrmEntityTranslation entity);

}
