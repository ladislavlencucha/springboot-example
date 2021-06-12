package sk.lacike.example.springboot.domain3;

import lombok.Data;

@Data
public class PurchaseOrderSimulationResultBOImpl implements PurchaseOrderSimulationResultBO {

	private Integer simulationResultId;
	private Integer purchaseOrderId;

}
