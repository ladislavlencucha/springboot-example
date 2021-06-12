package sk.lacike.example.springboot.domain3;

public interface PurchaseOrderSimulationResultApi {

	PurchaseOrderSimulationResultBO link(PurchaseOrderSimulationResultBO entityBO);
	PurchaseOrderSimulationResultBO findById(Integer purchaseOrderId, Integer simulationResultId);

}
