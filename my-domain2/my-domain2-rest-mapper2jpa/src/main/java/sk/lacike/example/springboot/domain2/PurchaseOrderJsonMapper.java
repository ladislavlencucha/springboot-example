package sk.lacike.example.springboot.domain2;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface PurchaseOrderJsonMapper {

	@Mapping(source = "owner.id", target = "ownerId")
	PurchaseOrderJson map(PurchaseOrder entity);

	List<PurchaseOrderJson> map(Iterable<PurchaseOrder> entities);

	@Mapping(source = "json.ownerId", target = "owner.id")
	PurchaseOrder map(PurchaseOrderJson json);

}
