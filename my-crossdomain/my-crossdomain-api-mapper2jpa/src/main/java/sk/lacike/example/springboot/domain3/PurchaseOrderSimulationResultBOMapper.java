package sk.lacike.example.springboot.domain3;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.lacike.example.springboot.domain1.CrmEntityBOFactory;
import sk.lacike.example.springboot.domain1.CrmEntityBOMapper;

@Mapper(componentModel = "spring", uses = {CrmEntityBOMapper.class, CrmEntityBOFactory.class, SimulationResultBOFactory.class} )
public interface PurchaseOrderSimulationResultBOMapper {

	@Mapping(source = "entity.id.simulationResultId", target = "simulationResultId")
	@Mapping(source = "entity.id.purchaseOrderId", target = "purchaseOrderId")
	PurchaseOrderSimulationResultBO map(PurchaseOrderSimulationResult entity);

	@Mapping(source = "dto.simulationResult.id", target = "simulationResultId")
	@Mapping(source = "dto.purchaseOrder.id", target = "purchaseOrderId")
	PurchaseOrderSimulationResultBO map(PurchaseOrderSimulationResultDto dto);

	List<PurchaseOrderSimulationResultBO> map(Iterable<PurchaseOrderSimulationResult> entities);

	@Mapping(source = "bo.simulationResultId", target = "id.simulationResultId")
	@Mapping(source = "bo.purchaseOrderId", target = "id.purchaseOrderId")
	PurchaseOrderSimulationResult map(PurchaseOrderSimulationResultBO bo);

}
