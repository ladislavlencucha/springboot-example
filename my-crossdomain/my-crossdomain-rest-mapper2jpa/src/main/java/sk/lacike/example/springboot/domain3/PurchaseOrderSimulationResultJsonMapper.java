package sk.lacike.example.springboot.domain3;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.lacike.example.springboot.domain2.PurchaseOrderJsonMapper;

@Mapper(componentModel="spring", uses = {SimulationResultJsonMapper.class, PurchaseOrderJsonMapper.class})
public interface PurchaseOrderSimulationResultJsonMapper {

	@Mapping(source = "entity.id.simulationResultId", target = "simulationResultId")
	@Mapping(source = "entity.id.purchaseOrderId", target = "purchaseOrderId")
	PurchaseOrderSimulationResultJson map(PurchaseOrderSimulationResult entity);

	PurchaseOrderSimulationResultDtoJson map(PurchaseOrderSimulationResultDto dto);

	List<PurchaseOrderSimulationResultDtoJson> map(Iterable<PurchaseOrderSimulationResultDto> entities);

	@Mapping(source = "json.simulationResultId", target = "id.simulationResultId")
	@Mapping(source = "json.purchaseOrderId", target = "id.purchaseOrderId")
	PurchaseOrderSimulationResult map(PurchaseOrderSimulationResultJson json);

}
