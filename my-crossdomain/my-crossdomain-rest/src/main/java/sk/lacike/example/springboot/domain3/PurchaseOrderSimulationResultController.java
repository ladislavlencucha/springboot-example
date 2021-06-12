package sk.lacike.example.springboot.domain3;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PurchaseOrderSimulationResultController {

	private final PurchaseOrderSimulationResultService service;
	private final PurchaseOrderSimulationResultJsonMapper mapper;

	@GetMapping("/crm-entities/{entityId}/purchase-order-simulation-results")
	public List<PurchaseOrderSimulationResultDtoJson> findByEntityId(@PathVariable Integer entityId) {
		Iterable<PurchaseOrderSimulationResultDto> result = service.findByEntityId(entityId);

		return mapper.map(result);
	}

	@PostMapping("/purchase-order-simulation-results")
	public PurchaseOrderSimulationResultDtoJson link(@RequestBody PurchaseOrderSimulationResultJson purchaseOrderSimulationResultJson) {
		PurchaseOrderSimulationResult entity = mapper.map(purchaseOrderSimulationResultJson);
		PurchaseOrderSimulationResultDto saved = service.link(entity);

		return mapper.map(saved);
	}
}
