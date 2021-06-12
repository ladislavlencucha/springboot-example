package sk.lacike.example.springboot.domain2;

import org.mapstruct.ObjectFactory;

public interface PurchaseOrderBOFactory {

	@ObjectFactory
	PurchaseOrderBO createPurchaseOrderBO();

}
