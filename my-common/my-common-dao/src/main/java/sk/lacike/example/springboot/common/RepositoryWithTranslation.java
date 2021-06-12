package sk.lacike.example.springboot.common;

import java.util.List;
import java.util.Optional;

public interface RepositoryWithTranslation<E extends BasicEntity<P>, P, T extends AbstractTranslation<P>> {
	BasicEntityTranslationHolder<E, T> saveHolder(BasicEntityTranslationHolder<E, T> holder);

	Optional<BasicEntityTranslationHolder<E, T>> findHolderById(P id);

	List<BasicEntityTranslationHolder<E, T>> findHolderAll();
}
