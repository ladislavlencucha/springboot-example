package sk.lacike.example.springboot.domain3;

public interface PurchaseOrderSimulationResultService {

	PurchaseOrderSimulationResultDto link(PurchaseOrderSimulationResult dto);
	PurchaseOrderSimulationResultDto findById(PurchaseOrderSimulationResultPk id);
	Iterable<PurchaseOrderSimulationResultDto> findByEntityId(Integer requestorId);

}
