package sk.lacike.example.springboot.domain3;

import lombok.Data;
import sk.lacike.example.springboot.domain1.CrmEntity;

@Data
public class SimulationResultBOImpl implements SimulationResultBO {

	private Integer id;
	private String name;
	private String description;
	private CrmEntity requestor;

}
