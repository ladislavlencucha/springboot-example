package sk.lacike.example.springboot.common;

import java.util.Objects;

public interface Entity<P> {

	P getId();
	void setId(P id);

	default boolean isSameRecord(Entity<P> other) {
		if (other == null) {
			return false;
		}

		if (!other.getClass().equals(getClass())) {
			return false;
		}

		return Objects.equals(getId(), other.getId());
	}

}
