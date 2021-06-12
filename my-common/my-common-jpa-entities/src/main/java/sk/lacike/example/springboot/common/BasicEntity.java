package sk.lacike.example.springboot.common;

import java.util.Objects;

public interface BasicEntity<P> {

	P getId();
	void setId(P id);

	default boolean isSameRecord(BasicEntity<P> other) {
		if (other == null) {
			return false;
		}

		if (!other.getClass().equals(getClass())) {
			return false;
		}

		return Objects.equals(getId(), other.getId());
	}

}
