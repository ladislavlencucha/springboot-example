package sk.lacike.example.springboot.domain1;

import lombok.experimental.Delegate;

/**
 * Business object for MyEntity. For simplification we don't create BO for each entity, we rather implement it directly
 * (in exchange for bleeding out some implementation details until the time arises when we need to introduce full BO).
 */

public class MyEntityBO {

	@Delegate
	private final MyEntity entity;

	public MyEntityBO(MyEntity entity) {
		this.entity = entity;
	}

	public MyEntityBO() {
		this.entity = new MyEntity();
	}

	public MyEntity unwrap() {
		return entity;
	}
}
