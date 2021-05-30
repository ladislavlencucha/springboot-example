package sk.lacike.example.springboot.common;

import java.util.List;
import java.util.Optional;

public interface RepositoryWithTranslation<E extends Entity<P>, P, T extends AbstractTranslation<P>> {
	EntityTranslationHolder<E, T> saveHolder(EntityTranslationHolder<E, T> holder);

	Optional<EntityTranslationHolder<E, T>> findHolderById(P id);

	List<EntityTranslationHolder<E, T>> findHolderAll();
}
