package sk.lacike.example.springboot.domain3;

import java.util.List;

import org.mapstruct.Mapper;
import sk.lacike.example.springboot.domain1.CrmEntityBOFactory;
import sk.lacike.example.springboot.domain1.CrmEntityBOMapper;

@Mapper(componentModel = "spring", uses = {CrmEntityBOMapper.class, CrmEntityBOFactory.class, SimulationResultBOFactory.class} )
public interface SimulationResultBOMapper {

	SimulationResultBO map(SimulationResult entity);

	List<SimulationResultBO> map(Iterable<SimulationResult> entities);

	SimulationResult map(SimulationResultBO bo);

}
