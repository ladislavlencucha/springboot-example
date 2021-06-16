package sk.lacike.example.springboot.domain1;

import sk.lacike.example.springboot.common.BasicEntityTranslationHolder;

public interface CrmEntityService {

	BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> save(BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> holder);
	Iterable<BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation>> findAll();
	BasicEntityTranslationHolder<CrmEntity, CrmEntityTranslation> findById(Integer id);

}
