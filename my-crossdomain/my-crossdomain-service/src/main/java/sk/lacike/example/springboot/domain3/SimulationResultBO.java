package sk.lacike.example.springboot.domain3;

import lombok.experimental.Delegate;

public class SimulationResultBO {

	@Delegate
	private final PurchaseOrderSimulationResult entity;

	public SimulationResultBO(PurchaseOrderSimulationResult entity) {
		this.entity = entity;
	}

	public SimulationResultBO() {
		this.entity = new PurchaseOrderSimulationResult();
	}

	public PurchaseOrderSimulationResult unwrap() {
		return entity;
	}

}
