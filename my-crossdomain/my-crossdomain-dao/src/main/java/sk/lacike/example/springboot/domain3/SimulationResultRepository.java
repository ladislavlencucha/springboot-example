package sk.lacike.example.springboot.domain3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulationResultRepository extends CrudRepository<PurchaseOrderSimulationResult, Integer> {

	// Spring data generated implementation

}
