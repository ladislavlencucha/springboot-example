package sk.lacike.example.springboot.domain3;

import java.util.List;

public interface SimulationResultApi {

	SimulationResultBO save(SimulationResultBO entityBO);
	List<SimulationResultBO> findAll();
	SimulationResultBO findById(Integer id);

}
