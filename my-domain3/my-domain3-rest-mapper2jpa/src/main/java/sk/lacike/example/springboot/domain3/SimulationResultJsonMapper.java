package sk.lacike.example.springboot.domain3;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface SimulationResultJsonMapper {

	@Mapping(source = "requestor.id", target = "requestorId")
	SimulationResultJson map(SimulationResult entity);

	List<SimulationResultJson> map(Iterable<SimulationResult> entities);

	@Mapping(source = "json.requestorId", target = "requestor.id")
	SimulationResult map(SimulationResultJson json);

}
