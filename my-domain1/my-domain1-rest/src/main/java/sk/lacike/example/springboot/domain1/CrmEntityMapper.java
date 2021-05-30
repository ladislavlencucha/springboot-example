package sk.lacike.example.springboot.domain1;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring", uses = CrmEntityFactory.class)
public interface CrmEntityMapper {

	CrmEntityJson map(CrmEntityBO entity);
	List<CrmEntityJson> map(List<CrmEntityBO> entityBOs);

	CrmEntityBO map(CrmEntityJson json);

}
