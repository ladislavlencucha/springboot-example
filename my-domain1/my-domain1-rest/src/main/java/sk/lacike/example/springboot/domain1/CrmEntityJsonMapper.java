package sk.lacike.example.springboot.domain1;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.lacike.example.springboot.common.BasicEntityTranslationHolder;

@Mapper(componentModel="spring")
public interface CrmEntityJsonMapper {

	@Mapping(source = "holder.entity", target = ".")
	@Mapping(source = "holder.translations", target = "translations")
	CrmEntityJson map(BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> holder);

	List<CrmEntityJson> map(Iterable<BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation>> holders);

	@Mapping(source = "json", target = "entity")
	@Mapping(source = "json.translations", target = "translations")
	BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> map(CrmEntityJson json);

}
