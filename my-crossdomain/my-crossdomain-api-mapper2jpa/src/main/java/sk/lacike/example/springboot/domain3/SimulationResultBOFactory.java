package sk.lacike.example.springboot.domain3;

import org.mapstruct.ObjectFactory;

public interface SimulationResultBOFactory {

	@ObjectFactory
	PurchaseOrderSimulationResultBO createPurchaseOrderBO();

}
