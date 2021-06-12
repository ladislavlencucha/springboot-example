package sk.lacike.example.springboot.domain2;

import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PurchaseOrderBOFactoryImpl implements PurchaseOrderBOFactory {

	@Override
	@ObjectFactory
	public PurchaseOrderBO createPurchaseOrderBO() {
		return new PurchaseOrderBOImpl();
	}

}
