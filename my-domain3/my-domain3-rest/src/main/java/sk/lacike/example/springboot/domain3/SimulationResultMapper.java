package sk.lacike.example.springboot.domain3;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface SimulationResultMapper {

	SimulationResultJson map(SimulationResult entity);
	List<SimulationResultJson> map(Iterable<SimulationResult> entities);

	SimulationResult map(SimulationResultJson json);

}
