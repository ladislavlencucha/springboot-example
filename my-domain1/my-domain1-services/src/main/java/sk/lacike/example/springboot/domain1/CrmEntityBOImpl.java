package sk.lacike.example.springboot.domain1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.experimental.Delegate;
import sk.lacike.example.springboot.common.EntityTranslationHolder;

/**
 * Business object for MyEntity. For simplification we don't create BO for each entity, we rather implement it directly
 * (in exchange for bleeding out some implementation details until the time arises when we need to introduce full BO).
 */

public class CrmEntityBOImpl implements CrmEntityBO {

	@Delegate
	private final CrmEntity entity;

	private final Set<CrmEntityTranslationBO> translations;

	CrmEntityBOImpl(EntityTranslationHolder<CrmEntity, CrmEntityTranslation> holder) {
		this(holder.getEntity(), holder.getTranslations());
	}

	CrmEntityBOImpl(CrmEntity entity, Collection<CrmEntityTranslation> translations) {
		this.entity = entity;
		this.translations = translations.stream()
			.map(CrmEntityTranslationBOImpl::new)
			.collect(Collectors.toSet());
	}

	public CrmEntityBOImpl() {
		this.entity = new CrmEntity();
		this.translations = new HashSet<>();
	}

	@Override
	public Set<CrmEntityTranslationBO> getTranslations() {
		return translations;
	}

	EntityTranslationHolder<CrmEntity, CrmEntityTranslation> unwrap() {
		return new EntityTranslationHolder<>(entity, translations.stream()
			.map(CrmEntityTranslationBOImpl.class::cast)
			.map(CrmEntityTranslationBOImpl::unwrap)
			.collect(Collectors.toSet()));
	}

	public static class CrmEntityTranslationBOImpl implements CrmEntityTranslationBO {

		@Delegate
		private final CrmEntityTranslation translation;

		public CrmEntityTranslationBOImpl() {
			this.translation = new CrmEntityTranslation();
		}

		CrmEntityTranslationBOImpl(CrmEntityTranslation translation) {
			this.translation = translation;
		}

		CrmEntityTranslation unwrap() {
			return translation;
		}
	}
}
