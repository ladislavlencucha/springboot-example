package sk.lacike.example.springboot.common;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractTranslation<P> implements BasicEntity<TranslationPk<P>> {

	@EmbeddedId
	private TranslationPk<P> id;

	@Override
	public TranslationPk<P> getId() {
		return id;
	}

	@Override
	public void setId(TranslationPk<P> id) {
		this.id = id;
	}

	public P getParentId() {
		return getId() != null ? getId().getParentId() : null;
	}

	public void setParentId(P parentId) {
		ensureIdExists().setParentId(parentId);
	}

	public String getLanguageCode() {
		return getId() != null ? getId().getLanguageCode() : null;
	}

	public void setLanguageCode(String languageCode) {
		ensureIdExists().setLanguageCode(languageCode);
	}

	private TranslationPk<P> ensureIdExists() {
		if (getId() == null) {
			setId(new TranslationPk<>());
		}
		return getId();
	}

}
