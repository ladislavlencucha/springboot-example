package sk.lacike.example.springboot.common;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EntityTranslationHolder<E extends Entity<?>, T extends AbstractTranslation<?>> {

	private final E entity;
	private final Collection<T> translations;

}
