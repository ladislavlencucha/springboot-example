package sk.lacike.example.springboot.domain3;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderSimulationResultCustomizer {

	List<PurchaseOrderSimulationResultDto> findByEntityId(Integer requestorId);
	Optional<PurchaseOrderSimulationResultDto> findDto(PurchaseOrderSimulationResultPk id);

}
