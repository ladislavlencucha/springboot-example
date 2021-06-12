package sk.lacike.example.springboot.domain3;

import lombok.Data;

@Data
public class SimulationResultBOImpl implements SimulationResultBO {

	private Integer simulationResultId;
	private Integer purchaseOrderId;

}
