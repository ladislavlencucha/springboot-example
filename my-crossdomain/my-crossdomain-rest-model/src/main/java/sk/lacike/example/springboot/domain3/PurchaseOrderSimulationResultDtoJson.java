package sk.lacike.example.springboot.domain3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.lacike.example.springboot.domain2.PurchaseOrderJson;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderSimulationResultDtoJson {

	private PurchaseOrderJson purchaseOrder;
	private SimulationResultJson simulationResult;

}
