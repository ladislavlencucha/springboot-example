package sk.lacike.example.springboot.domain3;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseOrderSimulationResultApiImpl implements PurchaseOrderSimulationResultApi {

	private final PurchaseOrderSimulationResultService service;
	private final PurchaseOrderSimulationResultBOMapper mapper;

	@Override
	public PurchaseOrderSimulationResultBO link(PurchaseOrderSimulationResultBO entityBO) {
		PurchaseOrderSimulationResultDto saved = service.link(mapper.map(entityBO));

		return mapper.map(saved);
	}

	@Override
	public PurchaseOrderSimulationResultBO findById(Integer purchaseOrderId, Integer simulationResultId) {
		return mapper.map(service.findById(new PurchaseOrderSimulationResultPk(purchaseOrderId, simulationResultId)));
	}

}
