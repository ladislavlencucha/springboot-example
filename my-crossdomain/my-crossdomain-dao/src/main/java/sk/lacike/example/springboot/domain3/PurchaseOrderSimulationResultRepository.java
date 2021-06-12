package sk.lacike.example.springboot.domain3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderSimulationResultRepository extends CrudRepository<PurchaseOrderSimulationResult, PurchaseOrderSimulationResultPk>, PurchaseOrderSimulationResultCustomizer {

	// Spring data generated implementation

}
