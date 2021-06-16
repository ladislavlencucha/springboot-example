package sk.lacike.example.springboot.domain1;

import com.mysema.query.types.expr.BooleanExpression;
import sk.lacike.example.springboot.common.RepositoryWithTranslationImpl;

public class CrmEntityRepositoryCustomizerImpl extends RepositoryWithTranslationImpl<CrmEntity, Integer, CrmEntityTranslation, QCrmEntity, QCrmEntityTranslation> implements CrmEntityRepositoryCustomizer {

	@Override
	protected QCrmEntity entityPath() {
		return QCrmEntity.crmEntity;
	}

	@Override
	protected QCrmEntityTranslation translationPath() {
		return QCrmEntityTranslation.crmEntityTranslation;
	}

	@Override
	protected BooleanExpression whereParentIdEquals(QCrmEntityTranslation translationPath, Integer parentId) {
		return translationPath.id.parentId.eq(parentId);
	}
}
