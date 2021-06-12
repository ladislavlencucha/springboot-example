package sk.lacike.example.springboot.domain3;

import lombok.experimental.Delegate;

public class SimulationResultBO {

	@Delegate
	private final SimulationResult entity;

	public SimulationResultBO(SimulationResult entity) {
		this.entity = entity;
	}

	public SimulationResultBO() {
		this.entity = new SimulationResult();
	}

	public SimulationResult unwrap() {
		return entity;
	}

}
