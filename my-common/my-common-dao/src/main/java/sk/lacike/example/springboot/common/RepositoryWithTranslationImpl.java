package sk.lacike.example.springboot.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.EntityPathBase;

public abstract class RepositoryWithTranslationImpl<E extends BasicEntity<P>, P, T extends AbstractTranslation<P>, Q1 extends EntityPathBase<E>, Q2 extends EntityPathBase<T>> implements RepositoryWithTranslation<E, P, T> {

	@PersistenceContext
	private EntityManager em;

	private final Class<E> entityClass;

	protected abstract Q1 entityPath();
	protected abstract Q2 translationPath();
	protected abstract BooleanExpression whereParentIdEquals(Q2 translationPath, P parentId);

	protected RepositoryWithTranslationImpl() {
		Type genericSuperclass = getClass().getGenericSuperclass();
		if (!(genericSuperclass instanceof ParameterizedType)) {
			throw new IllegalArgumentException("Unable to determine entity class for repository " + getClass().getName());
		}
		//noinspection unchecked
		this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public BasicEntityTranslationHolder<E, T> saveHolder(BasicEntityTranslationHolder<E, T> holder) {
		E saved = em.merge(holder.getEntity());

		holder.getTranslations().forEach(e -> e.setParentId(saved.getId()));
		List<T> savedTranslations = holder.getTranslations().stream()
			.map(e -> em.merge(e))
			.collect(Collectors.toList());

		return new BasicEntityTranslationHolder<>(saved, savedTranslations);
	}

	@Override
	public Optional<BasicEntityTranslationHolder<E, T>> findHolderById(P id) {
		E entity = em.find(entityClass, id);
		if (entity == null) {
			return Optional.empty();
		}

		Q2 translationPath = translationPath();
		List<T> translations = new JPAQuery(em)
			.from(translationPath)
			.where(whereParentIdEquals(translationPath, id))
			.list(translationPath);
		return Optional.of(new BasicEntityTranslationHolder<>(entity, translations));
	}

	@Override
	public List<BasicEntityTranslationHolder<E, T>> findHolderAll() {
		Q1 entityPath = entityPath();
		Q2 translationPath = translationPath();

		List<E> entities = new JPAQuery(em)
			.from(entityPath)
			.list(entityPath);

		Map<P, List<T>> translations = new JPAQuery(em)
			.from(translationPath)
			.list(translationPath)
			.stream()
			.collect(Collectors.groupingBy(AbstractTranslation::getParentId, Collectors.toList()));

		return entities.stream()
			.map(e -> new BasicEntityTranslationHolder<>(e, translations.computeIfAbsent(e.getId(), x -> new ArrayList<>())))
			.collect(Collectors.toList());
	}
}
