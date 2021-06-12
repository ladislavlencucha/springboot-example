package sk.lacike.example.springboot.domain3;

public interface SimulationResultService {

	SimulationResult save(SimulationResult entityBO);
	Iterable<SimulationResult> findAll();
	SimulationResult findById(Integer id);

}
