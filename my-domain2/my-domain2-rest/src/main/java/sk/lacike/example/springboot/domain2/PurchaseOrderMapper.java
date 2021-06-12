package sk.lacike.example.springboot.domain2;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface PurchaseOrderMapper {

	@Mapping(source = "owner.id", target = "ownerId")
	PurchaseOrderJson map(PurchaseOrderBO entity);
	List<PurchaseOrderJson> map(List<PurchaseOrderBO> entityBOs);

	@Mapping(source = "ownerId", target = "owner.id")
	PurchaseOrderBO map(PurchaseOrderJson json);

}
