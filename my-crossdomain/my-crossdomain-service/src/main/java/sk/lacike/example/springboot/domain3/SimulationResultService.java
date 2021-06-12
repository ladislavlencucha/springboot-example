package sk.lacike.example.springboot.domain3;

public interface SimulationResultService {

	PurchaseOrderSimulationResult save(PurchaseOrderSimulationResult entityBO);
	Iterable<PurchaseOrderSimulationResult> findAll();
	PurchaseOrderSimulationResult findById(Integer id);

}
