package sk.lacike.example.springboot.domain3;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderSimulationResultPk implements Serializable {

	private Integer purchaseOrderId;
	private Integer simulationResultId;

}
