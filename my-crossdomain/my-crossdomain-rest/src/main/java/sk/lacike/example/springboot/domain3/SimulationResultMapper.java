package sk.lacike.example.springboot.domain3;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface SimulationResultMapper {

	@Mapping(source = "entity.id.simulationResultId", target = "simulationResultId")
	@Mapping(source = "entity.id.purchaseOrderId", target = "purchaseOrderId")
	PurchaseOrderSimulationResultJson map(PurchaseOrderSimulationResult entity);
	List<PurchaseOrderSimulationResultJson> map(Iterable<PurchaseOrderSimulationResult> entities);

	@Mapping(source = "json.simulationResultId", target = "id.simulationResultId")
	@Mapping(source = "json.purchaseOrderId", target = "id.purchaseOrderId")
	PurchaseOrderSimulationResult map(PurchaseOrderSimulationResultJson json);

}
