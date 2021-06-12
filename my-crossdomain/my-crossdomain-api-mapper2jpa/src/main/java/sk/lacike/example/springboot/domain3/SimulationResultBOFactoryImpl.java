package sk.lacike.example.springboot.domain3;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SimulationResultBOFactoryImpl implements SimulationResultBOFactory {

	@Override
	@ObjectFactory
	public PurchaseOrderSimulationResultBO createPurchaseOrderBO() {
		return new PurchaseOrderSimulationResultBOImpl();
	}

}
