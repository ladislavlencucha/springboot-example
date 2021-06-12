package sk.lacike.example.springboot.domain2;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface PurchaseOrderMapper {

	@Mapping(source = "owner.id", target = "ownerId")
	PurchaseOrderJson map(PurchaseOrder entity);
	List<PurchaseOrderJson> map(Iterable<PurchaseOrder> entities);

	@Mapping(source = "ownerId", target = "owner.id")
	PurchaseOrder map(PurchaseOrderJson json);

}
