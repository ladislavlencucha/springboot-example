package sk.lacike.example.springboot.domain3;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseOrderSimulationResultServiceImpl implements PurchaseOrderSimulationResultService {

	private final PurchaseOrderSimulationResultRepository repository;

	@Transactional
	@Override
	public PurchaseOrderSimulationResultDto link(PurchaseOrderSimulationResult dto) {
		PurchaseOrderSimulationResult result = repository.save(dto);

		return repository.findDto(result.getId())
			.orElseThrow(() -> new IllegalArgumentException("Purchase order simulation result link not not persisted for " + result.getId()));
	}

	@Override
	public Iterable<PurchaseOrderSimulationResultDto> findByEntityId(Integer entityId) {
		return repository.findByEntityId(entityId);
	}

	@Override
	public PurchaseOrderSimulationResultDto findById(PurchaseOrderSimulationResultPk id) {
		return repository.findDto(id)
			.orElseThrow(() -> new IllegalArgumentException("Purchase order simulation result not found by id=" + id));
	}

}
