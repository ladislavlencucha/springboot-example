package sk.lacike.example.springboot.domain3;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.lacike.example.springboot.common.ResultListJson;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class SimulationResultController {

	private final SimulationResultService service;
	private final SimulationResultJsonMapper mapper;

	@GetMapping("/simulation-results")
	public ResultListJson<SimulationResultJson> findAll() {
		Iterable<SimulationResult> result = service.findAll();

		return ResultListJson.<SimulationResultJson>builder()
			.items(mapper.map(result))
			.build();
	}

	@GetMapping("/simulation-results/{id}")
	public SimulationResultJson findById(@PathVariable Integer id) {
		SimulationResult result = service.findById(id);

		return mapper.map(result);
	}

	@GetMapping("/crm-entities/{requestorId}/simulation-results")
	public ResultListJson<SimulationResultJson> findByRequestorId(@PathVariable Integer requestorId) {
		Iterable<SimulationResult> result = service.findByRequestorId(requestorId);

		return ResultListJson.<SimulationResultJson>builder()
			.items(mapper.map(result))
			.build();
	}

	@PostMapping("/simulation-results")
	public SimulationResultJson saveEntity(@RequestBody SimulationResultJson simulationResultJson) {
		SimulationResult entityBO = mapper.map(simulationResultJson);
		SimulationResult saved = service.save(entityBO);

		return mapper.map(saved);
	}
}
