package sk.lacike.example.springboot.domain3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderSimulationResultJson {

	private Integer purchaseOrderId;
	private Integer simulationResultId;

}
