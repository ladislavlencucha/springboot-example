package sk.lacike.example.springboot.domain3;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SimulationResultApiImpl implements SimulationResultApi {

	private final SimulationResultService service;
	private final SimulationResultBOMapper mapper;

	@Override
	public SimulationResultBO save(SimulationResultBO entityBO) {
		PurchaseOrderSimulationResult saved = service.save(mapper.map(entityBO));

		return mapper.map(saved);
	}

	@Override
	public List<SimulationResultBO> findAll() {
		return mapper.map(service.findAll());

	}

	@Override
	public SimulationResultBO findById(Integer id) {
		return mapper.map(service.findById(id));
	}

}
