package sk.lacike.example.springboot.domain2;

import java.util.List;

import org.mapstruct.Mapper;
import sk.lacike.example.springboot.domain1.CrmEntityBOFactory;
import sk.lacike.example.springboot.domain1.CrmEntityBOMapper;

@Mapper(componentModel = "spring", uses = {CrmEntityBOMapper.class, CrmEntityBOFactory.class, PurchaseOrderBOFactory.class} )
public interface PurchaseOrderBOMapper {

	PurchaseOrderBO map(PurchaseOrder entity);

	List<PurchaseOrderBO> map(Iterable<PurchaseOrder> entities);

	PurchaseOrder map(PurchaseOrderBO bo);

}
