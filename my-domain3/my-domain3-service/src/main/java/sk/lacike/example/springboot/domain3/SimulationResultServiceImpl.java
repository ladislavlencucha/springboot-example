package sk.lacike.example.springboot.domain3;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SimulationResultServiceImpl implements SimulationResultService {

	private final SimulationResultRepository repository;

	@Transactional
	@Override
	public SimulationResult save(SimulationResult entity) {
		return repository.save(entity);
	}

	@Override
	public Iterable<SimulationResult> findAll() {
		return repository.findAll();
	}

	@Override
	public SimulationResult findById(Integer id) {
		return repository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Simulation result not found by id=" + id));
	}

	@Override
	public Iterable<SimulationResult> findByRequestorId(Integer requestorId) {
		return repository.findByRequestorId(requestorId);
	}

}
