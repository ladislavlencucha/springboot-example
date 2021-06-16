package sk.lacike.example.springboot.domain3;

import com.mysema.query.annotations.QueryProjection;
import lombok.Data;
import sk.lacike.example.springboot.domain2.PurchaseOrder;

@Data
public class PurchaseOrderSimulationResultDto {

	private final PurchaseOrder purchaseOrder;
	private final SimulationResult simulationResult;

	@QueryProjection
	public PurchaseOrderSimulationResultDto(PurchaseOrder purchaseOrder, SimulationResult simulationResult) {
		this.purchaseOrder = purchaseOrder;
		this.simulationResult = simulationResult;
	}
}
