package sk.lacike.example.springboot.domain1;

import sk.lacike.example.springboot.common.RepositoryWithTranslation;

public interface CrmEntityRepositoryCustomizer extends RepositoryWithTranslation<CrmEntity, Integer, CrmEntityTranslation> {
	// Empty as everything necessary is taken from RepositoryWithTranslation, add more customized methods here
}
